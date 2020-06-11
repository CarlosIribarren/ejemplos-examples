package oiasso.system.examples.security.facades.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import oiasso.system.examples.security.dto.UsuarioDto;
import oiasso.system.examples.security.dto.converters.UsuarioConversorDto;
import oiasso.system.examples.security.entitys.UsuarioEntity;
import oiasso.system.examples.security.facades.UsuarioFacade;
import oiasso.system.examples.security.repositories.UsuarioRepository;

@Transactional
@Component
public class UsuarioFacadeImpl implements UsuarioFacade {

	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	@Autowired
	private UsuarioConversorDto usuarioConversorDto; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;	
	
	@Override
	public UsuarioDto findByNombre(String nombre) {
		UsuarioEntity usuarioEntity = usuarioRepository.findByNombre(nombre);
		return usuarioConversorDto.fromEntity(usuarioEntity);
	}	
	
	@Override
	public Collection<UsuarioDto> findAll() {
		List<UsuarioEntity> usuariosEntity = usuarioRepository.findAll();
		return usuarioConversorDto.fromEntity(usuariosEntity);
	}
	
	@Override
	public UsuarioEntity create(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = usuarioConversorDto.fromDto(usuarioDto);
		usuarioEntity.setContraseña(bCryptPasswordEncoder.encode(usuarioDto.getContraseña()));
		return usuarioRepository.save(usuarioEntity);
	}
	
	@Override
	public UsuarioEntity update(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = usuarioConversorDto.fromDtoUpdate(usuarioDto);
		
		String contraseñaBd = usuarioRepository.findByNombre(usuarioDto.getNombre()).getContraseña();
		usuarioEntity.setContraseña(contraseñaBd);
		
		return usuarioRepository.save(usuarioEntity);
		
	}

	@Override
	public void deleteByNombre(String nombre) {
		usuarioRepository.deleteByNombre(nombre);
	}







}
