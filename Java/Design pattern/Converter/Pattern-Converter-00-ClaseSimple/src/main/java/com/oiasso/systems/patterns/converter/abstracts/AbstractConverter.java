package com.oiasso.systems.patterns.converter.abstracts;

public abstract class AbstractConverter<E,D> {

	public abstract E fromDto(D dto);

	public abstract D fromEntity(E entity);
	
}
