package pe.edu.upc.mTradePlus.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.mTradePlus.model.entity.Compra;
import pe.edu.upc.mTradePlus.model.repository.CompraRepository;
import pe.edu.upc.mTradePlus.model.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService{

	@Autowired
	private CompraRepository compraRepository;
	
	@Override
	@Transactional
	public Compra create(Compra entity) throws Exception {
		return compraRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compra> readAll() throws Exception {
		return compraRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Compra> findById(Integer id) throws Exception {
		return compraRepository.findById(id);
	}

	@Override
	@Transactional
	public Compra update(Compra entity) throws Exception {
		return compraRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		compraRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		compraRepository.deleteAll();
	}
//---------------------LISTAS DE LA PARTE DE SERVICE--------------------\\
	@Override
	@Transactional(readOnly = true)
	public List<Compra> fetchByMayorCalificacion(Integer calificacionEntrega) throws Exception {
		return compraRepository.fetchByMayorCalificacion(calificacionEntrega);
	}

}
