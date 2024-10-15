package application;

import db.DB;

import java.sql.*;

public class RecuperarDados {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = DB.getConnection();

            st =  conn.createStatement();
            rs = st.executeQuery("select * from department");
            while(rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
            System.out.println();
            st = conn.createStatement();
            rs = st.executeQuery("Select Id, Name from department where id >= 2");
            while(rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeConnection();
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
