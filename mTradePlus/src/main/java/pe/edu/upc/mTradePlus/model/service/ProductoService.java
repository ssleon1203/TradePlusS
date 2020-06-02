package pe.edu.upc.mTradePlus.model.service;

import java.util.List;

import pe.edu.upc.mTradePlus.model.entity.Producto;

public interface ProductoService extends CrudService<Producto, Integer>{
	//NO SE PONE EL QUERY EN SERVICE
	List<Producto> fetchByMayorPrecioProducto(double precioProducto) throws Exception;
	List<Producto> findByNombreProducto(String nombreProducto) throws Exception;
	List<Producto> findByCantidadProducto(Integer cantidadProducto) throws Exception;
}
