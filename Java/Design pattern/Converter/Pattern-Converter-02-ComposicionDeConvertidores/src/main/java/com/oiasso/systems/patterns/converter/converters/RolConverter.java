package com.oiasso.systems.patterns.converter.converters;

import com.oiasso.systems.patterns.converter.abstracts.AbstractConverter;
import com.oiasso.systems.patterns.converter.dtos.RolDTO;
import com.oiasso.systems.patterns.converter.entitys.RolEntity;
import com.oiasso.systems.patterns.converter.facades.RolFacade;
import com.oiasso.systems.patterns.converter.facades.impl.RolFacadeImpl;

/**
 * En este convertir de Rol se hace lo siguiente:
 * El Entity de rol de BD tiene id.
 * El DTO de rol no tiene id.
 * Por lo que cuando se quiere enviar el Rol como DTO hacia fuera, se le quita el id.
 */
public class RolConverter extends AbstractConverter<RolEntity, RolDTO> {

    private RolFacade rolFacade = new RolFacadeImpl();

    @Override
    public RolEntity fromDto(RolDTO dto) {

        RolEntity rolEntity = new RolEntity();
        rolEntity.setName(dto.getName());

        // Se obtiene el id de la BD
        Integer id = rolFacade.findRolByName(dto.getName()).getId();
        rolEntity.setId(id);

        return rolEntity;
    }

    @Override
    public RolDTO fromEntity(RolEntity entity) {
        return new RolDTO(entity.getName());
    }

    
}