package com.gopivotal.samples.suicidalapp;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class App
{

	DateFormat formatter = DateFormat.getDateTimeInstance();

	@RequestMapping("/")
	public AppStatus home()
	{
		return new AppStatus("alive", new Date());
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

	public class AppStatus
	{
		private String status;
		private Date time;

		public AppStatus(String status, Date time)
		{
			super();
			this.status = status;
			this.time = time;
		}

		public AppStatus()
		{
			super();
			// TODO Auto-generated constructor stub
		}

		public String getStatus()
		{
			return status;
		}

		public void setStatus(String status)
		{
			this.status = status;
		}

		public Date getTime()
		{
			return time;
		}

		public void setTime(Date time)
		{
			this.time = time;
		}
	}
}
