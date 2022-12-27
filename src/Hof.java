import java.io.FileReader;

import com.opencsv.CSVReader;

public class Hof {
    public void build_table() {
        db_Utils.exec_sql_file("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/src/Hof.sql");
    }
    public void create_Hof(String playerID, String yearID) {
        String sql_command = String.format("INSERT INTO Hof(playerID, yearID) VALUES ('%s','%s')", playerID, yearID);
        db_Utils.exec_commit(sql_command);
    }
    public void Hof_csv_reader() {
        try {
            FileReader fr = new FileReader("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/data/Hof.csv");
            CSVReader csvReader = new CSVReader(fr);
            String[] nextRecord;
            csvReader.readNext();
            while((nextRecord = csvReader.readNext()) != null) {
                String playerID = nextRecord[0];
                String yearID = nextRecord[1];
                create_Hof(playerID, yearID);
            }
            csvReader.close();
            fr.close();
            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }   
    }
    public static void main(String[] args) {
        Hof h = new Hof();
        h.build_table();
        h.Hof_csv_reader();
    }
}
