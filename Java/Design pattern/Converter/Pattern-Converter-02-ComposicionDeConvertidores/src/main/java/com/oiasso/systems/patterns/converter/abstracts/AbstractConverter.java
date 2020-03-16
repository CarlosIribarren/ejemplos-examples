package com.oiasso.systems.patterns.converter.abstracts;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {

	public abstract E fromDto(D dto);

	public abstract D fromEntity(E entity);
	
// Se han agregado dos nuevos métodos, fromDto y fromEntity los cuales se encargan de convertir las listas 
// aprovechando los método abstractos previamente definidos, de esta forma, en cuanto creemos una implementación de AbstractConverter 
// tendremos de forma automática los método para convertir listas.

// Se recorre cada una de las listas, para cada objeto se llama al metodo from correspondiente y se retorna la nueva lista.

	public List<E> fromDto(List<D> dtos){
		if(dtos == null) return null;
		return dtos.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
	}
	
	public List<D> fromEntity(List<E> entities){
		if(entities == null) return null;
		return entities.stream().map(entity -> fromEntity(entity)).collect(Collectors.toList());
	}

}
