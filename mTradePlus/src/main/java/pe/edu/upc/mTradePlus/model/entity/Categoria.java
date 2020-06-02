package pe.edu.upc.mTradePlus.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	
	@NotBlank(message = "Debe elegir una categoria para el producto")
	@Column(name = "nombreCategoria", length = 45, nullable = false)
	private String nombreCategoria;
	
	@ManyToOne
	@JoinColumn(name="idProducto")
	private Producto producto;
}
