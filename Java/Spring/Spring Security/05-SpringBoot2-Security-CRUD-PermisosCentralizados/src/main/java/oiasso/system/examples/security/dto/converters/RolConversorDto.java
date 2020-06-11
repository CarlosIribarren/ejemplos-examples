package oiasso.system.examples.security.dto.converters;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import oiasso.system.examples.security.dto.RolDto;
import oiasso.system.examples.security.entitys.PrivilegioEntity;
import oiasso.system.examples.security.entitys.RolEntity;
import oiasso.system.examples.security.repositories.PrivilegioRepository;


@Component
public class RolConversorDto extends AbstractConversorDto<RolEntity, RolDto > {

	@Autowired
	private PrivilegioRepository privilegioRepository; 

	@Override
	public RolEntity fromDto(RolDto dto) {

		RolEntity rolEntity = new RolEntity();
		
		// Nombre
		rolEntity.setNombre(dto.getNombre());

		// Privilegios
		Collection<PrivilegioEntity> privilegiosEntity = new ArrayList<>();
		Collection<String> privilegios = dto.getPrivilegios();
		if(privilegios != null) {
			for (String privilegio : privilegios) {
				PrivilegioEntity privilegioEntity = privilegioRepository.findByNombre(privilegio);
				privilegiosEntity.add(privilegioEntity);
			}
		}
		rolEntity.setPrivilegios(privilegiosEntity);
		
		return rolEntity;
	}

	@Override
	public RolDto fromEntity(RolEntity entity) {
		
		RolDto rolDto = new RolDto();
		
		
		// Nombre
		rolDto.setNombre(entity.getNombre());
		
		// Privilegios
		Collection<String> privilegios = new ArrayList<>();
		Collection<PrivilegioEntity> privilegiosEntity = entity.getPrivilegios();
		for (PrivilegioEntity privilegioEntity : privilegiosEntity) {
			privilegios.add(privilegioEntity.getNombre());
		}
		rolDto.setPrivilegios(privilegios);
		
		return rolDto;
	}
	
	

}
