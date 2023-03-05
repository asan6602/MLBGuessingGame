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
        System.out.println();
        int counter = 0;
        String name = " ";
        String hint = "";
        int hintsUsed = 0;
        for(ArrayList<ArrayList<String>> entry: stats) {
            if(counter == 0) {
                System.out.println("Name: ");
                name = entry.get(0).get(0);
                name +=  " " + entry.get(0).get(1);
                hint = nameAsSpace(name);
                System.out.println(hint);
            }
            if(counter == 1) {
                System.out.println("Batting: ");
                System.out.println("[Year, Team,   G,  AB,   R,   H,  2B,  3B,  HR, RBI,  BB,  SB,   AVG]");
                printHitting(entry);
            }
            if(counter == 2) {
                System.out.println("Pitching: ");
                System.out.println("[Year, Team,   G,   W,   L,  SV,  SO,  ERA,  IP]");
                printPitching(entry);
            }
            counter++;
        }

        String firstname1 = stats.get(0).get(0).get(0).toLowerCase();
        String lastname1 = stats.get(0).get(0).get(1).toLowerCase();

        boolean playing = true;
        long start = System.nanoTime() /1000000000;
        while(playing) {
            Scanner scan = new Scanner(System.in);

            System.out.println("<1> guess, <2> hint, <3> give up");
            System.out.print("Enter: ");
            String command = scan.nextLine().toLowerCase();

            if(command.equals("1")) {
                System.out.print("Enter firstname: ");
                String firstname = scan.nextLine().toLowerCase();
                System.out.print("Enter lastname: ");
                String lastname = scan.nextLine().toLowerCase();

                if(firstname.equals(firstname1)) {
                    if(lastname.equals(lastname1)) {
                        long end = (System.nanoTime()/1000000000);
                        long seconds = end - start;
                        System.out.println();
                        System.out.println("CONGRATULATIONS!");
                        System.out.println("The player is " + name + ".");
                        System.out.println("You got it in " + seconds + " seconds.");
                        System.out.println("You used " + hintsUsed + " hints.");
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
            else if(command.equals("2")) {
                hint = hint(name, hint);
                System.out.println(hint);
                hintsUsed += 1;
            }
            else if(command.equals("3")) {
                System.out.println("The player is " + name + ".");
                playing = false;
            }
            else{
                System.out.println("Not a valid command!");
            }

        }
    }

    public String nameAsSpace(String name) {
        String hint = "";
        for (int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            if(c == ' ') {
                hint += " ";
            }  
            else {
                hint += "_";
            }      
        }
        return hint;
    }

    public String hint(String name, String hint) {
        String newHint = "";
        Boolean changed = false;
        for (int i = 0; i < hint.length(); i++){
            char c = hint.charAt(i);
            if(c == '_' && changed == false) {
                newHint += name.charAt(i);
                changed = true;
            }  
            else if(c == ' ') {
                newHint += " ";
            }  
            else if (c == '_'){
                newHint += "_";
            }
            else {
                newHint += name.charAt(i);
            }       
        }
        return newHint;
    }

    public void printHitting(ArrayList<ArrayList<String>> entry) {
        for(ArrayList<String> entry2: entry) {
            int abs = 0;
            int hits = 0;
            System.out.print("[");
            int index= 0;
                    for(String stat: entry2) {
                        if(index == 0) {
                            System.out.print(stat + ",");
                        }
                        if(index == 1) {
                            System.out.print("  "+ stat + ",");
                        }
                        if(index == 2) {
                            statlength(stat);
                        }
                        if(index == 3) {
                            statlength(stat);
                            abs = Integer.parseInt(stat);
                        }
                        if(index == 4) {
                            statlength(stat);
                        }
                        if(index == 5) {
                            statlength(stat);
                            hits = Integer.parseInt(stat);
                        }
                        if(index == 6) {
                            statlength(stat);
                        }
                        if(index == 7) {
                            statlength(stat);
                        }
                        if(index == 8) {
                            statlength(stat);
                        }
                        if(index == 9) {
                            statlength(stat);
                        }
                        if(index == 10) {
                            statlength(stat);
                        }
                        if(index == 11) {
                            if(stat.length() == 1) {
                                System.out.print("   " + stat + ", ");
                            }
                            if(stat.length() == 2) {
                                System.out.print("  " + stat + ", ");
                            }
                            if(stat.length() == 3) {
                                System.out.print(" " + stat + ", ");
                            }
                        }
                        index++;
                    }
                    printAverage(hits, abs);
                    System.out.println("]");
        }
    }

    public void printAverage(int hits, int abs) {
        float average;
        if(hits == 0 || abs == 0) {
            System.out.print("0.000");
            return;
        }
        else {
            average = (float)hits / abs;

        }
        String averageSTR = Float.toString(average);
        char[] averageCHAR = averageSTR.toCharArray();

        int counter = 0;
        for(char c: averageCHAR) {
            if (counter > 4) {
                break;
            }
            else {
                System.out.print(c);
            }
            counter++;
        }
        if(averageCHAR.length == 3) {
            System.out.print("00");
        }
        if(averageCHAR.length == 4) {
            System.out.print("0");
        }
        
    }

    public void printPitching(ArrayList<ArrayList<String>> entry) {
        for(ArrayList<String> entry2: entry) {
            System.out.print("[");
            int index= 0;
                for(String stat: entry2) {
                    if(index == 0) {
                        System.out.print(stat + ",");
                    }
                    if(index == 1) {
                        System.out.print("  "+ stat + ",");
                    }
                    if(index == 2) {
                        statlength(stat);
                    }
                    if(index == 3) {
                        statlength(stat);
                    }
                    if(index == 4) {
                        statlength(stat);
                    }
                    if(index == 5) {
                        statlength(stat);
                    }
                    if(index == 6) {
                        statlength(stat);
                    }
                    if(index == 7) {
                        if(stat.length() == 1) {
                            System.out.print( " " + stat + ".00,");
                        }
                        if(stat.length() == 3) {
                            System.out.print( " " + stat + "0,");
                        }
                        else {
                            System.out.print( " " + stat + ",");
                        }
                    }
                    if(index == 8) {
                        int innings = Integer.parseInt(stat) / 3;
                        String inningsSTR = Integer.toString(innings);
                        if(inningsSTR.length() == 1) {
                            System.out.print("   " + innings);
                        }
                        if(inningsSTR.length() == 2) {
                            System.out.print("  " + innings);
                        }
                        if(inningsSTR.length() == 3) {
                            System.out.print(" " + innings);
                        }
                    }
                    
                    index++;
                }
            System.out.println("]");
        }
    }

    public void statlength(String stat) {
        if(stat.length() == 1) {
            System.out.print("   " + stat + ",");
        }
        if(stat.length() == 2) {
            System.out.print("  " + stat + ",");
        }
        if(stat.length() == 3) {
            System.out.print(" " + stat + ",");
        }
    }
    
    public void changeSetting(Setting setting) {
        this.gameSetting = setting;
    }

    /*
     * checks if the player has the relevant amount of games played
     */
    private boolean relevancyCheck(String playerID) {
        System.out.print(".");
        String sql1 = String.format("SELECT SUM(h) FROM batting WHERE batting.playerID ='%s'", playerID);
        String sql2 = String.format("SELECT SUM(so) FROM pitching WHERE pitching.playerID ='%s'", playerID);

        int battingH = 0;
        if (db_Utils.exec_get_all(sql1).get(0).get(0) != null) {
            battingH = Integer.parseInt(db_Utils.exec_get_all(sql1).get(0).get(0));
        }

        
        int pitchingSO = 0;
        if(db_Utils.exec_get_all(sql2).get(0).get(0) != null) {
            pitchingSO = Integer.parseInt(db_Utils.exec_get_all(sql2).get(0).get(0));
        }

        boolean result = false;

        if(battingH > 700) {
            result = true;
        }
        if(pitchingSO > 800) {
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
