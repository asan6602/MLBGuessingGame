import java.io.FileReader;

import com.opencsv.CSVReader;

public class Awards {
    public void build_table() {
        db_Utils.exec_sql_file("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/src/Awards.sql");
    }
    public void create_award(String playerID, String yearID, String award) {
        String sql_command = String.format("INSERT INTO awards(playerID, yearID, award) VALUES ('%s','%s','%s')", playerID, yearID, award);
        db_Utils.exec_commit(sql_command);
    }
    public void awards_csv_reader() {
        try {
            FileReader fr = new FileReader("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/data/Awards.csv");
            CSVReader csvReader = new CSVReader(fr);
            String[] nextRecord;
            csvReader.readNext();
            while((nextRecord = csvReader.readNext()) != null) {
                String playerID = nextRecord[0];
                String yearID = nextRecord[2];
                String award = nextRecord[3];
                create_award(playerID, yearID, award);
            }
            csvReader.close();
            fr.close();
            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }   
    }
}
