package com.bryancompany.apirest.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bryancompany.apirest.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
	
	//tiene q ser metodo abstracto para q funcione
	public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);


}
