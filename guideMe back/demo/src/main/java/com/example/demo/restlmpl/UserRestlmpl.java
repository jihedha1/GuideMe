package com.example.demo.restlmpl;

import com.guideMe.constents.JobConstant;
import com.guideMe.controller.UserRest;
import com.guideMe.service.UserService;
import com.guideMe.utils.JobUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class UserRestlmpl implements UserRest {

    @Autowired
    UserService userService;


    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signup(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JobUtils.getResponseEntity(JobConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
