package pe.edu.upc.mTradePlus.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "suscripcion")
@Getter
@Setter
public class Suscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSuscripcion;
	
	@Column(name = "nombreSuscripcion",length = 20,nullable = false)
	private String nombreSuscripcion;
	
	@Column(name = "precioSuscripcion", nullable = false)
	private double precioSuscripcion;

//--------------RELACION: UNA SUSCRIPCION ESTA EN MUCHAS COMPRA--------------
	@OneToMany(mappedBy = "suscripcion", fetch = FetchType.LAZY)
	private List<Compra> compras;
	
	public Suscripcion() {
		compras = new ArrayList<>();
	}
	
	public void addCompra(Compra compra) {
		compras.add(compra);
	}
}
