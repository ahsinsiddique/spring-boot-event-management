
package com.event.user.controllers;

import com.event.user.entities.User;
import com.event.user.model.UserModel;
import com.event.user.services.UserService;
import com.event.user.viewModel.UserViewModel;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * RESTful API endpoint for accessing User domain model/entity objects
 */
@RestController()
@Api(value = "User", description = "REST API for User", tags = { "User" })
@RequestMapping("/api/users")
public class UserRestController {

    private Logger logger = LoggerFactory.getLogger(UserRestController.class);

    private UserService userService;

    /**
     * Constructor used to configure any dependent Spring Bean objects required
     * by this class.
     */
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }



    /**
     * Retrieve instance of User
     *
     * @param userModel
     */
    @CrossOrigin
    @RequestMapping(value = "/get-user", method=RequestMethod.POST)
    public ResponseEntity<UserViewModel> getEmployee(@RequestBody UserModel userModel) {
        User user = this.userService.getEmployees(userModel);
        if (Objects.isNull(user)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new UserViewModel(user), HttpStatus.OK);
    }

}
