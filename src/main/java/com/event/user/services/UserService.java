
package com.event.user.services;

import com.event.user.entities.User;
import com.event.user.model.UserModel;
import com.event.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for CRUD operations on User domain entities.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieve all Employee domain entity instances.
     *
     * @return List of Employee
     */
    public User getEmployees(UserModel userModel) {
        return this.userRepository.findByUserIDAndPassword(userModel.getUserId(), userModel.getPassword());
    }

}
