package pe.edu.upc.mTradePlus.model.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.upc.mTradePlus.model.entity.Usuario;
import pe.edu.upc.mTradePlus.model.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Optional<Usuario> optional = this.usuarioRepository.findByUsername(username);
			if(optional.isPresent()) {
				UsuarioDetails usuarioDetails = new UsuarioDetails(optional.get());
				return usuarioDetails;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new UsernameNotFoundException("El usuario ingresado no existe");
	}
}
