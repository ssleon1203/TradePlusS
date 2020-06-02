package pe.edu.upc.mTradePlus.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.mTradePlus.model.entity.Suscripcion;
import pe.edu.upc.mTradePlus.model.repository.SuscripcionRepository;
import pe.edu.upc.mTradePlus.model.service.SuscripcionService;

@Service
public class SuscripcionServiceImpl implements SuscripcionService{

	@Autowired
	private SuscripcionRepository suscripcionRepository;
	
	@Override
	@Transactional
	public Suscripcion create(Suscripcion entity) throws Exception {
		return suscripcionRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Suscripcion> readAll() throws Exception {
		return suscripcionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Suscripcion> findById(Integer id) throws Exception {
		return suscripcionRepository.findById(id);
	}

	@Override
	@Transactional
	public Suscripcion update(Suscripcion entity) throws Exception {
		return suscripcionRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		suscripcionRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		suscripcionRepository.deleteAll();
	}
//---------------------LISTAS DE LA PARTE DE SERVICE--------------------\\
}
