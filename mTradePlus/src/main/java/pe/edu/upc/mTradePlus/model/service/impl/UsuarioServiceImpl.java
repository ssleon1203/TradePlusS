package pe.edu.upc.mTradePlus.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.mTradePlus.model.entity.Usuario;
import pe.edu.upc.mTradePlus.model.repository.UsuarioRepository;
import pe.edu.upc.mTradePlus.model.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public Usuario create(Usuario entity) throws Exception {
		return usuarioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> readAll() throws Exception {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) throws Exception {
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario update(Usuario entity) throws Exception {
		return usuarioRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) throws Exception {
		usuarioRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findByUsername(String username) throws Exception {
		return usuarioRepository.findByUsername(username);
	}

}
