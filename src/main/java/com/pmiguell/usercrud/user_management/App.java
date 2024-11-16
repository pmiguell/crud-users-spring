package com.pmiguell.usercrud.user_management;

import com.pmiguell.usercrud.user_management.model.User;
import com.pmiguell.usercrud.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
    }
}
