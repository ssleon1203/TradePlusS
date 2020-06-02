package pe.edu.upc.mTradePlus.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.mTradePlus.model.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
	List<Vendedor> findByNombreVendedor(String nombreVendedor) throws Exception;
	List<Vendedor> findByApellidoVendedor(String apellidoVendedor) throws Exception;
	List<Vendedor> findByRucVendedor(Integer rucVendedor) throws Exception;
	
}
