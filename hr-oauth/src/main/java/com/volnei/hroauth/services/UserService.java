package com.volnei.hroauth.services;

import com.volnei.hroauth.entities.User;
import com.volnei.hroauth.feignclients.UserFeignCLient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignCLient userFeignCLient;

    public User findByEmail(String email) {
        User user = userFeignCLient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }

        logger.info("Email found: " + email);

        return user;
    }
}
