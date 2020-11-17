/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.controller;

import com.simple.MidProject.entitas.Address;
import com.simple.MidProject.entitas.Contact;
import com.simple.MidProject.entitas.CurrentOccupationData;
import com.simple.MidProject.entitas.EducationData;
import com.simple.MidProject.entitas.Register;
import com.simple.MidProject.entitas.loginRest.LoginInput;
import com.simple.MidProject.entitas.User;
import com.simple.MidProject.entitas.loginRest.LoginOutput;
import com.simple.MidProject.entitas.loginRest.UserOutput;
import com.simple.MidProject.service.GeneralRestService;
import com.simple.MidProject.service.LoginRestService;
import com.simple.MidProject.service.RegisterRestService;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Controller
public class RestController {
    
    UserOutput userOu;
    
    @Autowired LoginRestService serviceLogin;
    
    @Autowired RegisterRestService serviceRegis;
    
    @Autowired GeneralRestService serviceGeneral;
    
    @GetMapping()
    public String init(){
        return "redirect:login";
    }
    
    @GetMapping("login")
    public String loginPage(Model model, @RequestParam(value = "error", required = false) String err, @RequestParam(value = "success", required = false) String succ) {
        model.addAttribute("loginInput", new LoginInput());
        model.addAttribute("registerForm", new Register());
        //
        model.addAttribute("universities", serviceGeneral.getAllUniv());
        model.addAttribute("majors", serviceGeneral.getAllMajor());
        if(err != null ){
            model.addAttribute("error", true);
        }
        if(succ != null) {
            model.addAttribute("success", true);
        }
        return "login";
    }
    
    @GetMapping("xxx")
    public String iya(@RequestParam(value="user", required=true) Model model) {
        model.addAttribute("user", "hello");
        return "login";
    }
    
    @PostMapping("register")
    public String regis(Register reg) {
        if (serviceRegis.register(reg)) {
            return "redirect:login";
        } else {
            return "redirect:login";
        }
    }
    
    @PostMapping("redirect")
    public String redirect(LoginInput input) {
        if(serviceLogin.login(input).getStatus().equals("Verified")) {
            userOu = serviceLogin.login(input).getUser();
            return "redirect:login?success=true";
        } else {
            return "redirect:login?error=true";
        }
    }
    
    @GetMapping("welcome")
    public String landingPage(Model model) {
        model.addAttribute("basic", serviceGeneral.basicId(this.userOu.getId()));
        model.addAttribute("addressData", serviceGeneral.addressId(this.userOu.getId()));
        model.addAttribute("contactData", serviceGeneral.contactId(this.userOu.getId()));
        model.addAttribute("occupData", serviceGeneral.occupationId(this.userOu.getId()));
        model.addAttribute("eduData", serviceGeneral.eduId(this.userOu.getId()));
//        model.addAttribute("name", serviceGeneral.basicId(this.userOu.getId()).getName());
        //
        model.addAttribute("universities", serviceGeneral.getAllUniv());
        model.addAttribute("majors", serviceGeneral.getAllMajor());
        return "welcome";
    }
    
    @PostMapping("updatePersonal")
    public String basicUpdate(User user) {
        serviceGeneral.updateBasic(user);
        return "redirect:welcome";
    }
    
    @PostMapping("updateAddress")
    public String addressUpdate(Address addr) {
        serviceGeneral.updateAddress(addr);
        return "redirect:welcome";
    }
    
    @PostMapping("updateContact")
    public String contactUpdate(Contact contact) {
        serviceGeneral.updateContact(contact);
        return "redirect:welcome";
    }
    
    @PostMapping("updateOccupation")
    public String occupUpdate(CurrentOccupationData occup) {
        serviceGeneral.updateOccup(occup);
        return "redirect:welcome";
    }
    
    @PostMapping("updateEducation")
    public String eduUpdate(EducationData edu) {
        serviceGeneral.updateEdu(edu);
        return "redirect:welcome";
    }
    
    @GetMapping("logout")
    public String logout() {
        this.userOu = null;
        return "redirect:login";
    }
}

