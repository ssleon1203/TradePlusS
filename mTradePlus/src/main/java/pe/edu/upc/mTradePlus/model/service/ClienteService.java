package pe.edu.upc.mTradePlus.model.service;

import java.util.List;

import pe.edu.upc.mTradePlus.model.entity.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer> {
	List<Cliente> findByNombreCliente(String nombreCliente) throws Exception;
	List<Cliente> findByApellidoCliente(String apellidoCliente) throws Exception;
}
