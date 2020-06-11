package oiasso.system.examples.jpa.datatables.back.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * ******************************************************************************
 * Conversor: java.sql.Date <<==>> java.time.LocalDate
 * ******************************************************************************
 * 
 * AttributeConverter es una Interface de javax.persistence que sirve para
 * realizar conversiones entre atributos de Java y de BD.
 * 
 * Se define un conversor de atributos. Se convierten los tipo de datos
 * java.sql.Date y java.time.LocalDate. En la Base de datos se guardan los datos
 * de tipo java.sql.Date. En Java se utiliza el tipo java.time.LocalDate. Con
 * este Converter se realiza la conversion en ambos sentidos.
 * 
 * 
 * Si no se define el Conversor da un error (org.postgresql.util.PSQLException:
 * ERROR: el operador no existe: date >= bytea)
 */

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate locDate) {
		return locDate == null ? null : Date.valueOf(locDate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate) {
		return sqlDate == null ? null : sqlDate.toLocalDate();
	}
}
