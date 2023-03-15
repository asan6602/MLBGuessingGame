package model;

import java.util.ArrayList;

public class _1970s implements Setting{
    @Override
    public ArrayList<ArrayList<String>> getPlayer() {
        String sql = "SELECT * FROM players WHERE players.debut > '1970-01-01' AND players.debut < '1979-12-31' ORDER BY RANDOM() LIMIT 1";
        ArrayList<ArrayList<String>> result = db_Utils.exec_get_all(sql);
        return result;
    }
}
