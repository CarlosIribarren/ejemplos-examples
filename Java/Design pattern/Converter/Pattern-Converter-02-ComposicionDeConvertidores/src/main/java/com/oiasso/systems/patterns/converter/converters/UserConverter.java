package com.oiasso.systems.patterns.converter.converters;

import com.oiasso.systems.patterns.converter.abstracts.AbstractConverter;
import com.oiasso.systems.patterns.converter.daos.UserDao;
import com.oiasso.systems.patterns.converter.daos.impl.UserDaoImpl;
import com.oiasso.systems.patterns.converter.dtos.UserDTO;
import com.oiasso.systems.patterns.converter.entitys.UserEntity;

public class UserConverter extends AbstractConverter<UserEntity, UserDTO> {

	private final UserDao userDao = new UserDaoImpl();

	private final RolConverter rolConverter = new RolConverter();

	@Override
	public UserEntity fromDto(UserDTO dto) {

		// Obtener de BD el usuario
		UserEntity userEntityBD = userDao.findUserByUsername(dto.getUsername());

		UserEntity userEntity = new UserEntity();
		userEntity.setId(userEntityBD.getId());
		userEntity.setUsername(dto.getUsername());
		userEntity.setPassword(userEntityBD.getPassword());

		// Utilizar el converter de Rol para convertir
		userEntity.setRole(rolConverter.fromDto(dto.getRole()));
		
		return userEntity;
	}

	@Override
	public UserDTO fromEntity(UserEntity entity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(entity.getUsername());
		
		// Utilizar el converter de Rol para convertir
		userDTO.setRole(rolConverter.fromEntity(entity.getRole()));

		return userDTO;
	}
}
