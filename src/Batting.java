import java.io.FileReader;

import com.opencsv.CSVReader;

public class Batting {
    public void build_table() {
        db_Utils.exec_sql_file("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/src/Batting.sql");
    }
    public void create_batting(String playerID, String yearID, String teamID, String g, String ab, String r, String h, String _2b, String _3b, String hr, String rbi, String sb, String bb) {
        String sql_command = String.format("INSERT INTO batting(playerID, yearID, teamID, g, ab, r, h, _2b, _3b, hr, rbi, sb, bb) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", playerID, yearID, teamID, g, ab, r, h, _2b, _3b, hr, rbi, sb, bb);
        db_Utils.exec_commit(sql_command);
    }

    public void batting_csv_reader() {
        try {
            FileReader fr = new FileReader("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/data/batting.csv");
            CSVReader csvReader = new CSVReader(fr);
            String[] nextRecord;
            csvReader.readNext();
            while((nextRecord = csvReader.readNext()) != null) {
                String playerID = nextRecord[0];
                String yearID = nextRecord[1];
                String teamID = nextRecord[3];

                String g;
                if (nextRecord[5].equals("")) {
                    g = "0";
                }
                else{
                    g = nextRecord[5];
                }
                String ab;
                if (nextRecord[6].equals("")) {
                    ab = "0";
                }
                else{
                    ab = nextRecord[6];
                }
                String r;
                if (nextRecord[7].equals("")) {
                    r = "0";
                }
                else{
                    r = nextRecord[7];
                }
                String h;
                if (nextRecord[8].equals("")) {
                    h = "0";
                }
                else{
                    h = nextRecord[8];
                }
                String _2b;
                if (nextRecord[9].equals("")) {
                    _2b = "0";
                }
                else{
                    _2b = nextRecord[9];
                }
                String _3b;
                if (nextRecord[10].equals("")) {
                    _3b = "0";
                }
                else{
                    _3b = nextRecord[10];
                }
                String hr;
                if (nextRecord[11].equals("")) {
                    hr = "0";
                }
                else{
                    hr = nextRecord[11];
                }
                String rbi;
                if (nextRecord[12].equals("")) {
                    rbi = "0";
                }
                else{
                    rbi = nextRecord[12];
                }
                String sb;
                if (nextRecord[13].equals("")) {
                    sb = "0";
                }
                else{
                    sb = nextRecord[13];
                }
                String bb;
                if (nextRecord[15].equals("")) {
                    bb = "0";
                }
                else{
                    bb = nextRecord[15];
                }

                create_batting(playerID, yearID, teamID, g, ab, r, h, _2b, _3b, hr, rbi, sb, bb);

            }

            csvReader.close();
            fr.close();
            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }   
    }
}
