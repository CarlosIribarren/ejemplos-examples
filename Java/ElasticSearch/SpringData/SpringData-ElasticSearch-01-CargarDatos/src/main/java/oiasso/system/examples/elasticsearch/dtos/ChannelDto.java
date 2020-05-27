package oiasso.system.examples.elasticsearch.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ChannelDto {

    private String uuid;
    
    private String device;
    
    private String spot;
    
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime start;
    
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime end;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getSpot() {
		return spot;
	}

	public void setSpot(String spot) {
		this.spot = spot;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}







    
    
}
