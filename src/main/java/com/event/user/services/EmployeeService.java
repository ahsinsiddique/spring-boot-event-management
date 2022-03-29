
package com.event.user.services;

import com.event.user.entities.Employee;
import com.event.user.model.EmployeeModel;
import com.event.user.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Service for CRUD operations on employee domain entities.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieve all Employee domain entity instances.
     *
     * @return List of Employee
     */
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    /**
     * Retrieve all Employee domain entity instances.
     *
     * @param pageable object that has page and size property used in pagination.
     * @return List of Employee
     */
    public List<Employee> getEmployees(Pageable pageable) {
        return this.employeeRepository.findAll(pageable).getContent();
    }

    /**
     * Retrieve row count
     *
     * @return number row count
     */
    public Long getEmployeeCount() {
        return this.employeeRepository.count();
    }


    /**
     * Add/store a Empoyee
     *
     * @param employeeModel Domain entity instance to be added.
     */
    public Employee addEmployee(EmployeeModel employeeModel) {
        Employee employee = new Employee(employeeModel);

        if (!this.employeeRepository.existsByEmployeeId(employee.getEmployeeId())) {
            return this.employeeRepository.save(employee);
        } else {
            throw new IllegalArgumentException("Employee Id" + employee.getEmployeeId() + " Already Exists.");
        }
    }

    /**
     * Retrieve instance of Employee domain entity.
     *
     * @return instance of Employee
     */
    public Employee getEmployee(Integer seqEmployeeId) {
        if (this.employeeRepository.existsByEmployeeId(seqEmployeeId)) {
            return this.employeeRepository.findByEmployeeId(seqEmployeeId);
        } else {
            throw new EntityNotFoundException("Employee not found.");
        }
    }

    /**
     * Update Employee entity instance.
     *
     * @param employeeModel entity instance to be updated.
     * @param seqEmployeeId key.
     */
    public void updateEmployee(EmployeeModel employeeModel, Integer seqEmployeeId) {
        if (this.employeeRepository.existsByEmployeeId(seqEmployeeId)) {
            Employee employee = this.employeeRepository.findByEmployeeId(seqEmployeeId);

            employee.update(employeeModel);
            this.employeeRepository.save(employee);
        } else {
            throw new EntityNotFoundException("employee not found.");
        }
    }

    /**
     * delete Employee entity instance.
     *
     * @param seqEmployeeId Primary key.
     */
    @Transactional
    public void deleteEmployee(Integer seqEmployeeId) {
        if (this.employeeRepository.existsByEmployeeId(seqEmployeeId)) {
            Employee employee = this.employeeRepository.findByEmployeeId(seqEmployeeId);
            this.employeeRepository.deleteByEmployeeId(seqEmployeeId);
        } else {
            throw new EntityNotFoundException("Employee not found.");
        }

    }

}
