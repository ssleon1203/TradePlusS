package pe.edu.upc.mTradePlus.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.mTradePlus.model.entity.Producto;
import pe.edu.upc.mTradePlus.model.repository.ProductoRepository;
import pe.edu.upc.mTradePlus.model.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional
	public Producto create(Producto entity) throws Exception {
		return productoRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> readAll() throws Exception {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Integer id) throws Exception {
		return productoRepository.findById(id);
	}

	@Override
	@Transactional
	public Producto update(Producto entity) throws Exception {
		return productoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		productoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		productoRepository.deleteAll();
	}
//---------------------LISTAS DE LA PARTE DE SERVICE--------------------\\
	@Override
	@Transactional(readOnly = true)
	public List<Producto> fetchByMayorPrecioProducto(double precioProducto) throws Exception {
		return productoRepository.fetchByMayorPrecioProducto(precioProducto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombreProducto(String nombreProducto) throws Exception {
		return productoRepository.findByNombreProducto(nombreProducto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByCantidadProducto(Integer cantidadProducto) throws Exception {
		return productoRepository.findByCantidadProducto(cantidadProducto);
	}

	@Override
	public List<Producto> fetchByNombreProducto(String nombreProducto) throws Exception {
		return productoRepository.fetchByNombreProducto(nombreProducto);
	}

}
