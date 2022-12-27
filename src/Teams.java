import java.io.FileReader;

import com.opencsv.CSVReader;

public class Teams {
    public void build_table() {
        db_Utils.exec_sql_file("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/src/Teams.sql");
    }
    public void create_Team(String teamID, String teamName) {
        String sql_command = String.format("INSERT INTO Teams(teamID, teamName) VALUES ('%s','%s')", teamID, teamName);
        db_Utils.exec_commit(sql_command);
    }
    public void Team_csv_reader() {
        try {
            FileReader fr = new FileReader("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/data/TeamsFranchises.csv");
            CSVReader csvReader = new CSVReader(fr);
            String[] nextRecord;
            csvReader.readNext();
            while((nextRecord = csvReader.readNext()) != null) {
                String teamID = nextRecord[0];
                String teamName = nextRecord[1];
                create_Team(teamID, teamName);
            }
            csvReader.close();
            fr.close();
            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }   
    }
}
