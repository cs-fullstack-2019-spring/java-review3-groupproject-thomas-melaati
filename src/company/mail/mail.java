package company.mail;

import java.sql.*;
import java.util.*;
import java.util.Scanner;

public class mail extends user {
    private final static String url = "jdbc:postgresql://138.197.107.95:5432/group1";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void testcodeCrewMailSQL() {
        Connection conn = connect();

        try {

            String SQL = "select * from codecrewmail";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("subject"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createNewCodeCrewMail() {
        boolean boolToSave;
        Connection conn = connect();
        Scanner scan = new Scanner(System.in);
        System.out.println("Creating a new Code Crew Mail");
        System.out.println("Enter Subject");
        String subject = scan.nextLine();
        System.out.println("Enter body");
        String body = scan.nextLine();
        System.out.println("is it important?");
        String isimportant = scan.next();
        if(isimportant.equalsIgnoreCase("yes"))
        {
            boolToSave = true;
        }
        else
            {
                boolToSave = false;
            }

        System.out.println("Thankyou Mail Sent");


        try {

            String SQL = "insert into codecrewmail(subject, body,fromuserid,touserid,isimportant) values (?,?,1,1,?)";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1, subject);
            stmt.setString(2, body);
            stmt.setBoolean(3,boolToSave);
            stmt.executeUpdate();

//            while(rs.next()){
//                System.out.println(rs.getString("name"));
//            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
