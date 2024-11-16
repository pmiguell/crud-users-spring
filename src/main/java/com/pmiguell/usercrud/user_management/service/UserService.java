package com.pmiguell.usercrud.user_management.service;

import com.pmiguell.usercrud.user_management.handler.BusinessException;
import com.pmiguell.usercrud.user_management.handler.RequiredFieldException;
import com.pmiguell.usercrud.user_management.model.User;
import com.pmiguell.usercrud.user_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) {
        if(user.getName() == null) {
            throw new RequiredFieldException("name");
        }

        if(user.getUsername() == null) {
            throw new RequiredFieldException("username");
        }

        if(user.getPassword() == null) {
            throw new RequiredFieldException("password");
        }

        if (user.getId() == null) {
            userRepository.save(user);
        } else {
            Optional<User> existingUser = userRepository.findById(user.getId());
            if (existingUser.isPresent()) {
                User updatedUser = existingUser.get();
                updatedUser.setName(user.getName());
                updatedUser.setUsername(user.getUsername());
                updatedUser.setPassword(user.getPassword());
                updatedUser.setId(user.getId());
                userRepository.save(updatedUser);
            }
        }
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
