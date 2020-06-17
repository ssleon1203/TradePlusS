package pe.edu.upc.mTradePlus.model.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.mTradePlus.model.entity.Cliente;
import pe.edu.upc.mTradePlus.model.entity.Usuario;
import pe.edu.upc.mTradePlus.model.entity.Vendedor;
import pe.edu.upc.mTradePlus.model.repository.AuthorityRepository;
import pe.edu.upc.mTradePlus.model.repository.UsuarioRepository;

@Service
public class AddUserDB implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@Override
	public void run(String... args) throws Exception {
		
		// SOLO DESBLOQUEAR CUANDO SE REQUIERA CREAR USUARIO DE FORMA MANUAL
		/*
		Usuario cliente = new Usuario();
		cliente.setUsername("cliente1");
		cliente.setPassword(new BCryptPasswordEncoder().encode("cliente"));
		cliente.setEnable(true);
		
		Usuario vendedor = new Usuario();
		vendedor.setUsername("vendedor1");
		vendedor.setPassword(new BCryptPasswordEncoder().encode("vendedor"));
		vendedor.setEnable(true);
		
		Usuario administrador = new Usuario();
		administrador.setUsername("adminJesus");
		administrador.setPassword(new BCryptPasswordEncoder().encode("godmode"));
		administrador.setEnable(true);
		
		cliente.addAuthority("ROLE_CLIENTE");
		cliente.addAuthority("ACCESS_ADDCOMPRA");
		cliente.addAuthority("ACCESS_DELCOMPRA");
		
		vendedor.addAuthority("ROLE_VENDEDOR");
		vendedor.addAuthority("ACCESS_ADDPRODUCTO");
		vendedor.addAuthority("ACCESS_EDITPRODUCTO");
		vendedor.addAuthority("ACCESS_DELPRODUCTO");
		
		administrador.addAuthority("ROLE_ADMINISTRADOR");
		administrador.addAuthority("ACCESS_ADDPRODUCTO");
		administrador.addAuthority("ACCESS_EDITPRODUCTO");
		administrador.addAuthority("ACCESS_DELPRODUCTO");
		administrador.addAuthority("ACCESS_ADDCLIENTE");
		administrador.addAuthority("ACCESS_EDITCLIENTE");
		administrador.addAuthority("ACCESS_DELCLIENTE");
		administrador.addAuthority("ACCESS_ADDVENDEDOR");
		administrador.addAuthority("ACCESS_EDITVENDEDOR");
		administrador.addAuthority("ACCESS_DELVENDEDOR");
		
		usuarioRepository.save(cliente);
		usuarioRepository.save(vendedor);
		usuarioRepository.save(administrador);*/
		
	}

}
