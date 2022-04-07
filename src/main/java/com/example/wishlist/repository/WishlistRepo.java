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
        String query = " SELECT * FROM user_wishlist" + " WHERE wishlist_id =" + " '" + userID + "'";

        int wishlistID = 0;
        String wishlistName = null;
        String wishlistDescription = null;
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                wishlistID = rs.getInt("wishlist_id");
                wishlistName = rs.getString("wishlist_name");
                wishlistDescription = rs.getString("wishlist_description");

            }
        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());
        }
        Wishlist wishlistFromDB = new Wishlist(wishlistName,wishlistDescription);
        return wishlistFromDB;

    }
}
