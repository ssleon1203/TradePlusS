package pe.edu.upc.mTradePlus.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.mTradePlus.model.entity.Categoria;
import pe.edu.upc.mTradePlus.model.repository.CategoriaRepository;
import pe.edu.upc.mTradePlus.model.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	@Transactional
	public Categoria create(Categoria entity) throws Exception {
		return categoriaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> readAll() throws Exception {
		return categoriaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Categoria> findById(Integer id) throws Exception {
		return categoriaRepository.findById(id);
	}

	@Override
	@Transactional
	public Categoria update(Categoria entity) throws Exception {
		return categoriaRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		categoriaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		categoriaRepository.deleteAll();
	}

//---------------------LISTAS DE LA PARTE DE SERVICE--------------------\\
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findByNombreCategoria(String nombreCategoria) throws Exception {
		return categoriaRepository.findByNombreCategoria(nombreCategoria);
	}

}
