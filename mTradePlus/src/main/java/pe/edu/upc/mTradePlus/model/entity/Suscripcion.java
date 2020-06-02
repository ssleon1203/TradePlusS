package pe.edu.upc.mTradePlus.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
