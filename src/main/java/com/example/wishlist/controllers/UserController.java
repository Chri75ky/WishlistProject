package com.example.wishlist.controllers;

import com.example.wishlist.Models.User;
import com.example.wishlist.repository.UserRepository;
import com.example.wishlist.services.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class UserController {
    UserRepository ur = new UserRepository();

    @PostMapping("/logged")
    public String signUp(WebRequest dataFromForm, HttpServletRequest request) {
        InfoService i = new InfoService();

        if (i.isUserValid(dataFromForm.getParameter("email"), dataFromForm.getParameter("password"), dataFromForm.getParameter("password-check"))) {
            User userTest = new User(dataFromForm.getParameter("username"), dataFromForm.getParameter("email"), dataFromForm.getParameter("password"));
            ur.insertuser(userTest);

            HttpSession session = request.getSession();
            session.setAttribute("current-user", userTest);

            return "redirect:/logged";
        } else return "redirect:/signup";
    }

    @PostMapping("/profile")
    public String login(WebRequest dataFromForm, HttpServletRequest request) throws SQLException {
        InfoService i = new InfoService();
        UserRepository ur = new UserRepository();
        String emailToCheck = dataFromForm.getParameter("email");
        String passwordToCheck = dataFromForm.getParameter("password");

        if(i.isEmailValid(emailToCheck)) {
            if(i.isEmailInDatabase(emailToCheck)) {
                if(i.checkPassword(passwordToCheck, emailToCheck)) {

                    HttpSession session = request.getSession();
                    session.setAttribute("current-user", ur.getUserFromDB(emailToCheck));

                    return "redirect:/logged";
                }
            }
        }

        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("current-user");
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("email", currentUser.getEmail());
        model.addAttribute("password", currentUser.getPassword());
        return "profile";
    }
}

