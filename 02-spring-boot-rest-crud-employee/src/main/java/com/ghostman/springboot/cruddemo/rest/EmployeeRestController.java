package com.ghostman.springboot.cruddemo.rest;

import com.ghostman.springboot.cruddemo.entity.Employee;
import com.ghostman.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // Not needed as we will be using service instead of const injection
//    private EmployeeDAO employeeDAO;

    private EmployeeService employeeService;

    //inject the employee DAO directly

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService=theEmployeeService;
    }

    // expose employees "/employees" endpoint and return all the employee
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee==null) {
            throw new RuntimeException("Employee id not in database");
        }
        return theEmployee;
    }

    // Add Post method mapping for adding new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id to JSOn...set it to 0
        // this is to force a save of new item...instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // Add mapping for updating employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // Add mapping for deleting employee

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee=employeeService.findById(employeeId);

        //throw exception if null
        if(tempEmployee==null) {
            throw new RuntimeException("id not found - "  + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted Employee - " + employeeId;
    }
}



