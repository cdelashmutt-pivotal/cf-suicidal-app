package com.gopivotal.samples.suicidalapp.domain;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public class ISO8601Serializer
	extends JsonSerializer<Date>
{
	
	DateFormat formatter = new ISO8601DateFormat();

	@Override
	public void serialize(Date value, JsonGenerator jgen,
			SerializerProvider provider)
		throws IOException, JsonProcessingException
	{
		jgen.writeString(formatter.format(value));
	}

}
