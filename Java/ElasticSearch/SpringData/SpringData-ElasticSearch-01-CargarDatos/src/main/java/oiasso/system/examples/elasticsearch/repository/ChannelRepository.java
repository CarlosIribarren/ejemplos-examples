package oiasso.system.examples.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import oiasso.system.examples.elasticsearch.entity.ChannelEntity;

@Repository
public interface ChannelRepository extends ElasticsearchRepository<ChannelEntity, String> {

}
