import java.io.FileReader;

import com.opencsv.CSVReader;

public class Pitching {
    public void build_table() {
        db_Utils.exec_sql_file("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/src/Pitching.sql");
    }
    public void create_pitching(String playerID, String yearID, String teamID, String g, String w, String l, String sv, String so, String era, String outs) {
        String sql_command = String.format("INSERT INTO pitching(playerID, yearID, teamID, g, w, l, sv, so, era, outs) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", playerID, yearID, teamID, g, w, l, sv, so, era, outs);
        db_Utils.exec_commit(sql_command);
    }

    public void pitching_csv_reader() {
        try {
            FileReader fr = new FileReader("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/data/pitching.csv");
            CSVReader csvReader = new CSVReader(fr);
            String[] nextRecord;
            csvReader.readNext();
            while((nextRecord = csvReader.readNext()) != null) {
                String playerID = nextRecord[0];
                String yearID = nextRecord[1];
                String teamID = nextRecord[3];

                String g;
                if (nextRecord[7].equals("")) {
                    g = "0";
                }
                else{
                    g = nextRecord[7];
                }
                String w;
                if (nextRecord[5].equals("")) {
                    w = "0";
                }
                else{
                    w = nextRecord[5];
                }
                String l;
                if (nextRecord[6].equals("")) {
                    l = "0";
                }
                else{
                    l = nextRecord[6];
                }
                String sv;
                if (nextRecord[11].equals("")) {
                    sv = "0";
                }
                else{
                    sv = nextRecord[11];
                }
                String so;
                if (nextRecord[17].equals("")) {
                    so = "0";
                }
                else{
                    so = nextRecord[17];
                }
                String era;
                if (nextRecord[19].equals("")) {
                    era = "0";
                }
                else{
                    era = nextRecord[19];
                }
                String outs;
                if (nextRecord[12].equals("")) {
                    outs = "0";
                }
                else{
                    outs = nextRecord[12];
                }
                create_pitching(playerID, yearID, teamID, g, w, l, sv, so, era, outs);
            }

            csvReader.close();
            fr.close();
            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }   
    }
}
