package com.example.wishlist.controllers;

import com.example.wishlist.services.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {

    @PostMapping("/logged")
    public String test(WebRequest dataFromForm) {
        InfoService i = new InfoService();

        if (i.isUserValid(dataFromForm.getParameter("email"), dataFromForm.getParameter("password"), dataFromForm.getParameter("password-check") )){

            return "redirect:/logged";
        }
        else return "redirect:/signup";
    }


}
