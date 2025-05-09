package com.example.demo.servicelmpl;

import com.guideMe.POJO.User;
import com.guideMe.constents.JobConstant;
import com.guideMe.repository.UserDao;
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
public abstract class UserServicelmpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userDao.findByEmail(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
                    return JobUtils.getResponseEntity("Sunccessuflly Registered", HttpStatus.OK);

                }
                else
                {
                    return  JobUtils.getResponseEntity("Email already exists.", HttpStatus.BAD_REQUEST);
                }

            } else {
                return JobUtils.getResponseEntity(JobConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return JobUtils.getResponseEntity(JobConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private boolean validateSignUpMap(Map<String,String> requestMap){
        if (requestMap.containsKey("fullname") && requestMap.containsKey("email")
                && requestMap.containsKey("password")){
            return true;
        }
        return false;
    }
    private User getUserFromMap(Map<String,String> requestMap){
        User user = new User();
        user.setFullName(requestMap.get("fullname"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        return user;
    }
}



