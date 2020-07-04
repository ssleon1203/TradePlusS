package pe.edu.upc.mTradePlus.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.mTradePlus.model.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	@Query("SELECT p FROM Producto p WHERE p.precioProducto > :precioProducto")
	List<Producto> fetchByMayorPrecioProducto(double precioProducto) throws Exception;
	List<Producto> findByNombreProducto(String nombreProducto) throws Exception;
	List<Producto> findByCantidadProducto(Integer cantidadProducto) throws Exception;
	
	@Query("SELECT p FROM Producto p WHERE p.nombreProducto like %:nombreProducto%")
	List<Producto> fetchByNombreProducto(String nombreProducto) throws Exception;
}
