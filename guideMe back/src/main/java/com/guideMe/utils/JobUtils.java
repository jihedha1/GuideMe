// Contient les classes utilitaires qui offrent des fonctions réutilisables.
package com.guideMe.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JobUtils {


    public JobUtils(String s, HttpStatus badRequest){

    }


    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);

    }
}
