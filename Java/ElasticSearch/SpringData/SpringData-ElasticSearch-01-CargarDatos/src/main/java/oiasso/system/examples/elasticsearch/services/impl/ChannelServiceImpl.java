package oiasso.system.examples.elasticsearch.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
			channelDto.setUuid(channelEntity.getUuid());
			channelDto.setSpot(channelEntity.getSpot_name());
			channelDto.setDevice(channelEntity.getDev());
			channelDto.setStart(channelEntity.getDate_start());
			channelDto.setEnd(channelEntity.getDate_end());
			resultado.add(channelDto);
		}
		
		return resultado;
	}

	@Override
	public void save(ChannelDto channelDto) {
		ChannelEntity channelEntity = new ChannelEntity();
		channelEntity.setUuid(channelDto.getUuid());
		channelEntity.setSpot_name(channelDto.getSpot());
		channelEntity.setDev(channelDto.getDevice());
		channelEntity.setDate_start(channelDto.getStart());
		channelEntity.setDate_end(channelDto.getEnd());
		channelRepository.save(channelEntity);
	}

	@Override
	public void save(List<ChannelDto> channelDtoList) {
		for (ChannelDto channelDto : channelDtoList) {
			this.save(channelDto);
		}
	}

	@Override
	public void cargarDatos() {

		List<ChannelEntity> datos = new ArrayList<>();
		
		LocalDateTime now = LocalDateTime.of(2020, 4, 1, 0, 0);
		
		LocalDateTime nowNike = LocalDateTime.of(2025, 4, 1, 0, 0);
		
		
//		// 3 meses
//		for (int m = 1; m <4; m=m+1) {
//			now = now.withMonth(m);

				// un dia
				now = now.withDayOfMonth(1);
				for (int h = 0; h <23; h=h+1) {
					now = now.withHour(h);
					for (int i = 0; i <56; i=i+2) {
						ChannelEntity channelEntity = new ChannelEntity();
						channelEntity.setUuid(UUID.randomUUID().toString());
						channelEntity.setSpot_name("Coca Cola");
						channelEntity.setDev("ctsdem01");
						channelEntity.setDate_start(now.withMinute(i));
						channelEntity.setDate_end(now.withMinute(i+2));
						channelEntity.setDuration(Long.valueOf(2));
						datos.add(channelEntity);
						
						ChannelEntity channelEntity2 = new ChannelEntity();
						channelEntity2.setUuid(UUID.randomUUID().toString());
						channelEntity2.setSpot_name("Coca Cola");
						channelEntity2.setDev("ctsdem02");
						channelEntity2.setDate_start(now.withMinute(i));
						channelEntity2.setDate_end(now.withMinute(i+2));
						channelEntity2.setDuration(4l);
						datos.add(channelEntity2);		
						
						ChannelEntity channelEntity3 = new ChannelEntity();
						channelEntity3.setUuid(UUID.randomUUID().toString());
						channelEntity3.setSpot_name("Coca Cola");
						channelEntity3.setDev("ctsdem03");
						channelEntity3.setDate_start(now.withMinute(i));
						channelEntity3.setDate_end(now.withMinute(i+2));
						channelEntity3.setDuration(Long.valueOf(10));
						datos.add(channelEntity3);							
						
						ChannelEntity channelEntity4 = new ChannelEntity();
						channelEntity4.setUuid(UUID.randomUUID().toString());
						channelEntity4.setSpot_name("Nike");
						channelEntity4.setDev("ctsdem04");
						channelEntity4.setDate_start(nowNike.withMinute(i));
						channelEntity4.setDate_end(nowNike.withMinute(i+2));
						channelEntity4.setDuration(Long.valueOf(5));
						datos.add(channelEntity4);						
						
					}
				}
			
//		}
		

		
		channelRepository.saveAll(datos);
	}

}
