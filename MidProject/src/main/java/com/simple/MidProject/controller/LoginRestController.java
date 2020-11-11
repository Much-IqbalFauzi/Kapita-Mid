/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.controller;

import com.simple.MidProject.entitas.loginRest.LoginInput;
import com.simple.MidProject.service.LoginRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Controller
public class LoginRestController {
    
    @Autowired LoginRestService service;
    
    @GetMapping()
    public String index() {
        LoginInput input = new LoginInput();
        return "login";
    }
    
    @PostMapping()
    public String login(LoginInput input) {
        System.out.println(input);
        return "welcome";
    }
}

