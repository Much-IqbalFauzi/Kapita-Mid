/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.MidProject.service;

import com.simple.MidProject.entitas.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class RegisterRestService {
    @Autowired RestTemplate res;
    
    @Value("@{api.uri}")
    private String uri;
    
    public boolean register(Register reg) {
//        System.out.println(reg);
//        HttpEntity<Register> request = new HttpEntity<>(reg);
//        ResponseEntity<Register> responseEntity = res.exchange(
//                "https://116.254.101.228:8080/ma_test/register",
//                HttpMethod.POST,
//                request,
//                new ParameterizedTypeReference<Register>(){}
//        );
//        System.out.println("status :"+responseEntity.getStatusCodeValue());
//        ResponseEntity<LoginOutput> a = responseEntity;
//        return responseEntity.getStatusCodeValue;


        try {
            res.postForObject("http://116.254.101.228:8080/ma_test/register", reg, Register.class);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
