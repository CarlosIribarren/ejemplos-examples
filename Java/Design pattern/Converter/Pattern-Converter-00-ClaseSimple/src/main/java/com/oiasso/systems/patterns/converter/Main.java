package com.oiasso.systems.patterns.converter;

import java.util.ArrayList;
import java.util.List;

import com.oiasso.systems.patterns.converter.dtos.UserDTO;
import com.oiasso.systems.patterns.converter.facades.UserFacade;
import com.oiasso.systems.patterns.converter.facades.impl.UserFacadeImpl;

/**
 * Main
 */
public class Main {

    public static void main(final String[] args) {
        final UserFacade userFacade = new UserFacadeImpl();

        System.out.println("***********************************************************************");
        System.out.println("************************ Probar  Entity -> DTO ************************");
        System.out.println("***********************************************************************");

        final UserDTO userDTO1 = userFacade.findUserByUsername("admin");

        System.out.println("DTO para enviar por REST");
        System.out.println("------------------------");

        System.out.println("User Id: " + userDTO1.getId());
        System.out.println("Username: " + userDTO1.getUsername());
        System.out.println("Password: " + userDTO1.getPassword());
        final List<Integer> roles = userDTO1.getRoles();
        for (final Integer rol : roles) {
            System.out.println("Role Id: " + rol);
        }

        System.out.println("***********************************************************************");
        System.out.println("************************ Probar DTO -> Entity *************************");
        System.out.println("***********************************************************************");

        // Crear un UserDTO
        final List<Integer> rolesString = new ArrayList<>();
        rolesString.add(1);
        final UserDTO userDto = new UserDTO(1, "admin", "admin", rolesString);
        
        userFacade.save(userDto);
    }
}