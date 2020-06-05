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

import pe.edu.upc.mTradePlus.model.entity.Vendedor;
import pe.edu.upc.mTradePlus.model.service.VendedorService;

@Controller
@RequestMapping("mTradePlus/vendedor")
@SessionAttributes("vendedor")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String startVendedor(Model model) {
		try {
			List<Vendedor> vendedores = vendedorService.readAll();
			model.addAttribute("vendedores", vendedores);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/startVendedor";
	}	
//------------------------- SE AGREGA NUEVO VENDEDOR -------------------------	
	@GetMapping("/nuevo")
	public String nuevoVendedor(Model model) {
		Vendedor vendedor= new Vendedor();
		model.addAttribute("vendedor", vendedor);
		return "/vendedor/nuevoVendedor";
	}
	//------------------------- SE GUARDA NUEVO CLIENTE -------------------------
		@PostMapping("/guardarVendedor")
		public String guardarVendedor(@ModelAttribute("vendedor") Vendedor vendedor, Model model, SessionStatus status) {
			try {
				vendedorService.create(vendedor);
				status.setComplete();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "redirect:/mTradePlus/vendedor";
		}
	//------------------------- SE EDITA CLIENTE -------------------------
		@GetMapping("/editarVendedor/{idVendedor}")
		public String editarVendedor(@PathVariable("idVendedor") Integer id, Model model) {
			try {
				Optional<Vendedor> optional = vendedorService.findById(id);
				if(optional.isPresent()) {
					model.addAttribute("vendedor", optional.get());
				}
				else {
					return "redirect: /mTradePlus/vendedor";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "/vendedor/editarVendedor";
		}
	//------------------------- SE EDITA CLIENTE -------------------------
		@GetMapping("/eliminarVendedor/{idVendedor}")
		public String eliminarVendedor(@PathVariable("idVendedor") Integer id, Model model) {
			try {
				Optional<Vendedor> optional = vendedorService.findById(id);
				if (optional.isPresent()) {
					vendedorService.deleteById(id);
				}
				else {
					return "redirect:/mTradePlus/vendedor";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "redirect:/mTradePlus/vendedor";
		}
}
