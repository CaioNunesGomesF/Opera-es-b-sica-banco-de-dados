package application;

import db.DB;
import db.DbIntegrityExeception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarDados {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try{
           conn = DB.getConnection();

           st = conn.prepareStatement("DELETE FROM Department " + "WHERE " + "Id = ?");

           st.setInt(1,2);

           int rowsAffectd = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffectd);

        } catch (SQLException e) {
            throw new DbIntegrityExeception(e.getMessage());
        }

    }

}
