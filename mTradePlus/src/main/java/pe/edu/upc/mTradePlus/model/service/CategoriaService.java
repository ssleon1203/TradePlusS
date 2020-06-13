package pe.edu.upc.mTradePlus.model.service;

import java.util.List;

import pe.edu.upc.mTradePlus.model.entity.Categoria;

public interface CategoriaService extends CrudService<Categoria, Integer>{
	List<Categoria> findByNombreCategoria(String nombreCategoria) throws Exception;

}
