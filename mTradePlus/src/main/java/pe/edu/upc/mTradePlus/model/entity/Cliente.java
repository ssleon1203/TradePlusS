package pe.edu.upc.mTradePlus.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@NotBlank(message = "Debe ingresar nombre completo")
	@Column(name = "nombreCliente",length = 30, nullable = false)
	private String nombreCliente;
	
	@NotBlank(message = "Debe ingresar apellido completo")
	@Column(name = "apellidoCliente", length = 40, nullable = false)
	private String apellidoCliente;
	
	@Size(min = 8, max = 8, message = "El DNI debe ser de 8 digitos")
	@Column(name = "dni", length = 8, nullable = false)
	private String dniCliente;
	
	@Past(message = "Debe ingresar fecha de nacimiento")
	@Column(name = "fechaNacimiento", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yy-mm-dd")
	private Date fechaNacimiento;
	
	@NotBlank(message = "Debe ingresar una direccion")
	@Column(name = "direccionCliente", length = 50,nullable = false)
	private String direccionCliente;
	
	@NotNull(message = "Debe ingresar su correo")
	@Email(message = "Debe ingresar un correo valido")
	@Column(name = "correoCliente",length = 40, nullable = false)
	private String correoCliente;
	
	//RELACION: UN CLIENTE COMPRA MUCHOS PRODUCTOS
	@ManyToMany
	@JoinTable(name = "compra",
			joinColumns = { @JoinColumn(name = "clienteId", referencedColumnName = "idCliente")}, 
			inverseJoinColumns = {@JoinColumn(name = "productoId", referencedColumnName = "idProducto")})
	private List<Producto> productos;
	
	public Cliente() {
		productos = new ArrayList<>();
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}
}
