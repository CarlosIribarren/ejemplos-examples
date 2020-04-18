# Ejemplo

## Probar ejemplo
URL de inicio:
- http://localhost:8080/usuarios

# Secuencia
La secuencia se define en la BD:

## En la Base de datos
```sql
CREATE SEQUENCE usuario_sequence
  start 1
  increment 1;     
```

## En la Entity

Y en la Entity de Spring Data se mapea de la siguiente manera:

```java   
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
        @SequenceGenerator(name="usuario_generator", sequenceName = "usuario_sequence",  allocationSize=1)
        @Column(name = "usuario_id")
        private Integer id;
```

# Insert

Al crear el objeto no se asigna el ID.

Se hace el save() del objeto y es entonces cuando se hace el insert y se le asigna segun la secuencia el id.

El objeto que retorna ya tiene el valor del id asignado.

```java        
if(usuarioDao.findAll().isEmpty()) {
        	
        // Crear usuario
        UsuarioEntity admin = new UsuarioEntity();
        admin.setNombre("admin");
        admin.setContraseña("admin");
        UsuarioEntity usuarioBd = usuarioDao.save(admin);    		

}
```