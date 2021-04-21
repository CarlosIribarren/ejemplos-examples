package oiasso.systems.examples.factory;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {
 
    private static class StringToEnumConverter<T extends Enum> implements Converter<String, T> {
 
        private final Class<T> enumType;
 
        public StringToEnumConverter(final Class<T> enumType) {
            this.enumType = enumType;
        }
 
        @Override
		public T convert(final String source) {
        	
            if (null == source) {
                return null;
            }
        	
        	for (final T a : enumType.getEnumConstants()) {
				if(a.toString().equalsIgnoreCase(source)) {
					return a;
				}
			}

            throw new IllegalArgumentException("Unknown value for enum : " + enumType.getName() + ". Unknown value is : " + source);
        }
    }
 
    @Override
    public <T extends Enum> Converter<String, T> getConverter(final Class<T> targetType) {
        return new StringToEnumConverter(targetType);
    }
}