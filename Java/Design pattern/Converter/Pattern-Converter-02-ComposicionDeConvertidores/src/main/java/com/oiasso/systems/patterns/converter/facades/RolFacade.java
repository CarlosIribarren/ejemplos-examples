package com.oiasso.systems.patterns.converter.facades;

import com.oiasso.systems.patterns.converter.entitys.RolEntity;

/**
 * RolFacade
 */
public interface RolFacade {

    
    RolEntity findRolByName(String name);

}