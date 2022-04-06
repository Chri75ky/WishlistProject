package com.example.wishlist.repository;

import com.example.wishlist.User;
import com.example.wishlist.Wishlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WishlistRepo {

    public void insertWishlist(Wishlist wishlist) {
        try
        {
            String url = "jdbc:mysql://localhost:3306/wishlist";
            Connection con = DriverManager.getConnection(url,"root","Ced72vbq.");
            System.out.println("Ok, we have a connection.");

            String query = " INSERT INTO user_wishlist (wishlist_id, wishlist_name, wishlist_description)" + " VALUES (?, ?, ?)";

            /*PreparedStatement pps = con.prepareStatement(query);
            pps.setString(1, user.getUsername());
            pps.setString(2, user.getEmail());
            pps.setString(3, user.getPassword());*//*

            pps.execute();*/

            con.close();

        } catch (SQLException e) {
            System.err.println("GOT AN EXCEPTION!");
            System.err.println(e.getMessage());

        }
    }
}
