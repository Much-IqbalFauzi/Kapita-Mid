/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.service;

import com.simple.MidProject.entitas.loginRest.LoginInput;
import com.simple.MidProject.entitas.loginRest.LoginOutput;
import com.simple.MidProject.entitas.loginRest.UserOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
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
public class LoginRestService {
    @Autowired RestTemplate res;
    
    @Value("@{api.uri}")
    private String uri;
    
    public LoginOutput login(LoginInput input) {
//        System.out.println(input);
        HttpEntity<LoginInput> request = new HttpEntity<>(input);
        ResponseEntity<LoginOutput> responseEntity = res.exchange(
                "http://116.254.101.228:8080/ma_test/login",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<LoginOutput>(){}
        );
        System.out.println("status :"+responseEntity.getStatusCodeValue());
//        ResponseEntity<LoginOutput> a = responseEntity;
        return responseEntity.getBody();
    }
    
    public void logout(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(false);
    }
}
