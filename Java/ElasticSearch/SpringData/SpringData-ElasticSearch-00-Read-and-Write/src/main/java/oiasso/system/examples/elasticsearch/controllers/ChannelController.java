package oiasso.system.examples.elasticsearch.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oiasso.system.examples.elasticsearch.dtos.ChannelDto;
import oiasso.system.examples.elasticsearch.services.ChannelService;

@RestController
@RequestMapping("/api/channels/")
public class ChannelController {

	@Autowired
	private ChannelService channelService; 
	
	@GetMapping()
	public List<ChannelDto> findAll() {
		return channelService.findAll();
	}
	
	@PostMapping()
	public void save(@RequestBody ChannelDto channelDto) {
		channelService.save(channelDto);
	}
	
	@PostMapping("all")
	public void saveAll(@RequestBody List<ChannelDto> channelDtoList) {
		channelService.save(channelDtoList);
	}
	
}


