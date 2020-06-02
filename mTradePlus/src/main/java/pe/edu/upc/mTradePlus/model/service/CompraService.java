package pe.edu.upc.mTradePlus.model.service;

import java.util.List;

import pe.edu.upc.mTradePlus.model.entity.Compra;

public interface CompraService extends CrudService<Compra, Integer>{
	//NO SE PONE EL QUERY EN SERVICE
	List<Compra> fetchByMayorCalificacion(Integer calificacionEntrega) throws Exception;
}
