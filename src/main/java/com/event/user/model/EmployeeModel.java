
package com.event.user.model;


import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * A Model Object used in the api for web service operations.
 */
public class EmployeeModel implements Serializable {
    public EmployeeModel(){
    }
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "This field may not be null.")
    @NotEmpty(message = "This field is required.")
    private Integer employeeId;

    @Size(max = 45)
    private String name;


    @Size(max = 45)
    private String phoneNumber;


    @Size(max = 45)
    private String supervisors;




    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(String supervisors) {
        this.supervisors = supervisors;
    }


}
