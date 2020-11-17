/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.service;

import com.simple.MidProject.entitas.loginRest.LoginOutput;
import com.simple.MidProject.entitas.User;
import com.simple.MidProject.entitas.Address;
import com.simple.MidProject.entitas.Contact;
import com.simple.MidProject.entitas.CurrentOccupationData;
import com.simple.MidProject.entitas.EducationData;
import com.simple.MidProject.entitas.Major;
import com.simple.MidProject.entitas.University;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Service
public class GeneralRestService {
    @Autowired RestTemplate res;
    
    @Value("${api.uri}")
    private String uri;
    
    public List<University> getAllUniv() {
        ResponseEntity<List<University>> response = res.exchange(
                uri+"/get/universities", 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<University>>() {});
        List<University> result = response.getBody();
        return result;
    }
    
    public List<Major> getAllMajor() {
        ResponseEntity<List<Major>> response = res.exchange(
                uri+"/get/majors", 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<Major>>() {});
        List<Major> result = response.getBody();
        return result;
    }
    
    public User basicId(String id) {
        User user;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        user = res.getForObject(uri+"/profile/basic/{id}", User.class, param);
        return user;
    }
    
    public Address addressId(String id) {
        Address addr;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        addr = res.getForObject(uri+"/profile/address/{id}", Address.class, param);
        return addr;
    }
    
    public Contact contactId(String id) {
        Contact contact;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        contact = res.getForObject(uri+"/profile/contact/{id}", Contact.class, param);
        return contact;
    }
    
    public CurrentOccupationData occupationId(String id) {
        CurrentOccupationData occup;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        occup = res.getForObject(uri+"/profile/currentoccupation/{id}", CurrentOccupationData.class, param);
        return occup;
    }
    
    public EducationData eduId(String id) {
        EducationData edu;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        edu = res.getForObject(uri+"/profile/education/{id}", EducationData.class, param);
        return edu;
    }
    
    public boolean updateBasic(User user) {
        try {
            res.postForObject(uri+"/profile/basic", user, User.class);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean updateAddress(Address addr) {
        try {
            res.postForObject(uri+"/profile/address", addr, Address.class);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean updateContact(Contact contact) {
        try {
            res.postForObject(uri+"/profile/contact", contact, Contact.class);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean updateOccup(CurrentOccupationData occup) {
        try {
            res.postForObject(uri+"/profile/currentoccupation", occup, CurrentOccupationData.class);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean updateEdu(EducationData edu) {
        try {
            res.postForObject(uri+"/profile/education", edu, EducationData.class);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public String getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginOutput data = (LoginOutput)authentication.getPrincipal();
        return data.getUser().getId();
    }
    
}
