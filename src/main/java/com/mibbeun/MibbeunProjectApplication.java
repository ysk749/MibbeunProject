package com.mibbeun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class MibbeunProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MibbeunProjectApplication.class, args);
	}

}
