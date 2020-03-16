package com.oiasso.systems.patterns.converter;

import java.util.List;

import com.oiasso.systems.patterns.converter.dtos.RolDTO;
import com.oiasso.systems.patterns.converter.dtos.UserDTO;
import com.oiasso.systems.patterns.converter.facades.UserFacade;
import com.oiasso.systems.patterns.converter.facades.impl.UserFacadeImpl;


public class Main {

    public static void main(final String[] args) {
        final UserFacade userFacade = new UserFacadeImpl();

        System.out.println("***********************************************************************");
        System.out.println("************************ Probar  Entity -> DTO ************************");
        System.out.println("***********************************************************************");

        final UserDTO userDTO1 = userFacade.findUserByUsername("admin");

        System.out.println("DTO para enviar por REST");
        System.out.println("------------------------");

        System.out.println("Username: " + userDTO1.getUsername());
        final RolDTO role = userDTO1.getRole();
        System.out.println("Role: " + role.getName());

        System.out.println("***********************************************************************");
        System.out.println("************************ Probar DTO -> Entity *************************");
        System.out.println("***********************************************************************");
        // Crear un UserDTO
        final UserDTO userDto = new UserDTO(1, "admin", "admin", new RolDTO("ROLE_ADMIN"));
        
        userFacade.save(userDto);

        System.out.println("***********************************************************************");
        System.out.println("************************ Probar Listado de DTO ************************");
        System.out.println("***********************************************************************");

        List<UserDTO> allUsers = userFacade.findAllUsers();
        for (UserDTO uDto : allUsers) {

            System.out.println("");
            System.out.println("Usuario:");
            System.out.println("--------");

            System.out.println("Username: " + uDto.getUsername());
            final RolDTO uDtoRole = uDto.getRole();
            System.out.println("Role Id: " + uDtoRole.getName());
        }


    }
}