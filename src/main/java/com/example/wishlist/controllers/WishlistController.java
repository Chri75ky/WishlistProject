package com.example.wishlist.controllers;

import com.example.wishlist.Wishlist;
import com.example.wishlist.repository.WishlistRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

public class WishlistController {
    WishlistRepo wr = new WishlistRepo();

    @PostMapping("/wishlist")
    public String createWishlist(WebRequest dataFromForm) {

            Wishlist wishlist = new Wishlist(dataFromForm.getParameter("wishlist_name"), dataFromForm.getParameter("wishlist_description"));
            wr.insertWishlist(wishlist);
            return "redirect:/wishlist";
    }

}
