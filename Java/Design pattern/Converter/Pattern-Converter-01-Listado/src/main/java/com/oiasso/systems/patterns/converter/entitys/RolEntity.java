package com.oiasso.systems.patterns.converter.entitys;

public class RolEntity {

    private Integer id;
    private String name;


    public RolEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static RolEntity valueOf(Integer id) {
        if(id == 1){
            return new RolEntity(1,"ROLE_ADMIN");
        }
        return null;
    }
    
}