package com.springGradleapi.controller;

import com.springGradleapi.entity.EmployeeEntity;
import com.springGradleapi.service.EmployeeService;
import com.springGradleapi.kafka.KafkaProducer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private List<EmployeeEntity> mockEmployeeList;
    private EmployeeEntity mockEmployee;
    @Mock
    private KafkaProducer producer;

    @BeforeEach
    public void setUp() {
        // Create a mock list of employees
        mockEmployeeList = new ArrayList<>();
        mockEmployee = new EmployeeEntity(1L, "John Doe", "john.doe@example.com");
        mockEmployeeList.add(mockEmployee);
        mockEmployeeList.add(new EmployeeEntity(2L, "Jane Smith", "jane.smith@example.com"));
    }
    @Test
    void testFindAllEmployee() {
        // Arrange: Set up the mock behavior for the service method
        when(employeeService.findAllEmployee()).thenReturn(mockEmployeeList);

        // Act: Call the controller method
        List<EmployeeEntity> result = employeeController.findAllEmployee();

        // Assert: Verify the result
        assertEquals(mockEmployeeList, result);
    }
    @Test
    public void testFindEmployeeById_ExistingEmployee() {
        // Arrange: Set up the mock behavior for the service method
        when(employeeService.findById(1L)).thenReturn(Optional.of(mockEmployee));

        // Act: Call the controller method with an existing ID
        Optional<EmployeeEntity> result = employeeController.findEmployeeById(1L);

        // Assert: Verify the result and employee details
        assertEquals(mockEmployee, result.orElse(null));
    }

    @Test
    public void testFindEmployeeById_NonExistingEmployee() {
        // Arrange: Set up the mock behavior for the service method
        when(employeeService.findById(2L)).thenReturn(Optional.empty());

        // Act: Call the controller method with a non-existing ID
        Optional<EmployeeEntity> result = employeeController.findEmployeeById(2L);

        // Assert: Verify the result is empty since the employee does not exist
        assertFalse(result.isPresent());
    }
    @Test
    void getEmployees() {
    }

    @Test
    public void testSaveEmployee() {
        // Arrange: Set up the mock behavior for the service method
        when(employeeService.saveEmployee(mockEmployee)).thenReturn(mockEmployee);

        // Act: Call the controller method with the mock employee
        EmployeeEntity result = employeeController.saveEmployee(mockEmployee);

        // Assert: Verify the result and employee details
        assertEquals(mockEmployee.getId(), result.getId());
        assertEquals(mockEmployee.getName(), result.getName());
        assertEquals(mockEmployee.getDepartment(), result.getDepartment());

        // Verify that the service method was called with the same employee
        verify(employeeService).saveEmployee(mockEmployee);
    }

    @Test
    public void testUpdateEmployee() {
        // Arrange: Set up the mock behavior for the service method
        when(employeeService.updateEmployee(mockEmployee)).thenReturn(mockEmployee);

        // Act: Call the controller method with the mock employee
        EmployeeEntity result = employeeController.upadateEmployee(mockEmployee);

        // Assert: Verify the result and employee details
        assertEquals(mockEmployee.getId(), result.getId());
        assertEquals(mockEmployee.getName(), result.getName());
        assertEquals(mockEmployee.getDepartment(), result.getDepartment());

        // Verify that the service method was called with the same employee
        verify(employeeService).updateEmployee(mockEmployee);
    }

    @Test
    public void testDeleteEmployee() {
        // Act: Call the controller method with the mock employee ID
        employeeController.deleteEmployee(1L);

        // Verify that the service method was called with the same employee ID
        verify(employeeService).deleteEmployee(1L);
    }
    @Test
    public void testWriteMessageToTopic() {
        // Act: Call the controller method with the mock message
        employeeController.writeMessageToTopic("Test message");

        // Verify that the producer's writeMessage method was called with the same message
        verify(producer).writeMessage("Test message");
    }
}









