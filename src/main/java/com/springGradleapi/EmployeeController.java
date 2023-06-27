package com.springGradleapi;

import com.springGradleapi.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final com.springGradleapi.kafka.KafkaProducer producer;

    public EmployeeController(KafkaProducer producer) {
        this.producer = producer;}

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
    @PostMapping("/publish")
    public void writeMessageToTopic(@RequestParam("message") String message){
        this.producer.writeMessage(message);

    }
}
