package pe.edu.upc.mTradePlus.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.mTradePlus.model.entity.Vendedor;
import pe.edu.upc.mTradePlus.model.service.VendedorService;

@Controller
@RequestMapping("mTradePlus/vendedor")
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
}
