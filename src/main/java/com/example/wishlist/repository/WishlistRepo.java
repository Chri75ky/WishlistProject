package com.example.wishlist.repository;

import com.example.wishlist.Models.Wishlist;

import java.sql.*;
import java.util.ArrayList;

public class WishlistRepo {

    private Connection con;
    PreparedStatement pps;
    private final String url = "jdbc:mysql://full-stack-project.mysql.database.azure.com:3306/?user=PlaceholderName";

    public void insertWishlist(Wishlist wishlist) {
        try {
            con = DriverManager.getConnection(url, "PlaceholderName", "Passw0rd");

            String query = " USE wishlist";
            pps = con.prepareStatement(query);
            pps.execute();


            query = " INSERT INTO user_wishlist (wishlist_name, wishlist_description, user_id)" + " VALUES (?, ?, ?)";
            pps = con.prepareStatement(query);
            pps.setString(1, wishlist.getWishlistName());
            pps.setString(2, wishlist.getWishlistDescription());
            pps.setInt(3, wishlist.getUserID());

            pps.execute();

            con.close();

        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());

        }
    }


    public ArrayList<Wishlist> getWishlistFromDB(int userID) throws SQLException {
        con = DriverManager.getConnection(url, "PlaceholderName", "Passw0rd");

        String query = " USE wishlist";
        pps = con.prepareStatement(query);
        pps.execute();

        query = " SELECT * FROM user_wishlist" + " WHERE user_id =" + " '" + userID + "'";

        int wishlistID = 0;
        String wishlistName = null;
        String wishlistDescription = null;
        ArrayList<Wishlist> userWishlists = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                wishlistID = rs.getInt("wishlist_id");
                wishlistName = rs.getString("wishlist_name");
                wishlistDescription = rs.getString("wishlist_description");
                Wishlist wishlistFromDB = new Wishlist(wishlistID, wishlistName,wishlistDescription);
                userWishlists.add(wishlistFromDB);
            }
        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());
        }

        return userWishlists;

    }
}
