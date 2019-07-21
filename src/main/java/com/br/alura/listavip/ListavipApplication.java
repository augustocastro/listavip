package com.br.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListavipApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ListavipApplication.class, args);
	}

//	NOTE: A configura��o de conex�o com o banco de dados est� no (application.properties)	
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
//		dataSource.setUsername("root");
//	    dataSource.setPassword("");
//	    return dataSource;
//	}
}
