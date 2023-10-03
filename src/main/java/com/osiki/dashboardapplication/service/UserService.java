package com.osiki.dashboardapplication.service;

import com.osiki.dashboardapplication.model.UserModel;
import com.osiki.dashboardapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // dependency injection
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel registerUser(String login, String email, String password){
        /**
         * check for null values
         * check for duplicate login
         */

        if(login == null || password == null){
            return null;
        }else {
            if(userRepository.findFirstByLogin(login).isPresent()){
                System.out.println("User Already exists");
                return null;
            }

            UserModel user = new UserModel();

            user.setLogin(login);
            user.setEmail(email);
            user.setPassword(password);

            userRepository.save(user);

            return user;
        }

    }

    public UserModel authenticate(String login, String password){
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
