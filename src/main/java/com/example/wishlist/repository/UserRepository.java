package com.example.wishlist.repository;

import com.example.wishlist.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {

    private Connection con;
    PreparedStatement pps;
    private final String url = "jdbc:mysql://localhost:3306/wishlist";

    public void insertuser(User user) {
        try {
            con = DriverManager.getConnection(url, "root", "edx43tfq");

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
        con = DriverManager.getConnection(url, "root", "edx43tfq");

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