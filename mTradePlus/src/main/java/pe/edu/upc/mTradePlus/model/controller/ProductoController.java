package pe.edu.upc.mTradePlus.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
