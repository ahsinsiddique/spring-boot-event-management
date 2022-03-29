
package com.event.user.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Model Object used in the api for web service operations.
 */
public class UserModel implements Serializable {
    public UserModel(){
    }
    private static final long serialVersionUID = 1L;

    @NotNull(message = "This field may not be null.")
    private String userId;



    public void setPassword(String password) {
        this.password = password;
    }

    @Size(max = 45)
    private String password;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

}
