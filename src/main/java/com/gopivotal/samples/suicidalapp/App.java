package com.gopivotal.samples.suicidalapp;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class App
{

	DateFormat formatter = DateFormat.getDateTimeInstance();

	@RequestMapping("/")
	public String home(ServletRequest request)
	{
		return String.format("<html><body><h1>Alive on %s at port %s at %s</h1></body></html>", request.getLocalAddr(), request.getLocalPort(), formatter.format(new Date()));
	}

	@RequestMapping("/die")
	public void die()
	{
		System.exit(-1);
	}

	public static void main(String[] args)
		throws Exception
	{
		SpringApplication.run(App.class, args);
	}
}
