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
	
	
	
	@NotBlank(message = "Debe ingresar un nombre para la categoria")
	@Column(name = "nombreCategoria", length = 30, nullable = false)
	private String nombreCategoria;
	
//---------------RELACION: UNA CATEGORIA LO TIENEN MUCHOS PRODUCTOS------------------
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	public Categoria() {
		productos = new ArrayList<>();
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}
}
