package com.example.details.repository;

import com.example.details.domain.entiry.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository {
    Employee getById(String id);
    Collection<Employee> getAll();
    String save(Employee employee);

}