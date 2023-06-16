package com.springGradleapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/employee")
    public List<EmployeeEntity> retrieveEmployee(){
        return repository.findAll();
    }
    @PostMapping
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee){
        return repository.save(employee);
    }

    @PutMapping
    public EmployeeEntity upadateEmployee(@RequestBody EmployeeEntity employee){
        return repository.save(employee);
    }
}
