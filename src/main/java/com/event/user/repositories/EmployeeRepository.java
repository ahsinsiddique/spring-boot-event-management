
package com.event.user.repositories;

import com.event.user.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmployeeId(Integer employeeId);
    boolean existsByEmployeeId(Integer employeeId);
    void deleteByEmployeeId(Integer employeeId);


    @Modifying
    @Transactional
    @Query(value="insert into employee (employee_id, name, phone_number ) " +
            " values (:id, :name, :phoneNumber);", nativeQuery = true)
    void saveData(@Param("id") Integer id, @Param("name") String name, @Param("phoneNumber") String phoneNumber );
}
