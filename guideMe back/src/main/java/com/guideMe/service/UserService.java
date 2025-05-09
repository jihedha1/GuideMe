// Interfaces des services (logique métier).
package com.guideMe.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> signup(Map<String, String> requestMap);
    ResponseEntity<String> login(String email, String password);

}
