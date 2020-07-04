package pe.edu.upc.mTradePlus.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="compra")
@Getter
@Setter
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;
	
	@NotBlank(message = "Debe ingresar un distrito para realizar la entrega")
	@Column(name = "distritoCompra", length = 25, nullable = false)
	private String distritoCompra;
	
	@NotBlank(message = "Debe ingresar una direccion para realizar la entrega")
	@Column(name = "direccionEntrega", length = 30, nullable = false)
	private String direccionEntrega;
	
	@NotBlank(message = "Debe ingresar una referencia para realizar la entrega")
	@Column(name = "referenciaEntrega", length = 25, nullable = false)
	private String referenciaEntrega;
	
	@Min(value = 1, message = "Calificacion minima 1")
	@Column(name = "calificacionEntrega", nullable = false)
	private Integer calificacionEntrega;
	
	@Min(value = 1, message = "Compra minima 1")
	@Column(name = "cantidadCompra", nullable = false)
	private Integer cantidadCompra;
	
	@Past(message = "Debe ingresar fecha de compra")
	@Column(name = "fechaCompra", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date fechaCompra;
	
	@Future(message = "Debe ingresar fecha de entrega")
	@Column(name = "fechaEntrega", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date fechaEntrega;
	
//--------------RELACION: MUCHAS COMPRAS TIENEN UNA SUSCRIPCION--------------
	@ManyToOne
	@JoinColumn(name = "idSuscripcion")
	private Suscripcion suscripcion;
	
//--------------RELACION: MUCHOS A MUCHOS CON PRODUCTO--------------
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	
//--------------RELACION: MUCHOS A MUCHOS CON CLIENTE--------------
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
}
