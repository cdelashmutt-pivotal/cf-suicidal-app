package com.gopivotal.samples.suicidalapp;

import org.springframework.boot.web.SpringBootServletInitializer;

public class WebMain
	extends SpringBootServletInitializer
{

	@Override
	protected Class<?>[] getConfigClasses()
	{
		// TODO Auto-generated method stub
		return new Class[] {App.class};
	}

}
