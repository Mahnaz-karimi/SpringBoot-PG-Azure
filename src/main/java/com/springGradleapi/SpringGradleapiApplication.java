package com.springGradleapi;

import com.springGradleapi.entity.EmployeeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j // for log.info
@SpringBootApplication
public class SpringGradleapiApplication {
	public static void main(String[] args) {

		SpringApplication.run(SpringGradleapiApplication.class, args);

		EmployeeEntity employee1 = new EmployeeEntity();
		employee1.setName("nr1");
		employee1.setDepartment("eco");
		employee1.setId(1L);

		log.info("Employee1: {}", employee1 );


		EmployeeEntity employee2 = EmployeeEntity.builder()
				.id(2L)
				.name("nr2")
				.department("it").build();

		log.info("Employee2:  {}", employee2 );
	}
}
