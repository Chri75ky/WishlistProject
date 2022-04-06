package com.example.wishlist.services;

import com.example.wishlist.repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class InfoService {
    private final UserRepository ur = new UserRepository();

//-----------------------------USERS-------------------------------------------//
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

    public boolean isEmailInDatabase(String emailToCompare) throws SQLException {
        ArrayList<String> emails = ur.getEmailsFromUsers();

        for (int i = 0; i < emails.size(); i++) {
            return emailToCompare.equalsIgnoreCase(emailToCompare);
        }
        return false;
    }

    public boolean checkPassword(String passwordToCheck, String checkedEmail) {
        String userPassword = ur.getPasswordFromUserDB(checkedEmail);
        return passwordToCheck.equals(userPassword);

    }
//----------------------------------WISHLIST-----------------------------//



}
