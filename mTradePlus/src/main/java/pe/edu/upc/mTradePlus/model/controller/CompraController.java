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
import pe.edu.upc.mTradePlus.model.service.SuscripcionService;

@Controller
@RequestMapping("mTradePlus/compra")
@SessionAttributes("compra")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private SuscripcionService suscripcionService;
	
	@GetMapping
	public String startCompra(Model model) {
		try {
			List<Compra> compras = compraService.readAll();
			model.addAttribute("compras", compras);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/compra/startCompra";
	}
//------------------------- SE AGREGA NUEVA COMPRA -------------------------
	@GetMapping("/nuevo")
	public String nuevaCompra(Model model) {
		Compra compra = new Compra();
		model.addAttribute("compra", compra);
		
		try {
			List<Cliente> clientes = clienteService.readAll();
			model.addAttribute("cliente", clientes);
			
			List<Producto> productos = productoService.readAll();
			model.addAttribute("producto", productos);
			
			List<Suscripcion> suscripciones = suscripcionService.readAll();
			model.addAttribute("suscripcion", suscripciones);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "/compra/nuevaCompra";
	}
//------------------------- SE GUARDA NUEVA COMPRA -------------------------
	@PostMapping("/guardarCompra")
	public String guardarCompra(@ModelAttribute("compra") Compra compra, Model model, SessionStatus status) {
		try {
			compraService.create(compra);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/mTradePlus/compra";
	}
//------------------------- SE ELIMINA NUEVA COMPRA -------------------------
	@GetMapping("/eliminarCompra/{idCompra}")
	public String eliminarCompra(@PathVariable("idCompra") Integer id, Model model){
		try {
			Optional<Compra> optional = compraService.findById(id);
			if(optional.isPresent()) {
				compraService.deleteById(id);
			}
			else {
				return "redirect:/mTradePlus/compra";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/mTradePlus/compra";
	}
}
