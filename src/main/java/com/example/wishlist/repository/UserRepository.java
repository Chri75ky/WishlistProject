package com.example.wishlist.repository;

import com.example.wishlist.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    //public User getSingleUser()

    public void insertuser(User user) {
        try {

            String myURL = "jdbc:mysql://localhost3306/wishlist";
            Connection con = DriverManager.getConnection(myURL, "root", "edx43tfq");
            System.out.println("wabalabadoo");

            String query = " INSERT INTO users (username, email, password)" + " VALUES (?, ?, ?)";

            PreparedStatement pps = con.prepareStatement(query);
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


}
