package com.dxctraining.inventorymgt.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @SpringBootapplication equivalent to 3 things
 * 1)@Configuration 
 * 2)@ComponentScan 
 * 3) @AutoConfiguration 
 */
@SpringBootConfiguration
public class ProjectMain {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMain.class, args);

	}


}