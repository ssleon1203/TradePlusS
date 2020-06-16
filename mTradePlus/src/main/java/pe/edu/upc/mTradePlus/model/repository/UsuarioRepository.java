package pe.edu.upc.mTradePlus.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.mTradePlus.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByUsername(String username) throws Exception;
}
