package com.ghostman.springboot.cruddemo.service;

import com.ghostman.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
