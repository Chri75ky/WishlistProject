package com.example.wishlist.repository;

import com.example.wishlist.Models.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {

    private Connection con;
    PreparedStatement pps;
    private final String url = "jdbc:mysql://full-stack-project.mysql.database.azure.com:3306/?user=PlaceholderName";

    public void insertuser(User user) {
        try {

            con = DriverManager.getConnection(url, "PlaceholderName", "Passw0rd");

            String query = " USE wishlist";
            pps = con.prepareStatement(query);
            pps.execute();


            query = " INSERT INTO users (username, email, password)" + " VALUES (?, ?, ?)";
            pps = con.prepareStatement(query);
            pps.setString(1, user.getUsername());
            pps.setString(2, user.getEmail());
            pps.setString(3, user.getPassword());

            pps.execute();

            con.close();

        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());

        }
    }

    public ArrayList<String> getEmailsFromUsers() throws SQLException {
        con = DriverManager.getConnection(url, "PlaceholderName", "Passw0rd");

        String query = " USE wishlist";
        pps = con.prepareStatement(query);
        pps.execute();

        ArrayList<String> emails = new ArrayList<>();
        query = "SELECT email FROM users";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String email = rs.getString("email");

                emails.add(email);
            }


        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());
        }
        return emails;
    }

    public User getUserFromDB(String userEmail) throws SQLException {
        con = DriverManager.getConnection(url, "PlaceholderName", "Passw0rd");

        String query = " USE wishlist";
        pps = con.prepareStatement(query);
        pps.execute();

        query = " SELECT * FROM users" + " WHERE email =" + " '" + userEmail + "'";
        User currentUser = null;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                currentUser = new User(username, email, password);
            }
        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION");
            System.err.println(e.getMessage());
        }
        return currentUser;
    }

    public int getUserIdFromDB(String userEmail) throws SQLException {
        con = DriverManager.getConnection(url, "PlaceholderName", "Passw0rd");

        String query = " USE wishlist";
        pps = con.prepareStatement(query);
        pps.execute();

        query = " SELECT user_id FROM users" + " WHERE email =" + " '" + userEmail + "'";
        int user_id = 0;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user_id = rs.getInt("user_id");

            }
        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION");
            System.err.println(e);
        }
        return user_id;
    }

    public String getPasswordFromUserDB(String userEmail) throws SQLException {
        con = DriverManager.getConnection(url, "PlaceholderName", "Passw0rd");

        String query = " USE wishlist";
        pps = con.prepareStatement(query);
        pps.execute();

        query = " SELECT password FROM users" + " WHERE email =" + " '" + userEmail + "'";

        String userPassword = null;
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                userPassword = rs.getString("password");

            }
        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());
        }
        return userPassword;

    }
}