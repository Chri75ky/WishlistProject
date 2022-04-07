package com.example.wishlist.repository;

import com.example.wishlist.Models.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {

    private Connection con;
    PreparedStatement pps;
    private final String url = "jdbc:mysql://localhost:3306/wishlist";

    public void insertuser(User user) {
        try {
            con = DriverManager.getConnection(url, "root", "Ced72vbq.");

            String query = " INSERT INTO users (username, email, password)" + " VALUES (?, ?, ?)";

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
        con = DriverManager.getConnection(url, "root", "Ced72vbq.");

        ArrayList<String> emails = new ArrayList<>();
        String query = "SELECT email FROM users";
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
        String query = " SELECT * FROM users" + " WHERE email =" + " '" + userEmail + "'";
        User currentUser = null;
        con = DriverManager.getConnection(url, "root", "Ced72vbq.");
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
        String query = " SELECT user_id FROM users" + " WHERE email =" + " '" + userEmail + "'";
        int user_id = 0;
        con = DriverManager.getConnection(url, "root", "Ced72vbq.");
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

    public String getPasswordFromUserDB(String userEmail) {
        String query = " SELECT password FROM users" + " WHERE email =" + " '" + userEmail + "'";

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