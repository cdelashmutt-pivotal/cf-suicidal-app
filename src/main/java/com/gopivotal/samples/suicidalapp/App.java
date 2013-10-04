package com.gopivotal.samples.suicidalapp;

import java.text.SimpleDateFormat;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gopivotal.samples.suicidalapp.domain.EnvironmentInfo;

@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
@RequestMapping("/service")
public class App
{
	
	Logger logger = LoggerFactory.getLogger(App.class);

	@RequestMapping
	public EnvironmentInfo home(ServletRequest request)
	{
		return new EnvironmentInfo(System.getenv());
	}

	@RequestMapping("/die")
	public void die()
	{
		logger.error("This world does not compute!  I'm ending it all now!!");
		System.exit(-1);
	}

	@Bean
	public ObjectMapper getMapper()
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'hh-mm-ss.SSSZ"));
		return mapper;
	}
	
	public static void main(String[] args)
		throws Exception
	{
		SpringApplication.run(App.class, args);
	}
}
