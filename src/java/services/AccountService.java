/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;
/**
 *
 * @author owner-pc
 */
public class AccountService {
    public User login(String username, String password){
        if(username.equals("barb") || username.equals("abe") && password.equals("password")){
            return new User(username, null);
        }
        return null;
    }
}
