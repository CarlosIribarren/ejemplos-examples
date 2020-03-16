package com.oiasso.systems.patterns.converter.facades.impl;

import com.oiasso.systems.patterns.converter.entitys.RolEntity;
import com.oiasso.systems.patterns.converter.facades.RolFacade;

/**
 * RolFacadeImpl
 */
public class RolFacadeImpl implements RolFacade {

    @Override
    public RolEntity findRolByName(String name) {
        switch (name) {
            case "ROLE_ADMIN":
                return new RolEntity(1, "admin");
            case "ROLE_OPERATOR":
                return new RolEntity(2, "operator");
            default:
                return null;
        }
        
    }

    
}