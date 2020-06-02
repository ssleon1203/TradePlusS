package pe.edu.upc.mTradePlus.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.mTradePlus.model.entity.Compra;
import pe.edu.upc.mTradePlus.model.service.CompraService;

@Controller
@RequestMapping("mTradePlus/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
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
}
