package com.springGradleapi;

import com.springGradleapi.entity.EmployeeEntity;
import com.springGradleapi.entity.Role;
import com.springGradleapi.entity.UserEntity;
import com.springGradleapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j // for log.info
@SpringBootApplication
public class SpringGradleapiApplication {
	public static void main(String[] args) {

		SpringApplication.run(SpringGradleapiApplication.class, args);

		UserEntity user = new UserEntity();
		user.setUsername("exampleUser");
		user.setPassword("password");

		Role role1 = new Role();
		role1.setName("ROLE_ADMIN");

		Role role2 = new Role();
		role2.setName("ROLE_USER");

		user.getRoles().add(role1);
		user.getRoles().add(role2);

		log.info("User and roles: {}", user );


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
