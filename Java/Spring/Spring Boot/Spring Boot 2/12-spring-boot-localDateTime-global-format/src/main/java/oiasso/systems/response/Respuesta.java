package oiasso.systems.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Respuesta<T> {

	private T data;
	
	@JsonProperty("status_code")
	private int statusCode;
	
	@JsonProperty("status_message")
	private Object statusMessage;

	private LocalDateTime timestamp;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(Object statusMessage) {
		this.statusMessage = statusMessage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
	
}