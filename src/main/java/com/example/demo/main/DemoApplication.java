package com.example.demo.main;

import com.example.demo.classes.unit3.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {

		/*
		- Spring Boot Application 실행과정과 설정된 Bean 확인하는 구문

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		Environment env = ctx.getBean(Environment.class);
		String portValue = env.getProperty("server.port");
		log.info("Customized port : " + portValue);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(name -> log.info("Bean Name : " + name));
		*/

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		PriceUnit defaultPriceUnit = ctx.getBean("priceUnit", PriceUnit.class);
		log.info("Price #1 : {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

		PriceUnit wonPriceUnit = ctx.getBean("wonPriceUnit", PriceUnit.class);
		log.info("Price #2 : {}", wonPriceUnit.format(BigDecimal.valueOf(1000)));
	}

}
