package com.gopivotal.samples.suicidalapp.domain;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UnescapedStringSerializer
	extends JsonSerializer<String>
{

	@Override
	public void serialize(String value, JsonGenerator jgen,
			SerializerProvider provider)
		throws IOException, JsonProcessingException
	{
		if(value.startsWith("{") || value.startsWith("["))
		{
			jgen.writeRawValue(value);
		}
		else {
			jgen.writeString(value);
		}
	}

	@Override
	public Class<String> handledType()
	{
		return String.class;
	}
}
