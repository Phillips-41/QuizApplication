package com.infobyte.quiz;

//import com.infobyte.quiz.auth.AuthenticationService;
//import com.infobyte.quiz.auth.RegisterRequest;
//import com.infobyte.quiz.user.Role;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(AuthenticationService service){
//		 return args->{
//			 var admin = RegisterRequest.builder()
//					 .firstName("Admin")
//					 .lastName("Admin")
//					 .email("Admin@mail.com")
//					 .password("password")
//					 .role(Set.of(Role.ADMIN))
//					 .build();
//			 service.register(admin);
//		 };
//	}

}
