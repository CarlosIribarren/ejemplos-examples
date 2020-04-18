package oiasso.system.examples.formatter.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import oiasso.system.examples.formatter.dto.RolDto;

public class RolDtoFormatter implements Formatter<RolDto> {

	@Override
	public String print(RolDto object, Locale locale) {
		return object.getNombre();
	}

	@Override
	public RolDto parse(String text, Locale locale) throws ParseException {
		RolDto rolDto = new RolDto();
		rolDto.setNombre(text);
		return rolDto;
	}

}
