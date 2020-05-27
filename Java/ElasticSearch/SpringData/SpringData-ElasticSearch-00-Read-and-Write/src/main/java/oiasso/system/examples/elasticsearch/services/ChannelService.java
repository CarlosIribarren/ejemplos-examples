package oiasso.system.examples.elasticsearch.services;

import java.util.List;

import oiasso.system.examples.elasticsearch.dtos.ChannelDto;

public interface ChannelService {

	List<ChannelDto> findAll();
	
	void save(ChannelDto channelDto);
	
	void save(List<ChannelDto> channelDtoList);
	
}
