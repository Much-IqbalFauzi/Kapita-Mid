/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.service;

import com.simple.MidProject.entitas.loginRest.LoginOutput;
import com.simple.MidProject.entitas.loginRest.LoginInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Service
public class LoginRestService {
    @Autowired RestTemplate res;
    
    public String login(LoginInput input) {
        HttpEntity<LoginInput> request = new HttpEntity<>(input);
        ResponseEntity<LoginOutput> responseEntity = res.exchange(
                "http://116.254.101.228:8080/ma_test/login",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<LoginOutput>(){}
        );
        if(responseEntity.getBody().equals("Unregistered Account")) {
            return "User not yet registered!";
        } else {
            return "true";
        }
    }
}
