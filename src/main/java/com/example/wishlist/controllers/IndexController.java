package com.example.wishlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
    return "index";
}
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logged")
    public String logged(){
        return "logged";
    }

    @GetMapping("/browse")
    public String browse(){
        return "browse";
    }

    @GetMapping("/category-beauty")
    public String categoryBeauty(){
        return "category-beauty";
    }

    @GetMapping("/category-clothes")
    public String categoryClothes(){
        return "category-clothes";
    }

    @GetMapping("/category-electronics")
    public String categoryElectronics(){
        return "category-electronics";
    }

    @GetMapping("/category-sport")
    public String categorySport(){
        return "category-sport";
    }

}
