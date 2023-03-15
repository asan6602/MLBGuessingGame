package model;

import java.util.ArrayList;

public class AwardWinners implements Setting{
    @Override
    public ArrayList<ArrayList<String>> getPlayer() {
        String sql = "SELECT * FROM awards ORDER BY RANDOM() LIMIT 1";
        ArrayList<ArrayList<String>> result = db_Utils.exec_get_all(sql);
        return result;
    }
}
