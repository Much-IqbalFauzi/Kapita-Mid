/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.entitas.loginRest;

import lombok.Data;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Data
public class LoginOutput {
    private UserOutput user;
    private String status;

    public LoginOutput(UserOutput user, String status) {
        this.user = user;
        this.status = status;
    }

    public LoginOutput() {}
    
}