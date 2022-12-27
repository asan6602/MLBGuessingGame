import java.io.FileReader;

import com.opencsv.CSVReader;

public class Players {

    public void build_table() {
        db_Utils.exec_sql_file("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/src/Players.sql");
    }
    public void create_player(String playerID, String debut, String firstname, String lastname) {
        String sql_command = String.format("INSERT INTO players(playerID, debut, firstname, lastname) VALUES ('%s','%s','%s','%s')", playerID, debut, firstname, lastname);
        db_Utils.exec_commit(sql_command);
    }
    public void players_csv_reader() {
        try {
            FileReader fr = new FileReader("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/data/players.csv");
            CSVReader csvReader = new CSVReader(fr);
            String[] nextRecord;
            csvReader.readNext();
            while((nextRecord = csvReader.readNext()) != null) {
                String id = nextRecord[0];
                String first = nextRecord[13];
                String last = nextRecord[14];
                String debut;
                if (nextRecord[20].equals("")) {
                    debut = "0001-01-01";
                }
                else{
                    debut = nextRecord[20];
                }
                create_player(id, debut, first, last);
            }
            csvReader.close();
            fr.close();
            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }   
    }
    public static void main(String[] args) {
        Players p = new Players();
        p.build_table();
        p.players_csv_reader();
    }

}
