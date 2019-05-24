package company.mail;

import java.sql.*;
import java.util.*;
import java.util.Scanner;



public class user {
    private final static String url = "jdbc:postgresql://138.197.107.95:5432/group1";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";
    public static Scanner scan = new Scanner(System.in);


    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully.");


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
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("Create a new User");
        do {
            System.out.println("Enter name");
            name = scan.nextLine();
        }while (isUserNameInUser(name));
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

    public static int UserVerification(String username, String password)
    {
        try {
            Connection conn = connect();

            String SQL = "select * from mailmaster where name = ?";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if (rs.getString(3).equals(password)) {
                    return rs.getInt(1);
                } else {
                    return 0;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }
        return 0;
    }

    public static int getUserToSendTo()
    {
        Connection conn = connect();

            try {

                String SQL = "select * from mailmaster";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);

                while(rs.next()){
                    System.out.print(rs.getString(1)+"\t");
                    System.out.println(rs.getString(2));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage( ));
            }
            System.out.println("Who Do you want to send mail to? Please enter their number"+"\n");
            int numberToReturn = scan.nextInt();
        try {

            String SQL = "select * from mailmaster";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                if(numberToReturn == rs.getInt(1)){
                    return numberToReturn;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }
        return 0;
    }

    public static String getUserName(int userID)
    {
        Connection conn = connect();
        try {

            String SQL = "select * from mailmaster where userid = ?";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,userID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                return(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }
        return("Junk");
    }

    public static boolean isUserNameInUser(String usernameToTest)
    {
        Connection conn = connect();
        try {

            String SQL = "select * from mailmaster where name = ?";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1,usernameToTest);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                if(rs.getString("name").equals(usernameToTest))
                {
                    return false;
                }
                else return true;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return(false);
    }


//     sql statement to create a new user
        // execute create new user
        // this.username
        // this.password

    }



