package com.example.wishlist;


public class Wishlist {

    private String wishlistName;
    private String wishlistDescription;

    //konstruktør
    public Wishlist(String wishlistName, String wishlistDescription) {
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
}
