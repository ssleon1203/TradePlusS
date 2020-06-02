package pe.edu.upc.mTradePlus.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.mTradePlus.model.entity.Cliente;
import pe.edu.upc.mTradePlus.model.repository.ClienteRepository;
import pe.edu.upc.mTradePlus.model.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Override
	@Transactional
	public Cliente create(Cliente entity) throws Exception {
		return clienteRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> readAll() throws Exception {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Integer id) throws Exception {
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public Cliente update(Cliente entity) throws Exception {
		return clienteRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		clienteRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		clienteRepository.deleteAll();
	}
//---------------------LISTAS DE LA PARTE DE SERVICE--------------------\\
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByNombreCliente(String nombreCliente) throws Exception {
		return clienteRepository.findByNombreCliente(nombreCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByApellidoCliente(String apellidoCliente) throws Exception {
		return clienteRepository.findByApellidoCliente(apellidoCliente);
	}

}
