
package com.event.user.viewModel;

import java.io.Serializable;

import com.event.user.entities.*;

/**
 * Model Object used in the api for web service operations.
 */
public class EmployeeViewModel implements Serializable {

    public EmployeeViewModel(Employee employee) {
        this.setName(employee.getName());
        this.setEmployeeId(employee.getEmployeeId());
        this.setSupervisors(employee.getSupervisors());
        this.setPhoneNumber(employee.getPhoneNumber());

    }

    private Integer employeeId;

    private String name;

    private String phoneNumber;

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
