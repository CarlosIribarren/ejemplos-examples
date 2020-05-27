package oiasso.system.examples.elasticsearch.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ChannelDto {

    private Long id;
    
    private String deviceId;
    
    private String channelId;
    
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime start;
    
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime end;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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
