package pe.edu.upc.mTradePlus.model.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.mTradePlus.model.entity.Cliente;
import pe.edu.upc.mTradePlus.model.entity.Compra;
import pe.edu.upc.mTradePlus.model.entity.Producto;
import pe.edu.upc.mTradePlus.model.entity.Suscripcion;
import pe.edu.upc.mTradePlus.model.service.ClienteService;
import pe.edu.upc.mTradePlus.model.service.CompraService;
import pe.edu.upc.mTradePlus.model.service.ProductoService;

@Controller
@RequestMapping("mTradePlus/venta")
@SessionAttributes("venta")
public class VentaController {

	@Autowired
	private CompraService compraService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService suscripcionService;
	
	@GetMapping
	public String startVenta(Model model){
		try {
			List<Compra> compras = compraService.readAll();
			model.addAttribute("compras", compras);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/venta/startVenta";
	}

}
