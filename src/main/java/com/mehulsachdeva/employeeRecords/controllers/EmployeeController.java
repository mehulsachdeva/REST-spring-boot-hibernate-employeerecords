package com.mehulsachdeva.employeeRecords.controllers;

import com.mehulsachdeva.employeeRecords.models.Employee;
import com.mehulsachdeva.employeeRecords.services.EmployeeService.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employeerecords")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @RequestMapping("/store")
    public Map<String, String> storeEmployee(Employee employee) {
        return employeeServiceImpl.storeEmployee(employee);
    }

    @RequestMapping("/employees")
    public Map<String, String> fetchEmployees() {
        return employeeServiceImpl.fetchEmployees();
    }

    @RequestMapping("/employee/{employeeId}")
    public Map<String, String> fetchEmployeeById(@PathVariable("employeeId") int employeeId) {
        return employeeServiceImpl.fetchEmployeeById(employeeId);
    }

    @RequestMapping("/update")
    public Map<String, String> updateEmployeeById(Employee employee) {
        return employeeServiceImpl.updateEmployeeById(employee);
    }

    @RequestMapping("/delete/{employeeId}")
    public Map<String, String> deleteEmployeeById(@PathVariable("employeeId") int employeeId) {
        return employeeServiceImpl.deleteEmployeeById(employeeId);
    }
}
