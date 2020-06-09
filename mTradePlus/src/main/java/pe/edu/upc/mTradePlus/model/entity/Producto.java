package pe.edu.upc.mTradePlus.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@NotBlank(message = "Debe ingresar un nombre para el producto")
	@Column(name = "nombreProducto", length = 35, nullable = false)
	private String nombreProducto;
	
	@Min(value = 1, message = "Debe ingresar un precio para el producto")
	@Max(value = 10000, message = "Debe ingresar un precio para el producto")
	@Column(name = "precioProducto", nullable = false)
	private double precioProducto;
	
	//@Size(min = 1, message = "Debe ingresar una descripcion breve")
	@Column(name = "descripcionProducto", length = 250, nullable = false)
	private String descripcionProducto;
	
	@Min(value = 1, message = "Debe ingresar minimo 1 producto")
	@Column(name = "cantidadProducto", nullable = false)
	private Integer cantidadProducto;
	
//--------------RELACION: MUCHOS PRODUCTOS LO INGRESA UN VENDEDOR--------------
	@ManyToOne
	@JoinColumn(name="idVendedor")
	private Vendedor vendedor;
	
//--------------RELACION: UN PRODUCTO ESTA EN MUCHAS COMPRAS--------------
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private List<Compra> compras;
	
	public Producto() {
		compras = new ArrayList<>();
	}
	
	public void addCompra(Compra compra) {
		compras.add(compra);
	}
}
