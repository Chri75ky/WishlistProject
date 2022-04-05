package com.example.wishlist.services;

public class InfoService {

    //validate user
public boolean isUserValid(String email, String password, String passwordToCheck) {
    return isEmailValid(email) && isPasswordValid(password, passwordToCheck);
}

    //validate password
public boolean isPasswordValid(String password, String passwordToCheck) {
    return password.equals(passwordToCheck);
}

    //validate email
    public boolean isEmailValid(String email){
        return email.contains(".") && email.contains("@");
    }
}
