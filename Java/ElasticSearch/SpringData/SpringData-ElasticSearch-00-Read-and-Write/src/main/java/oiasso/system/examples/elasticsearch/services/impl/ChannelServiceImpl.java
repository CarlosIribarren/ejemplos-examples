package oiasso.system.examples.elasticsearch.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.system.examples.elasticsearch.dtos.ChannelDto;
import oiasso.system.examples.elasticsearch.entity.ChannelEntity;
import oiasso.system.examples.elasticsearch.repository.ChannelRepository;
import oiasso.system.examples.elasticsearch.services.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelRepository channelRepository; 
	
	@Override
	public List<ChannelDto> findAll() {
		
		List<ChannelDto> resultado = new ArrayList<>();
		
		Iterable<ChannelEntity> channels = channelRepository.findAll();
		
		for (ChannelEntity channelEntity : channels) {
			ChannelDto channelDto = new ChannelDto();
			channelDto.setId(channelEntity.getId());
			channelDto.setChannelId(channelEntity.getChannelId());
			channelDto.setDeviceId(channelEntity.getDeviceId());
			channelDto.setStart(channelEntity.getStart());
			channelDto.setEnd(channelEntity.getEnd());
			resultado.add(channelDto);
		}
		
		return resultado;
	}

	@Override
	public void save(ChannelDto channelDto) {
		ChannelEntity channelEntity = new ChannelEntity();
		channelEntity.setId(channelDto.getId());
		channelEntity.setChannelId(channelDto.getChannelId());
		channelEntity.setDeviceId(channelDto.getDeviceId());
		channelEntity.setStart(channelDto.getStart());
		channelEntity.setEnd(channelDto.getEnd());
		channelRepository.save(channelEntity);
	}

	@Override
	public void save(List<ChannelDto> channelDtoList) {
		for (ChannelDto channelDto : channelDtoList) {
			this.save(channelDto);
		}
	}

}
