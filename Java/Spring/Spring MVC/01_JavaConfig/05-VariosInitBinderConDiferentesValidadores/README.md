# Ejemplo
En este ejemplo se muestra como registrar diferentes validadores en dos metodos de InitBinder.

## Probar ejemplo
Entrar en la URL: http://localhost:8080/
- Usuario: admin
- Password: admin

# Configuracion 
Se han configurado dos metodos @InitBinder, cada uno de ellos se elnza con un @ModelAttribute diferente

```java
@InitBinder(value = "usuarioNuevo")
public void initBinderUsuarioNuevo(HttpServletRequest request, WebDataBinder dataBinder) {
dataBinder.addValidators(new UsuarioNuevoValidator(usuarioFacade));
}

@InitBinder("usuarioModificar")
public void initBinderUsuarioModificado(HttpServletRequest request, WebDataBinder dataBinder) {
dataBinder.addValidators(new UsuarioModificadoValidator());
}
```
Se elanzan con el nombre del @ModelAttribute

```java
@PostMapping("/new")
public String nuevoGuardar( @ModelAttribute("usuarioNuevo") @Validated UsuarioDto usuarioNuevo, BindingResult bindingResult, Model modelo) {
	...
}

@PostMapping("/{nombre}")
public String editarGuardar(@ModelAttribute("usuarioModificar") @Validated UsuarioDto usuarioModificado, BindingResult bindingResult, Model modelo) {
	...
}
```

y el nombre de los @ModelAttribute tienen que estar definidos en las plantillas:

- Plantilla nuevoUsuario.html:
```html
<form action="#" th:action="@{${#httpServletRequest.requestURI}}" th:object="${usuarioNuevo}" method="post">
```

- Plantilla editarUsuario.html:
```html
<form action="#" th:action="@{${#httpServletRequest.requestURI}}" th:object="${usuarioModificar}" method="post">
```

