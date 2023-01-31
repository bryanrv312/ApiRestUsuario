package com.bryancompany.apirest.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryancompany.apirest.models.UsuarioModel;
import com.bryancompany.apirest.repositories.UsuarioRepository;



@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository urepo;
	
	public List<UsuarioModel> obtenerUsuarios(){
		return (List<UsuarioModel>) urepo.findAll();
	}
	
	
	public UsuarioModel guardarUsuario(UsuarioModel usu) {
		return urepo.save(usu);
	}
	
	
	public Optional<UsuarioModel> obtenerPorId(Long id){
		return urepo.findById(id);
	}
	
	
	public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
		return urepo.findByPrioridad(prioridad);
	}
	
	
	public boolean eliminarsuario(Long id) {
		try {
			urepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public UsuarioModel actualizarUsuario(UsuarioModel usu) {
		return urepo.save(usu);
	}
	
	
	

}
