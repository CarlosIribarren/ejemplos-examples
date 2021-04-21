package oiasso.systems.examples.example;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GranularityEnum {

    HOURLY_EJEMPLO("hourly-example"),
    DAILY_EJEMPLO("daily-example"),
    MONTHLY_EJEMPLO("monthly-example"),
    YEARLY_EJEMPLO("yearly-example");
	
	private String value;
	
    private GranularityEnum(final String value) {
		this.value = value;
	}

    @JsonValue
	@Override
	public String toString() {
		return value;
	}

}
