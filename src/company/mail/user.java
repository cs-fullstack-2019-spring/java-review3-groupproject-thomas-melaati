package company.mail;

import java.sql.*;
import java.util.*;
import java.util.Scanner;



public class user {
    private final static String url = "jdbc:postgresql://138.197.107.95:5432/group1";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";


    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

//            testmailmasterSQL(conn);
//            createNewUser();

        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

        return conn;
    }

    public static void testmailmasterSQL(Connection conn){

        try {

            String SQL = "select * from mailmaster";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }

    }

    public static void createNewUser(){
        Connection conn = connect();
        Scanner scan = new Scanner(System.in);
        System.out.println("Create a new User");
        System.out.println("Enter name");
        String name = scan.nextLine();
        System.out.println("Enter Password");
        String password=scan.nextLine();
        System.out.println("Thankyou user created");



        try {

            String SQL = "insert into mailmaster(name,password) values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1,name);
            stmt.setString(2,password);
            stmt.executeUpdate();

//            while(rs.next()){
//                System.out.println(rs.getString("name"));
//            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }


    }


//     sql statement to create a new user
        // execute create new user
        // this.username
        // this.password

    }



