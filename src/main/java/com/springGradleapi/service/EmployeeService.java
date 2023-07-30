package com.springGradleapi.service;

import com.springGradleapi.entity.EmployeeEntity;
import com.springGradleapi.entity.EmployeePage;
import com.springGradleapi.entity.EmployeeSearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeEntity> findAllEmployee();
    Page<EmployeeEntity> findAllEmployees(EmployeePage employeePage,
                                         EmployeeSearchCriteria employeeSearchCriteria);
    Optional<EmployeeEntity> findById(Long id);
    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    void deleteEmployee(Long id);

}