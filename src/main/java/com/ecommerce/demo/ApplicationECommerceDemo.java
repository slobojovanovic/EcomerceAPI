package com.ecommerce.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import com.ecommerce.demo.service.ConsumerService;


@SpringBootApplication
@EnableScheduling
public class ApplicationECommerceDemo{
	
	@Autowired
	ConsumerService consumerService;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationECommerceDemo.class, args);
		System.out.println("### Start Spring Boot ###");
	}
	
	
	@Scheduled(cron = "0 */15 * ? * *")
	public void runEvey15Minutes() {
	/* Preuzimanje podataka sa stores API provajdera */
		System.out.println("Preuzimanje podataka sa stores API provajdera : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS")));
		//List<Store> listStore = 
		consumerService.saveStores();
		
	/* Preuzimanje podataka sa products API provajdera */
		System.out.println("Preuzimanje podataka sa products API provajdera : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS")));
		//List<Product> listProduct = 
		consumerService.saveProducts();
	}
	
	 @Bean
     public ModelMapper modelMapper() {
         return new ModelMapper();
     }
	 

}
