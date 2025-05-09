package com.guideMe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path = "/administrator")
public interface adminRest {

    // Route pour la création d'un administrateur (signup)
    @PostMapping(path = "/signup")
    ResponseEntity<String> signupadmin(@RequestBody Map<String, String> requestMap);

    // Route pour la connexion de l'administrateur
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody Map<String, String> requestMap);

    // Route pour la mise à jour du profil d'un administrateur avec l'email
    @PutMapping("/update/email/{email}")
    ResponseEntity<String> updateProfileByEmail(@PathVariable("email") String email,
                                                @RequestBody Map<String, String> requestMap);
}
