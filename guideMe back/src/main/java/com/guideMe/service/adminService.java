package com.guideMe.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface adminService {
    ResponseEntity<String> signupadmin(Map<String, String> requestMap);
    ResponseEntity<String> login(String email, String password);
}
