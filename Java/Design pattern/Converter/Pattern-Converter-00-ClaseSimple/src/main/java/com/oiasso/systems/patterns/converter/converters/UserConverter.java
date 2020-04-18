package com.oiasso.systems.patterns.converter.converters;

import java.util.stream.Collectors;

import com.oiasso.systems.patterns.converter.abstracts.AbstractConverter;
import com.oiasso.systems.patterns.converter.dtos.UserDTO;
import com.oiasso.systems.patterns.converter.entitys.RolEntity;
import com.oiasso.systems.patterns.converter.entitys.UserEntity;

public class UserConverter extends AbstractConverter<UserEntity, UserDTO> {

	@Override
	public UserEntity fromDto(UserDTO dto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(dto.getId());
		userEntity.setUsername(dto.getUsername());
		userEntity.setPassword(dto.getPassword());
		
		// El DTO tiene los roles representados con numeros

		// Prevent NullPointerException
		if(dto.getRoles()!=null) {
			// Se recorrre los id de Rol y se crea una lista de objetos de RolEntity
			userEntity.setRoles(dto.getRoles().stream().map(rol -> RolEntity.valueOf(rol))
									.collect(Collectors.toList())
								);
		}
		return userEntity;
	}

	@Override
	public UserDTO fromEntity(UserEntity entity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(entity.getId());
		userDTO.setUsername(entity.getUsername());
		userDTO.setPassword(entity.getPassword());
		
		// Prevent NullPointerException
		if(entity.getRoles()!=null) {
			// Se recorre los Roles y se crea una lista con el Id de los roles
			userDTO.setRoles(entity.getRoles().stream().map(rol -> rol.getId())
								.collect(Collectors.toList())
							);
		}
		return userDTO;
	}
}
