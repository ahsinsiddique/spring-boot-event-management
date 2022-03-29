
package com.event.user.entities;

import com.event.user.model.EmployeeModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;



@Entity
@Table(schema = "event-management", name = "Employee")
public class Employee implements Serializable {

    public Employee(){
    }
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "This field may not be null.")
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

    @Size(max = 45)
    @Column(name = "NAME")
    private String name;


    @Size(max = 45)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;


    @Size(max = 45)
    @Column(name = "SUPERVISORS")
    private String supervisors;

    public Employee(EmployeeModel employeeModel) {
        this.employeeId = employeeModel.getEmployeeId();
        this.name = employeeModel.getName();
        this.phoneNumber = employeeModel.getPhoneNumber();
        this.supervisors = employeeModel.getSupervisors();
    }

    public void update(EmployeeModel employeeModel){
        this.name = employeeModel.getName();
        this.phoneNumber = employeeModel.getPhoneNumber();
        this.supervisors = employeeModel.getSupervisors();
    }





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




    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        boolean isEqual = true;
        return isEqual;
    }
}
