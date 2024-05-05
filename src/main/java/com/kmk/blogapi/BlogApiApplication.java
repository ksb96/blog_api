package com.kmk.blogapi;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kmk.blogapi.config.AppConstants;
import com.kmk.blogapi.entities.Role;
import com.kmk.blogapi.repo.RoleRepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;

@SpringBootApplication
//swagger
@OpenAPIDefinition(
		info = @Info(
				title = "Blog application api documentation",
				version = "1.0.0",
				description = "Detailed Api documentation",
				contact = @Contact(
						name = "ksb96"
						),
				license = @License(
						name = "@ksb96"
						)
				))
public class BlogApiApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepo roleRepo;

	//application starts from here
	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("111"));//basic authentication-NOT RECOMMENDED
	
	try {
		Role role = new Role();
		role.setId(AppConstants.ADMIN_USER);
		role.setName("ADMIN_USER");
		
		Role role1 = new Role();
		role1.setId(AppConstants.NORMAL_USER);
		role1.setName("NORMAL_USER");
		
		
		List<Role> roles = List.of(role, role1);
		List<Role> result = this.roleRepo.saveAll(roles);//save roles on DB
		
		//display save results
		result.forEach(r->{
			System.out.println(r.getName());
		});
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	}
}
