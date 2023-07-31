package com.springGradleapi.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "employees")
@Data // getter and setter and contracture
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @Column(name ="employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="employee_name")
    private String name;
    @Column(name ="employee_department")
    private String department;

}
