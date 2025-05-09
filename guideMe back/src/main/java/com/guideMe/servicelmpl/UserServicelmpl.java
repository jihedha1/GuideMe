package com.guideMe.servicelmpl;

import com.guideMe.POJO.User;
import com.guideMe.constents.JobConstant;
import com.guideMe.repository.UserRepository;
import com.guideMe.service.UserService;
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
public class UserServicelmpl implements UserService {

    @Autowired
    UserRepository userDao;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userDao.findByEmail(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
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

    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setFirst_name(requestMap.get("first_name"));
        user.setLast_name(requestMap.get("last_name"));


        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        return user;
    }
    @Override
    public ResponseEntity<String> login(String email, String password) {
        try {
            User user = userDao.findByEmail(email);
            if (user != null) {
                if (user.getPassword().equals(password)) {
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

}
