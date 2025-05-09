package com.guideMe.restImpl;
import com.guideMe.POJO.administrator;
import com.guideMe.repository.AdminRepository;
import com.guideMe.controller.adminRest;
import com.guideMe.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class adminRestlmpl implements adminRest {

    @Autowired
    private adminService adminService; // ici c'est CORRECT
    @Autowired
    private AdminRepository AdminRepository;

    @Override
    public ResponseEntity<String> signupadmin(@RequestBody Map<String, String> requestMap) {
        return adminService.signupadmin(requestMap);
    }

    @Override
    public ResponseEntity<String> login(@RequestBody Map<String, String> requestMap) {
        return adminService.login(requestMap.get("email"), requestMap.get("password"));
    }

    @Override
    public ResponseEntity<String> updateProfileByEmail(String email, Map<String, String> requestMap) {
        // Cherche l'administrateur par email
        administrator admin = AdminRepository.findByEmail(email);

        if (admin != null) { // findByEmail ne retourne pas un Optional
            // Mise à jour du nom si fourni
            if (requestMap.containsKey("email")) {
                admin.setEmail(requestMap.get("email"));
            }

            // Sauvegarder l'admin modifié
            AdminRepository.save(admin);

            return ResponseEntity.ok("Profil administrateur mis à jour avec succès");
        } else {
            return ResponseEntity.status(404).body("Administrateur non trouvé");
        }
    }
}