package com.example.wishlist.Models;


public class Wishlist {

    private int userID;
    private String wishlistName;
    private String wishlistDescription;

    //konstruktør
    public Wishlist(int userID, String wishlistName, String wishlistDescription) {
        this.userID = userID;
        this.wishlistName = wishlistName;
        this.wishlistDescription = wishlistDescription;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public String getWishlistDescription() {
        return wishlistDescription;
    }

    public void setWishlistDescription(String wishlistDescription) {
        this.wishlistDescription = wishlistDescription;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlistName='" + wishlistName + '\'' +
                ", wishlistDescription='" + wishlistDescription + '\'' +
                '}';
    }
}
