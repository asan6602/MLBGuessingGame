package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import org.postgresql.Driver;



public class db_Utils {
    /*
     * Connects to postgres
     */
    public static Connection connect() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/baseball";
        String username = "postgres";
        String password = "postgres";
        try {
            //DriverManager.registerDriver(new org.postgresql.Driver());
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            return connection;

        } catch (Exception e) {
            System.out.println("Error in connecting");
            e.printStackTrace();
            return null;
        }
    }


    /*
     * gets using an sql statement
     */
    public static ArrayList<ArrayList<String>> exec_get_all(String sql) {
        try {
            Connection conn = connect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
            ResultSetMetaData metadata = rs.getMetaData();
            int cols = metadata.getColumnCount();
            while(rs.next()) {
                ArrayList<String> data = new ArrayList<String>();
                for(int i=1; i < cols+ 1; i++) {
                    data.add(rs.getString(i));
                }
                result.add(data);
                
            }
            rs.close();
            statement.close();
            conn.close();
            return result;

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
            return null;
        }

    }

    /*
     * inserts using an sql statement
     */
    public static void exec_commit(String sql) {
        try {
            Connection conn = connect();
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

    }
    public static void main(String[] args) {
        String get = "SELECT * FROM batting LIMIT 10";
        ArrayList<ArrayList<String>> g = exec_get_all(get);
        System.out.println(g.get(0));
        
    }
}
