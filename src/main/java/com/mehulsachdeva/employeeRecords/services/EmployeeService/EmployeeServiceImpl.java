package com.mehulsachdeva.employeeRecords.services.EmployeeService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehulsachdeva.employeeRecords.models.Employee;
import com.mehulsachdeva.employeeRecords.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ResponseBuilder responseBuilder;

    public Map<String, String> storeEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return responseBuilder.createResponse(
                    Constants.SUCCESS_STATUS,
                    Constants.INSERT_SUCCESS_RESPONSE,
                    Constants.NO_ERROR
            );
        }catch (Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.INSERT_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> fetchEmployees() {
        try {
            List<Employee> employees = employeeRepository.findAll();
            if(employees.size() > 0) {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        new ObjectMapper().writeValueAsString(employees),
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.FETCH_EMPTY_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch (Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> fetchEmployeeById(int employee_id) {
        try {
            Optional<Employee> employeeContainerObj = employeeRepository.findById(employee_id);
            if(employeeContainerObj.isPresent()) {
                List<Employee> employee = new ArrayList<>();
                employee.add(employeeContainerObj.get());
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        new ObjectMapper().writeValueAsString(employee),
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.FETCH_EMPTY_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch (Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> updateEmployeeById(Employee employee) {
        try {
            Optional<Employee> employeeContainerObj = employeeRepository.findById(employee.getEmployeeId());
            if(employeeContainerObj.isPresent()) {
                employeeRepository.save(employee);
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.UPDATE_SUCCESS_RESPONSE,
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.UPDATE_NO_EMPLOYEE_FOUND_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch (Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.UPDATE_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> deleteEmployeeById(int employer_id) {
        try {
            Optional<Employee> employeeContainerObj = employeeRepository.findById(employer_id);
            if(employeeContainerObj.isPresent()) {
                employeeRepository.deleteById(employer_id);
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.DELETE_SUCCESS_RESPONSE,
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.DELETE_NO_EMPLOYEE_FOUND_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.DELETE_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> fetchEmployeesByDepartment(String department) {
        try {
            List<Employee> employees = employeeRepository.findByDepartment(department);
            if(employees.size() > 0) {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        new ObjectMapper().writeValueAsString(employees),
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.FETCH_EMPTY_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> fetchEmployeesByDOJAfter(Date doj) {
        try {
            List<Employee> employees = employeeRepository.findByDojAfter(doj);
            if(employees.size() > 0) {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        new ObjectMapper().writeValueAsString(employees),
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.FETCH_EMPTY_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.FETCH_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }

    public Map<String, String> updateEmployeeDepartment(int employee_id, String department) {
        try {
            Optional<Employee> employeeContainerObj = employeeRepository.findById(employee_id);
            if(employeeContainerObj.isPresent()) {
                employeeRepository.updateEmployeeDepartment(employee_id, department);
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.UPDATE_SUCCESS_RESPONSE,
                        Constants.NO_ERROR
                );
            }else {
                return responseBuilder.createResponse(
                        Constants.SUCCESS_STATUS,
                        Constants.UPDATE_NO_EMPLOYEE_FOUND_RESPONSE,
                        Constants.NO_ERROR
                );
            }
        }catch(Exception e) {
            return responseBuilder.createResponse(
                    Constants.FAILED_STATUS,
                    Constants.UPDATE_FAILURE_RESPONSE,
                    Constants.EXCEPTION_RAISED + String.valueOf(e)
            );
        }
    }
}
