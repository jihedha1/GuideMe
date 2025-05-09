package com.guideMe.servicelmpl;

import com.guideMe.POJO.administrator;
import com.guideMe.constents.JobConstant;
import com.guideMe.repository.AdminRepository;
import com.guideMe.service.adminService;
import com.guideMe.utils.JobUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
@Slf4j
@Service
public class adminServicelmpl implements adminService {

    @Autowired
    AdminRepository AdminRepository;

    @Override
    public ResponseEntity<String> signupadmin(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                administrator administrator = AdminRepository.findByEmail(requestMap.get("email"));
                if (Objects.isNull(administrator)) {
                    AdminRepository.save(getAdminFromMap(requestMap));
                    return JobUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
                } else {
                    return JobUtils.getResponseEntity("Email already exists.", HttpStatus.BAD_REQUEST);
                }
            } else {
                return JobUtils.getResponseEntity(JobConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            log.error("Error occurred while processing signup", ex);
            return JobUtils.getResponseEntity(JobConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        return requestMap.containsKey("first_name") && requestMap.containsKey("last_name")  && requestMap.containsKey("email") && requestMap.containsKey("password");
    }

    private administrator getAdminFromMap(Map<String, String> requestMap) {
        administrator administrator = new administrator();
        administrator.setFirst_name(requestMap.get("first_name"));   // OK
        administrator.setLast_name(requestMap.get("last_name"));     // OK
        administrator.setCin(requestMap.get("cin") != null ? Long.parseLong(requestMap.get("cin")) : null); // OK
        administrator.setEmail(requestMap.get("email"));             // OK
        administrator.setPhone_number(requestMap.get("phone_number"));// OK
        administrator.setPassword(requestMap.get("password"));       // OK
        administrator.setAdress(requestMap.get("address"));           // OK
        administrator.setCard_number(requestMap.get("card_number")); // OK
        administrator.setConnected(requestMap.get("connected"));     // OK
        administrator.setLocal_type(requestMap.get("local_type"));   // OK
        return administrator;
    }


    @Override
    public ResponseEntity<String> login(String email, String password) {
        try {
            administrator administrator = AdminRepository.findByEmail(email);
            if (administrator != null) {
                if (administrator.getPassword().equals(password)) {
                    administrator.setConnected("oui"); // ✅ mettre connected à "oui"
                    AdminRepository.save(administrator);      // ✅ sauvegarder dans la base

                    return JobUtils.getResponseEntity("Connexion réussie", HttpStatus.OK);
                } else {
                    return JobUtils.getResponseEntity("Mot de passe incorrect", HttpStatus.UNAUTHORIZED);
                }
            } else {
                return JobUtils.getResponseEntity("Utilisateur non trouvé", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Erreur lors de la tentative de connexion", e);
            return JobUtils.getResponseEntity(JobConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<String> updateEmail( String newEmail) {
        try {
            // Trouver l'administrateur par ID
            administrator admin = AdminRepository.findByEmail(newEmail);

            if (admin == null) {
                return JobUtils.getResponseEntity("Administrator not found", HttpStatus.NOT_FOUND);
            }

            // Mettre à jour l'email
            admin.setEmail(newEmail);

            // Sauvegarder les modifications dans la base de données
            AdminRepository.save(admin);

            return JobUtils.getResponseEntity("Email successfully updated", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while updating email", e);
            return JobUtils.getResponseEntity(JobConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}