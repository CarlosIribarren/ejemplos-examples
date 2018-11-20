package oiasso.pattern.builders;

import oiasso.pattern.beans.Persona;

public class PersonaBuilder {

    private String email;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    
    public PersonaBuilder() {
    }

    public PersonaBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PersonaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PersonaBuilder apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }
    
    public PersonaBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public PersonaBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Persona build() {
    	Persona p = new Persona();
    	p.setApellidos(apellidos);
    	p.setDireccion(direccion);
    	p.setEmail(email);
    	p.setNombre(nombre);
    	p.setTelefono(telefono);
        return p;
    }
	
}
