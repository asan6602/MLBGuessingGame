import java.util.ArrayList;

public class All implements Setting {
    @Override
    public ArrayList<ArrayList<String>> getPlayer() {
        String sql = "SELECT * FROM players WHERE players.debut > '1920-01-01' ORDER BY RANDOM() LIMIT 1";
        ArrayList<ArrayList<String>> result = db_Utils.exec_get_all(sql);
        return result;
    }
}
