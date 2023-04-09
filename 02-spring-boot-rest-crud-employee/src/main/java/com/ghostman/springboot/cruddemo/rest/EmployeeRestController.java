package com.ghostman.springboot.cruddemo.rest;

import com.ghostman.springboot.cruddemo.entity.Employee;
import com.ghostman.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}



