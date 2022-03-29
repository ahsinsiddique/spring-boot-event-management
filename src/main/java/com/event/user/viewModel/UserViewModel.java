
package com.event.user.viewModel;

import com.event.user.entities.User;

import java.io.Serializable;

/**
 * Model Object used in the api for web service operations.
 */
public class UserViewModel implements Serializable {



    private String userId;
    private String password;

    public UserViewModel(User user) {
        this.userId = user.getUserID();
        this.password = user.getPassword();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
