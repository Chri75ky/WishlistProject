package com.example.wishlist.repository;

import com.example.wishlist.User;
import com.example.wishlist.Wishlist;

import java.sql.*;
import java.util.ArrayList;

public class WishlistRepo {

    private Connection con;
    PreparedStatement pps;

    public void insertWishlist(Wishlist wishlist) {
        try {
            String url = "jdbc:mysql://localhost:3306/wishlist";
            con = DriverManager.getConnection(url, "root", "Ced72vbq.");

            String query = " INSERT INTO user_wishlist (wishlist_name,wishlist_description)" + " VALUES (?, ?)";

            pps = con.prepareStatement(query);
            pps.setString(1, wishlist.getWishlistName());
            pps.setString(2, wishlist.getWishlistDescription());

            pps.execute();

            con.close();

        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());

        }
    }

    public ArrayList<String> getNamesOfWishlists() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/wishlist";
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
}
