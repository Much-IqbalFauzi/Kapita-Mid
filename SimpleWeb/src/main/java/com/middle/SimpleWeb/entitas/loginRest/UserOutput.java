/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.middle.SimpleWeb.entitas.loginRest;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Data
public class UserOutput {
    private String id, name, email;
    private List<String> roles;
}

