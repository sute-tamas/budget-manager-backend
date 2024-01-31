package com.tomiapps.budgetmanager;

import com.tomiapps.budgetmanager.configuration.RsaKeyConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfigProperties.class)
public class BudgetmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetmanagerApplication.class, args);
	}

}
