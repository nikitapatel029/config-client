package com.spring.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@SpringBootApplication
@RestController
public class ConfigClientApplication {
	
	@Value("${appEnvName:Config Server is not working. Please check...}")
	private String name;
	
	@Value("${name: Server is not working. Please check...}")
	private String defaultName;
	
	@Value("${configClientName: Server is not working. Please check...}")
	private String configClientName;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

		
	@GetMapping("/check/property")
	public String getName() {
		return "Hello Viewers, <br/><br/> You are using Application <b>- " + this.name + " </b><br/><br/> default config-client application properties which is stored at config-client root level is - <b>"+ this.configClientName +"</b><br/><br/> default application properties which is stored at root level is - <b>"+ this.defaultName;
	}
}
