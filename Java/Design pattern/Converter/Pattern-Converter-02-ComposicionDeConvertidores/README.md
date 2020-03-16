# Composicion de convertidores
En este ejemplo, se muestran como utilizar composicion de converters en objetos y listas.

## Uso
El UserConverter utiliza el RolConverter

	@Override
	public UserEntity fromDto(UserDTO dto) {

        ...

		// Utilizar el converter de Rol para convertir
		userEntity.setRole(rolConverter.fromDto(dto.getRole()));
		
		return userEntity;
	}

	@Override
	public UserDTO fromEntity(UserEntity entity) {

        ...
		
		// Utilizar el converter de Rol para convertir
		userDTO.setRole(rolConverter.fromEntity(entity.getRole()));

		return userDTO;
	}


## DTOs

- UserDTO:Se ha eliminado del Entity de UserEntity el id y el password.
- RolDTO: Se ha eliminado del Entity de RolEntity el id.

## Conversiones

- Cuando se tiene que hacer una transformacion de Entity a DTO, es facil ya que solo hay que eliminar informacion como el id y el password.
- Cuando se tiene que hacer una transformacion de DTO a Entity, en el conversor se utilizan los DAOs para rellenar la informacion que falta, como ids y password.



