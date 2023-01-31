package com.bryancompany.apirest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bryancompany.apirest.models.UsuarioModel;
import com.bryancompany.apirest.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	UsuarioService userv;
	
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return (ArrayList<UsuarioModel>) userv.obtenerUsuarios();
	}
	
	
	@PostMapping("/guardar")
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usu) {
		return userv.guardarUsuario(usu);
	}
	
	@GetMapping(path ="/{id}")
	public Optional <UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.userv.obtenerPorId(id);
	}
	
	@GetMapping(path = "/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.userv.obtenerPorPrioridad(prioridad);
	} 
	
	@DeleteMapping("/{id}")
	public String eliminarPorId(@PathVariable("id") Long id){
		
		boolean ok = this.userv.eliminarsuario(id);
		
		if(ok) {
			return "Se eliminó el usuario con id: " + id;
		}else {
			return "NO se eliminó el usuario con id: " + id;
		}
	}
	
	@PutMapping("/actualizar")
	public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel usu) {
		return userv.actualizarUsuario(usu);
	}
	
	
	
}
