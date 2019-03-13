package com.company.memberapp;

import com.company.memberapp.entity.ApiKeyHandlerArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

@SpringBootApplication
public class MemberAppApplication implements WebFluxConfigurer {


	@Override
	public void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
		configurer.addCustomResolver(new ApiKeyHandlerArgumentResolver());
	}

	public static void main(String[] args) {
		SpringApplication.run(MemberAppApplication.class, args);
	}

}
