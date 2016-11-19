package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class JsonStringDateSerializer extends JsonSerializer<String> {
	private final static Logger logger = Logger.getLogger(JsonStringDateSerializer.class);

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		try {
			Date date = dateFormat.parse(value);
			String formattedDate = dateFormat.format(date);
			jgen.writeString(formattedDate);
		} catch (ParseException e) {
			logger.error(e);
		}
	}

}
