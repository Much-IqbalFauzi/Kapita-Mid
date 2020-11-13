/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.controller;

import com.simple.MidProject.entitas.loginRest.LoginInput;
import com.simple.MidProject.entitas.User;
import com.simple.MidProject.entitas.loginRest.LoginOutput;
import com.simple.MidProject.entitas.loginRest.UserOutput;
import com.simple.MidProject.service.GeneralRestService;
import com.simple.MidProject.service.LoginRestService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Controller
public class RestController {
    
    UserOutput userOu;
    
    @Autowired LoginRestService serviceLogin;
    
    @Autowired GeneralRestService serviceGen;
    
    @GetMapping("")
    public String welcome(Model model) {
        model.addAttribute("loginInput", new LoginInput());
        return "login";
    }
    
    @PostMapping("redirect")
    public String redirect(LoginInput input) {
        System.out.println(serviceLogin.login(input).getStatus());
        if(serviceLogin.login(input).getStatus().equals("Verified")) {
            userOu = serviceLogin.login(input).getUser();
            System.out.println("Oke,Account Verfied ===>>>" + serviceLogin.login(input).getUser().getId());
            //model.addAttribute("name", serviceGen.getById(serviceLogin.login(input).getUser().getId()).getName());
            System.out.println(serviceGen.getById(serviceLogin.login(input).getUser().getId()).getBirthDate());
//            LoginOutput login = serviceLogin.login(input).getBody();
//            model.addAttribute("name", serviceGen.getById(login.getUser().getId()).getName());
            return "redirect:welcome";
        } else {
            return "redirect:/";
        }
    }
    
    @GetMapping("welcome")
    public String landingPage(Model model) {
        model.addAttribute("basic", serviceGen.getById(this.userOu.getId()));
        return "welcome";
    }
    
    @PostMapping("update")
    public String basicUpdate(User basic) {
        System.out.println("user gannn =>>> " + basic.getBirthDate());
        System.out.println(basic.getEmail());
        System.out.println(basic.getName());
        System.out.println(basic.getGender());
//        serviceGen.basicUpdate(user);
        return "redirect:welcome";
    }
    
    
}

