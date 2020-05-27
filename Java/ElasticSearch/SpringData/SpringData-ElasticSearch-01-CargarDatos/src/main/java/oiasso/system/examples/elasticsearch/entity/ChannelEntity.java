package oiasso.system.examples.elasticsearch.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "test", type = "test")
public class ChannelEntity {

	@Id
    private String uuid;
    
    private String dev;
    
    private String spot_name;
    
    private LocalDateTime date_start;
    
    private LocalDateTime date_end;

    private Long duration;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDev() {
		return dev;
	}

	public void setDev(String dev) {
		this.dev = dev;
	}

	public String getSpot_name() {
		return spot_name;
	}

	public void setSpot_name(String spot_name) {
		this.spot_name = spot_name;
	}

	public LocalDateTime getDate_start() {
		return date_start;
	}

	public void setDate_start(LocalDateTime date_start) {
		this.date_start = date_start;
	}

	public LocalDateTime getDate_end() {
		return date_end;
	}

	public void setDate_end(LocalDateTime date_end) {
		this.date_end = date_end;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}


}
