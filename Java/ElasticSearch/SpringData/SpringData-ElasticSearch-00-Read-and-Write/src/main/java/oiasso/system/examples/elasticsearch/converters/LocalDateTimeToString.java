package oiasso.system.examples.elasticsearch.converters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

                                             
public class LocalDateTimeToString implements Converter<LocalDateTime, String> {

  @Override
  public String convert(LocalDateTime source) {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	  return source.format(formatter);
  }
}
