
package com.event.user.controllers;

import com.event.user.entities.Employee;
import com.event.user.model.EmployeeModel;
import com.event.user.services.EmployeeService;
import com.event.user.viewModel.EmployeeViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * RESTful API endpoint for accessing Employee domain model/entity objects
 * as a resource.
 */
@RestController()
@Api(value = "Employee", description = "REST API for Employee", tags = { "Employee" })
@RequestMapping("/api/employee")
public class EmployeeRestController {

    private Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    private EmployeeService employeeService;

    /**
     * Constructor used to configure any dependent Spring Bean objects required
     * by this class.
     */
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    ObjectMapper objectMapper;

    /**
     * Retrieve all Employees
     *
     * @return List of Employees
     */
    @CrossOrigin
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<EmployeeViewModel>> getEmployees(
			@RequestParam(value = "use-pagination", defaultValue = "false", required = false) boolean usePagination,
	        @RequestParam(value = "page", defaultValue = "0", required = false) int page,
	        @RequestParam(value = "size", defaultValue = "50", required = false) int size,
	        @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
	        @RequestParam(value = "sort", defaultValue = "employeeId", required = false) String sortProperty) {
        List<Employee> employees;
        if(usePagination) {
            employees = this.employeeService.getEmployees(PageRequest.of(page, size, Sort.by(sortProperty)));
        } else {
            employees = this.employeeService.getEmployees();
        }

        if (employees.isEmpty()) {
            return new ResponseEntity<List<EmployeeViewModel>>(HttpStatus.NO_CONTENT);
        }

        List<EmployeeViewModel> employeeViewModels = new ArrayList<>();
        employees.forEach((employee) -> {
            employeeViewModels.add(new EmployeeViewModel(employee));
        });

        return new ResponseEntity<List<EmployeeViewModel>>(employeeViewModels, HttpStatus.OK);
    }


    /**
     * Retrieve row count
     *
     * @return number row count
     */
    @CrossOrigin
    @RequestMapping(value = "/count", method=RequestMethod.GET)
    public ResponseEntity<Long> getEmployeeCount() {
        Long employeeCount = this.employeeService.getEmployeeCount();
        return new ResponseEntity<Long>(employeeCount , HttpStatus.OK);
    }



    /**
     * Add/store a Employee
     *
     * @param employeeModel data
     */
    @CrossOrigin
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<EmployeeViewModel> addEmployee(@RequestBody EmployeeModel employeeModel) {
        Employee createdEmployee = this.employeeService.addEmployee(employeeModel);
        return new ResponseEntity<EmployeeViewModel>(new EmployeeViewModel(createdEmployee), HttpStatus.OK);
    }

    /**
     * Retrieve instance of Emp
     *
     * @param seqEmployeeId
     */
    @CrossOrigin
    @RequestMapping(value = "/{seqEmployeeId}", method=RequestMethod.GET)
    public ResponseEntity<EmployeeViewModel> getEmployee(@PathVariable Integer seqEmployeeId) {
        Employee employee = this.employeeService.getEmployee(seqEmployeeId);
        return new ResponseEntity<EmployeeViewModel>(new EmployeeViewModel(employee), HttpStatus.OK);
    }

    /**
     * Update a Emp
     *
     * @param employeeModel data
     * @param seqEmployeeId
     */
    @CrossOrigin
    @RequestMapping(value = "/{seqEmployeeId}", method=RequestMethod.PUT)
    public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeModel employeeModel, @PathVariable Integer seqEmployeeId) {
        this.employeeService.updateEmployee(employeeModel, seqEmployeeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


     /**
     * Delete a Emp
     *
     * @param seqEmployeeId
     */
    @CrossOrigin
    @RequestMapping(value = "/{seqEmployeeId}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer seqEmployeeId) {
        this.employeeService.deleteEmployee(seqEmployeeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
