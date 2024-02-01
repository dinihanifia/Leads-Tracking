package com.leadtracking.dinihanifia;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Leads Tracking API", version = "1.0", description = "Leads Information"))
public class DiniHanifiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiniHanifiaApplication.class, args);
	}

}
