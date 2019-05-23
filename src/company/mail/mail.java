package company.mail;

import java.sql.*;
import java.util.*;
import java.util.Scanner;

public class mail {
    private final static String url = "jdbc:postgresql://138.197.107.95:5432/group1";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            testcodeCrewMailSQL(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

        return conn;
    }

    public static void testcodeCrewMailSQL(Connection conn){

        try {

            String SQL = "select * from codecrewmail";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("subject"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }


}
