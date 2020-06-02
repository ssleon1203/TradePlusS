package pe.edu.upc.mTradePlus.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.mTradePlus.model.entity.Vendedor;
import pe.edu.upc.mTradePlus.model.repository.VendedorRepository;
import pe.edu.upc.mTradePlus.model.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService{

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	@Transactional
	public Vendedor create(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> readAll() throws Exception {
		return vendedorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vendedor> findById(Integer id) throws Exception {
		return vendedorRepository.findById(id);
	}

	@Override
	@Transactional
	public Vendedor update(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		vendedorRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		vendedorRepository.deleteAll();
	}

//---------------------LISTAS DE LA PARTE DE SERVICE--------------------\\
	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findByNombreVendedor(String nombreVendedor) throws Exception {
		return vendedorRepository.findByNombreVendedor(nombreVendedor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findByApellidoVendedor(String apellidoVendedor) throws Exception {
		return vendedorRepository.findByApellidoVendedor(apellidoVendedor);
	}

	@Override
	public List<Vendedor> findByRucVendedor(String rucVendedor) throws Exception {
		return vendedorRepository.findByRucVendedor(rucVendedor);
	}

}
