/**
 * Copyright GoPivotal, Inc.
 */
package com.gopivotal.samples.suicidalapp.domain;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A small domain object to show app environment info.
 * @author cdelashmutt
 *
 */
public class EnvironmentInfo
{
	Map<String, String> env = new HashMap<String, String>();
	Map<String,Object> vcapApplication = Collections.emptyMap();
	Date time = new Date();
	
	@SuppressWarnings("unchecked")
	public EnvironmentInfo(Map<String,String> env)
	{
		this.env = env;
		String vcapApplicationString = env.get("VCAP_APPLICATION");
		if(vcapApplicationString != null && !vcapApplicationString.isEmpty())
		{
			ObjectMapper mapper = new ObjectMapper();
			try
			{
				vcapApplication = (Map<String,Object>)mapper.readValue(vcapApplicationString, Map.class);
			}
			catch (Exception e)
			{
				//Just ignore for now
			}
		}
	}
	
	public Integer getInstanceIndex()
	{
		return (Integer)vcapApplication.get("instance_index");
	}
	
	public String getHost()
	{
		return (String)vcapApplication.get("host");
	}
	
	public Integer getPort()
	{
		return (Integer)vcapApplication.get("port");
	}
	
	@JsonSerialize(using=ISO8601Serializer.class)
	public Date getTime()
	{
		return time;
	}
	
	@JsonSerialize(contentUsing=UnescapedStringSerializer.class)
	public Map<String, String> getEnv()
	{
		return env;
	}
}
