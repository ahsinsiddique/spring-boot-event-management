
package com.event.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(schema = "event-management", name = "User")
public class User implements Serializable {

    public User(){
    }
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "This field may not be null.")
    @Column(name = "USER_ID")
    private String userID;



    public void setPassword(String password) {
        this.password = password;
    }

    @Size(max = 45)
    @Column(name = "PASSWORD")
    private String password;



    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        boolean isEqual = true;
        return isEqual;
    }
}
