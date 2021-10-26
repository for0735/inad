package com.inad.mgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@SpringBootApplication
public class InadProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(InadProjApplication.class, args);
	}
	

    @Bean
    MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }

}
