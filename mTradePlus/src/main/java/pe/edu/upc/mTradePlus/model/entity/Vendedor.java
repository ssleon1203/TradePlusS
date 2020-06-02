package pe.edu.upc.mTradePlus.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "vendedor")
@Getter
@Setter
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVendedor;
	
	@NotBlank(message = "Debe ingresar nombre completo")
	@Column(name = "nombreVendedor",length = 30, nullable = false)
	private String nombreVendedor;
	
	@NotBlank(message = "Debe ingresar apellido completo")
	@Column(name = "apellidoVendedor", length = 40, nullable = false)
	private String apellidoVendedor;
	
	@Size(min = 8, max = 8, message = "El DNI debe ser de 8 digitos")
	@Column(name = "dni", length = 8, nullable = false)
	private String dniVendedor;
	
	@Past(message = "Debe ingresar fecha de nacimiento")
	@Column(name = "fechaNacimientoV", nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yy-mm-dd")
	private Date fechaNacimientoV;
	
	@NotBlank(message = "Debe ingresar una direccion")
	@Column(name = "direccionVendedor", length = 50,nullable = false)
	private String direccionVendedor;
	
	@NotNull(message = "Debe ingresar su correo")
	@Email(message = "Debe ingresar un correo valido")
	@Column(name = "correoVendedor", length = 40,nullable = false)
	private String correoVendedor;
	
	@Size(min = 11, max = 11, message = "El RUC debe ser de 11 digitos")
	@Column(name = "rucVendedor",length = 11, nullable = false)
	private String rucVendedor;
}
