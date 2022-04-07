package com.example.wishlist.repository;

import com.example.wishlist.Wishlist;

import java.sql.*;

public class WishlistRepo {

    private Connection con;
    PreparedStatement pps;
    private final String url = "jdbc:mysql://localhost:3306/wishlist";

    public void insertWishlist(Wishlist wishlist) {
        try {
            con = DriverManager.getConnection(url, "root", "edx43tfq");

            String query = " INSERT INTO user_wishlist (wishlist_name, wishlist_description)" + " VALUES (?, ?)";

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

    public Wishlist getWishlistFromDB(String userID) {
        Wishlist wishlistFromDB = new Wishlist(getNameOfWishlist(userID), getDescriptionOfWishlist(userID));

        return wishlistFromDB;
    }


    public String getNameOfWishlist(String userID) {
        String query = " SELECT wishlist_name FROM user_wishlist WHERE wishlist_id =" + " '" + "" + "'";

        String wishlistName = null;
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                wishlistName = rs.getString("wishlist_name");

            }
        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());
        }
        return wishlistName;

    }

    public String getDescriptionOfWishlist(String userID) {
        String query = " SELECT wishlist_description FROM user_wishlist WHERE wishlist_id =" + " '" + "" + "'";

        String wishlistDescription = null;
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                 wishlistDescription = rs.getString("wishlist_description");

            }
        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());
        }
        return wishlistDescription;


    }
}
