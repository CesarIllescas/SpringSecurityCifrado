package com.example.SpringSecurityCifrado;

import com.example.SpringSecurityCifrado.domain.User;
import com.example.SpringSecurityCifrado.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringSecurityCifradoApplication  {

	public static void main(String[] args) {

 			ApplicationContext context = SpringApplication.run(SpringSecurityCifradoApplication.class, args);

	}

}
