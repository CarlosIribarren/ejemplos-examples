package oiasso.system.examples.elasticsearch.converters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter                                                 
public class StringToLocalDateTime implements Converter<String, LocalDateTime> {

  @Override
  public LocalDateTime convert(String source) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      return LocalDateTime.parse(source, formatter);
  }
}
