/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.service;

import com.simple.MidProject.entitas.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    public User getById(String id) {
        User user;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        user = res.getForObject(uri+"/profile/basic/{id}", User.class, param);
        return user;
    }
    
    public String basicUpdate(User user) {
        res.postForObject(uri+"/profile/basic", user, User.class);
        return "oke";
    }
    
}
