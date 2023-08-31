package com.example.servingwebcontent;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServingWebContentApplication {
	    @GetMapping("/user")
    public Map<String, String> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", "yo");
    }

	public static void main(String[] args) {
		SpringApplication.run(ServingWebContentApplication.class, args);
	}
	@Configuration
public class SecurityConfig {


}

}
