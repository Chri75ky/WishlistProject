package com.example.wishlist.controllers;

import com.example.wishlist.User;
import com.example.wishlist.repository.UserRepository;
import com.example.wishlist.services.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {
    UserRepository ur = new UserRepository();

    @PostMapping("/logged")
    public String signUp(WebRequest dataFromForm) {
        InfoService i = new InfoService();

        if (i.isUserValid(dataFromForm.getParameter("email"), dataFromForm.getParameter("password"), dataFromForm.getParameter("password-check"))) {
            User userTest = new User(dataFromForm.getParameter("username"), dataFromForm.getParameter("email"), dataFromForm.getParameter("password"));
            ur.insertuser(userTest);
            return "redirect:/logged";
        } else return "redirect:/signup";
    }

}
