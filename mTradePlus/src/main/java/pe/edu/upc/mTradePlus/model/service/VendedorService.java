package pe.edu.upc.mTradePlus.model.service;

import java.util.List;

import pe.edu.upc.mTradePlus.model.entity.Vendedor;

public interface VendedorService extends CrudService<Vendedor, Integer>{
	List<Vendedor> findByNombreVendedor(String nombreVendedor) throws Exception;
	List<Vendedor> findByApellidoVendedor(String apellidoVendedor) throws Exception;
	List<Vendedor> findByRucVendedor(String rucVendedor) throws Exception;
}
