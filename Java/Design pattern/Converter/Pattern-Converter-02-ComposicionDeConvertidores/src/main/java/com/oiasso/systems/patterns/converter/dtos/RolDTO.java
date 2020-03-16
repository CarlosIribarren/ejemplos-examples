package com.oiasso.systems.patterns.converter.dtos;

/**
 * RolDTO
 * 
 * El RolDTO solo contiene el nombre del rol, se ha eliminado el id que si tiene la entity.
 */
public class RolDTO {

    private String name;


    public RolDTO(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}