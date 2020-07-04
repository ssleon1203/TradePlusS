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

import pe.edu.upc.mTradePlus.model.entity.Categoria;
import pe.edu.upc.mTradePlus.model.entity.Producto;
import pe.edu.upc.mTradePlus.model.entity.Vendedor;
import pe.edu.upc.mTradePlus.model.service.CategoriaService;
import pe.edu.upc.mTradePlus.model.service.ProductoService;
import pe.edu.upc.mTradePlus.model.service.VendedorService;

@Controller
@RequestMapping("mTradePlus/producto")
@SessionAttributes("producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String starProducto(Model model) {
		try {
			//OBJETO PRODUCTO USADO PARA LA BUSQUEDA
			Producto producto = new Producto();
			
			model.addAttribute("producto", producto);
			
			List<Producto> productos = productoService.readAll();
			model.addAttribute("productos", productos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/producto/startProducto";
	}
//------------------------- SE AGREGA NUEVO PRODUCTO -------------------------
		@GetMapping("/nuevo")
		public String nuevoProducto(Model model) {
			Producto producto = new Producto();
			model.addAttribute("producto", producto);
			
			try {
				List<Vendedor> vendedores  = vendedorService.readAll();
				model.addAttribute("vendedor", vendedores);
				
				List<Categoria> categorias = categoriaService.readAll();
				model.addAttribute("categoria", categorias);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return "/producto/nuevoProducto";
		}
//------------------------- SE GUARDA NUEVO PRODUCTO -------------------------
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
//------------------------- SE EDITA PRODUCTO -------------------------
		@GetMapping("/editarProducto/{idProducto}")
		public String editarProducto(@PathVariable("idProducto") Integer id, Model model) {
			try {
				Optional<Producto> optional = productoService.findById(id);
				if(optional.isPresent()) {
					model.addAttribute("producto", optional.get());
					
					List<Vendedor> vendedores = vendedorService.readAll();
					model.addAttribute("vendedores", vendedores);
					
					List<Categoria> categorias = categoriaService.readAll();
					model.addAttribute("categorias", categorias);
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
//------------------------- SE ELIMINA PRODUCTO -------------------------
		@GetMapping("/eliminarProducto/{idProducto}")
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
		//------------------------- SE BUSCA PRODUCTO -------------------------
		@PostMapping("/search")
		public String search(@ModelAttribute("producto") Producto producto, Model model) {
			try {
				List<Producto> productos = productoService.fetchByNombreProducto(producto.getNombreProducto());
				model.addAttribute("productos", productos);			
				model.addAttribute("producto", producto);
				// Mensajes
				if (productos.size() > 0) {
					model.addAttribute("mensajeOK", "Se encontraron: " + productos.size() + " productos");
				} else {
					model.addAttribute("mensajeError", "No se encontro ningún producto");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}		
			return "/producto/startProducto";
		}
}
