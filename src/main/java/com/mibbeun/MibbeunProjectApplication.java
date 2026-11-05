package com.mibbeun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.apache.ibatis.annotations.Mapper;          // ✅ MyBatis의 @Mapper
import org.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.mibbeun", annotationClass = Mapper.class)
public class MibbeunProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MibbeunProjectApplication.class, args);
	}

}
