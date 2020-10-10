package config;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;

public class StringtoDateConverter implements Converter<String, Date>{
	private static final DateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Date convert(String s) {
		try {
			return (Date) DATE_TIME_FORMATTER.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
