package com.mehulsachdeva.employeeRecords.services.EmployeeService;

import com.mehulsachdeva.employeeRecords.models.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(String department);
    List<Employee> findByDojAfter(Date doj);

    @Transactional
    @Modifying
    @Query(value = Constants.UPDATE_EMPLOYEE_DEPARTMENT_QUERY, nativeQuery = true)
    void updateEmployeeDepartment(@Param("employee_id") int employee_id, @Param("department") String department);

    @Query(value = Constants.FETCH_EMPLOYEE_WITH_DEPT_AND_LESS_THAN_AGE_QUERY, nativeQuery = true)
    List<Employee> fetchDAEmployeeAgeLessThan24(@Param("department") String department, @Param("age") int age);
}
