import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Setting gameSetting;

    public Game() {
        this.gameSetting = new All();
    }

    public void play() {
        ArrayList<String> player = this.gameSetting.getPlayer().get(0);
        ArrayList<ArrayList<ArrayList<String>>> stats = getPlayerStats(player.get(0));
        int counter = 0;
        for(ArrayList<ArrayList<String>> entry: stats) {
            if(counter == 0) {
                System.out.println("Name: ");
            }
            if(counter == 1) {
                System.out.println("Batting: ");
            }
            if(counter == 2) {
                System.out.println("Pitching: ");
            }
            for(ArrayList<String> entry2: entry) {
                System.out.println(entry2);
            }
            counter++;
        }

        String firstname1 = stats.get(0).get(0).get(0).toLowerCase();
        String lastname1 = stats.get(0).get(0).get(1).toLowerCase();

        boolean playing = true;
        while(playing) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter firstname: ");
            String firstname = scan.nextLine().toLowerCase();
            System.out.print("Enter lastname: ");
            String lastname = scan.nextLine().toLowerCase();

            if(firstname.equals(firstname1)) {
                if(lastname.equals(lastname1)) {
                    System.out.println("You Got It!");
                    playing = false;
                }
                else {
                    System.out.println("You Guessed Wrong!");   
                }
            }
            else {
                System.out.println("You Guessed Wrong!");
            }

        }
    }
    public void changeSetting(Setting setting) {
        this.gameSetting = setting;
    }

    /*
     * checks if the player has the relevant amount of games played
     */
    private boolean relevancyCheck(String playerID) {
        String sql1 = String.format("SELECT SUM(g) FROM batting WHERE batting.playerID ='%s'", playerID);
        String sql2 = String.format("SELECT SUM(g) FROM pitching WHERE pitching.playerID ='%s'", playerID);

        int battingGames = 0;
        if (db_Utils.exec_get_all(sql1).get(0).get(0) != null) {
            battingGames = Integer.parseInt(db_Utils.exec_get_all(sql1).get(0).get(0));
        }

        
        int pitchingGames = 0;
        if(db_Utils.exec_get_all(sql2).get(0).get(0) != null) {
            pitchingGames = Integer.parseInt(db_Utils.exec_get_all(sql2).get(0).get(0));
        }

        boolean result = false;

        if(battingGames > 999) {
            result = true;
        }
        if(pitchingGames > 200) {
            result = true;
        }
        return result;
    }
    /*
     * gets the player's stats
     */
    private ArrayList<ArrayList<ArrayList<String>>> getPlayerStats(String playerID) {
        ArrayList<ArrayList<ArrayList<String>>> result = new ArrayList<ArrayList<ArrayList<String>>>();

        // checks the relevance of a player and gets a new player until they have played enough games
        boolean relevancyCheck = relevancyCheck(playerID);
        String newPlayerID = playerID;
        while(relevancyCheck == false) {
            ArrayList<String> newPlayer = this.gameSetting.getPlayer().get(0);
            newPlayerID = newPlayer.get(0);
            relevancyCheck = relevancyCheck(newPlayerID);
        }
        result.add(getName(newPlayerID));

        // get the player's hitting stats
        String sqlBatting = String.format("SELECT yearID, teamID, g, ab, r, h, _2b, _3b, hr, rbi, bb, sb FROM batting WHERE batting.playerID = '%s'", newPlayerID);
        ArrayList<ArrayList<String>> batting = db_Utils.exec_get_all(sqlBatting);
        result.add(batting);
        // get the player's pitching stats
        String sqlPitching = String.format("SELECT yearID, teamID, g, w, l, sv, so, era, outs FROM pitching WHERE pitching.playerID = '%s'", newPlayerID);
        ArrayList<ArrayList<String>> pitching = db_Utils.exec_get_all(sqlPitching);
        result.add(pitching);

        return result;
    }
    /*
     * gets player name in format <firstname lastname>
     */
    private ArrayList<ArrayList<String>> getName(String playerID) {
        String sql = String.format("SELECT firstname, lastname FROM players WHERE players.playerID = '%s'",playerID);
        ArrayList<ArrayList<String>> name = db_Utils.exec_get_all(sql);
        return name;
    }


    public static void main(String[] args) {
        Game g = new Game();
        g.changeSetting(new _2010s());
        g.play();
    }
}
