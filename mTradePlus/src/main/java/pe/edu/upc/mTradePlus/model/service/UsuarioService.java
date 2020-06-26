package pe.edu.upc.mTradePlus.model.service;

import java.util.Optional;

import pe.edu.upc.mTradePlus.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long>{
	Optional<Usuario> findByUsername(String username) throws Exception;
}
