package com.example.wishlist.controllers;

import com.example.wishlist.Wishlist;
import com.example.wishlist.repository.WishlistRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class WishlistController {
    WishlistRepo wr = new WishlistRepo();


    @PostMapping("/wishlist")
    public String createWishlist(WebRequest dataFromForm) {

        Wishlist wishlistTest = new Wishlist(dataFromForm.getParameter("wishlist-name"), dataFromForm.getParameter("wishlist-description") );
        wr.insertWishlist(wishlistTest);
        return "redirect:/wishlist";
    }


}

