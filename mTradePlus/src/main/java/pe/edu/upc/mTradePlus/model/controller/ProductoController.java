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
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.mTradePlus.model.entity.Producto;
import pe.edu.upc.mTradePlus.model.service.ProductoService;

@Controller
@RequestMapping("mTradePlus/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public String starProducto(Model model) {
		try {
			List<Producto> productos = productoService.readAll();
			model.addAttribute("productos", productos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/producto/startProducto";
	}
//------------------------- SE AGREGA NUEVO CLIENTE -------------------------
		@GetMapping("/nuevo")
		public String nuevoProducto(Model model) {
			Producto producto = new Producto();
			model.addAttribute("producto", producto);
			return "/producto/nuevoProducto";
		}
//------------------------- SE GUARDA NUEVO CLIENTE -------------------------
		@PostMapping("/guardarProducto")
		public String guardarProducto(@ModelAttribute("producto") Producto producto, Model model, SessionStatus status) {
			try {
				productoService.create(producto);
				status.setComplete();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "redirect:/mTradePlus/producto";
		}
//------------------------- SE EDITA CLIENTE -------------------------
		@GetMapping("/editarProducto/{idProducto}")
		public String editarProducto(@PathVariable("idProducto") Integer id, Model model) {
			try {
				Optional<Producto> optional = productoService.findById(id);
				if(optional.isPresent()) {
					model.addAttribute("producto", optional.get());
				}
				else {
					return "redirect: /mTradePlus/producto";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "/producto/editarProducto";
		}
//------------------------- SE EDITA CLIENTE -------------------------
		@GetMapping("eliminarProducto/{idProducto}")
		public String eliminarProducto(@PathVariable("idProducto") Integer id, Model model) {
			try {
				Optional<Producto> optional = productoService.findById(id);
				if (optional.isPresent()) {
					productoService.deleteById(id);
				}
				else {
					return "redirect:/mTradePlus/producto";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "redirect:/mTradePlus/producto";
		}	
}
