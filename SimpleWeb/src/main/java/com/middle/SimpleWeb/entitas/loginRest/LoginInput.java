/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.middle.SimpleWeb.entitas.loginRest;

import lombok.Data;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Data
public class LoginInput {
    private String email, password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

