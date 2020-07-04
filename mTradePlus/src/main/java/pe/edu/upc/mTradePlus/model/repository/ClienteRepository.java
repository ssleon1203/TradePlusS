package pe.edu.upc.mTradePlus.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.mTradePlus.model.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	List<Cliente> findByNombreCliente(String nombreCliente) throws Exception;
	List<Cliente> findByApellidoCliente(String apellidoCliente) throws Exception;
}
