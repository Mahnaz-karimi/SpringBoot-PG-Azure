package com.springGradleapi.controller;

import com.springGradleapi.entity.EmployeeEntity;
import com.springGradleapi.entity.EmployeePage;
import com.springGradleapi.entity.EmployeeSearchCriteria;
import com.springGradleapi.kafka.KafkaProducer;
import com.springGradleapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;
    private com.springGradleapi.kafka.KafkaProducer producer;

    @Autowired
    public EmployeeController(EmployeeService employeeService, KafkaProducer producer) {
        this.employeeService = employeeService;
        this.producer = producer;
    }

    @GetMapping("/employee")
    public List<EmployeeEntity> findAllEmployee(){
    return employeeService.findAllEmployee();
    }
    @GetMapping("/employees")
    public ResponseEntity<Page<EmployeeEntity>> getEmployees(EmployeePage employeePage,
                                                             EmployeeSearchCriteria employeeSearchCriteria){
        return new ResponseEntity<>(employeeService.findAllEmployees(employeePage, employeeSearchCriteria),
                HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }
    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }
    @PutMapping
    public EmployeeEntity upadateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateEmployee(employeeEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }
// Kafka
    @PostMapping("/publish")
    public void writeMessageToTopic(@RequestParam("message") String message) {
        this.producer.writeMessage(message);
    }

}
