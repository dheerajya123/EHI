package com.ehi.EHIProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ehi.EHIProject.Controller.ContactService;

@SpringBootApplication
public class EhiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhiProjectApplication.class, args);
	}
	
	@Bean
	public ContactService getContactService()
	{
		return new ContactService();
	}

}
