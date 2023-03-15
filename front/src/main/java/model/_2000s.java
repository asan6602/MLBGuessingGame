package model;

import java.util.ArrayList;

public class _2000s implements Setting{
    @Override
    public ArrayList<ArrayList<String>> getPlayer() {
        String sql = "SELECT * FROM players WHERE players.debut > '2000-01-01' AND players.debut < '2009-12-31' ORDER BY RANDOM() LIMIT 1";
        ArrayList<ArrayList<String>> result = db_Utils.exec_get_all(sql);
        return result;
    }
}
