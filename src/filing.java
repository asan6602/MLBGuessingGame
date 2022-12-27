import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filing {
    public static void addDataContents(String field){
        try{
            BufferedReader csvReader = new BufferedReader(new FileReader("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/data/HallOfFame.csv"));
            String row;
            FileWriter myWriter = new FileWriter("C:/Users/ABSan/OneDrive/Desktop/MLBGuessingGame/data/Hof.csv");
    
            while (((row = csvReader.readLine()) != null)){
                String[] line = row.split(",");
                if (line[6].equals(field) && line[7].equals("Player")){
                    myWriter.write(row + "\n");
                }
            }
            myWriter.close();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        addDataContents("Y");
    }
}
