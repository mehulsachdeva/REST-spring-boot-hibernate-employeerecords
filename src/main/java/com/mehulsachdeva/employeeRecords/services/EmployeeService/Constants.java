package com.mehulsachdeva.employeeRecords.services.EmployeeService;

public class Constants {
    public static final String INSERT_SUCCESS_RESPONSE = "Employee Added Successfully";
    public static final String INSERT_FAILURE_RESPONSE = "Failed To Insert Employee";

    public static final String FETCH_EMPTY_RESPONSE = "[]";
    public static final String FETCH_FAILURE_RESPONSE = "Failed To Fetch Employees";

    public static final String UPDATE_SUCCESS_RESPONSE = "Employee Details Updated Successfully";
    public static final String UPDATE_FAILURE_RESPONSE = "Failed To Update Employee Details";
    public static final String UPDATE_NO_EMPLOYEE_FOUND_RESPONSE = "No Employee Found With ID";

    public static final String DELETE_SUCCESS_RESPONSE = "Employee Deleted Successfully";
    public static final String DELETE_FAILURE_RESPONSE = "Failed To Delete Employee";
    public static final String DELETE_NO_EMPLOYEE_FOUND_RESPONSE = "No employee Found With ID";

    public static final String FETCH_PAGES_FAILURE_RESPONSE = "";

    public static final String SUCCESS_STATUS = "Success";
    public static final String FAILED_STATUS = "Failure";
    public static final String NO_ERROR = "";
    public static final String EXCEPTION_RAISED = "Exception Raised: ";

    //SQL Query
    public static final String UPDATE_EMPLOYEE_DEPARTMENT_QUERY = "UPDATE employees SET department = :department WHERE employee_id = :employee_id";
    public static final String FETCH_EMPLOYEE_WITH_DEPT_AND_LESS_THAN_AGE_QUERY = "SELECT * FROM employees WHERE department = :department AND age < :age";
}
