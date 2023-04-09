package com.ghostman.springboot.cruddemo.dao;

import com.ghostman.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
