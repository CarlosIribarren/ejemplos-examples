package oiasso.system.examples.security.dto.converters;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConversorDto<E, D> {

	public abstract E fromDto(D dto);

	public abstract D fromEntity(E entity);

	public List<E> fromDto(Collection<D> dtos){
		if(dtos == null) return null;
		return dtos.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
	}
	
	public List<D> fromEntity(Collection<E> entities){
		if(entities == null) return null;
		return entities.stream().map(entity -> fromEntity(entity)).collect(Collectors.toList());
	}


}