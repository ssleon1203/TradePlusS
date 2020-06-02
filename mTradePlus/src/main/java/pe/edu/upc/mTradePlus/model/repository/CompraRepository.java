package pe.edu.upc.mTradePlus.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.mTradePlus.model.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
	@Query("SELECT c FROM Compra c WHERE c.calificacionEntrega > :calificacionEntrega")
	List<Compra> fetchByMayorCalificacion(Integer calificacionEntrega) throws Exception;
}
