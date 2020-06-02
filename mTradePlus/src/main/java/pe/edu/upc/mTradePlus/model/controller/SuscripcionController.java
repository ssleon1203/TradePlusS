package pe.edu.upc.mTradePlus.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.mTradePlus.model.entity.Suscripcion;
import pe.edu.upc.mTradePlus.model.service.SuscripcionService;

@Controller
@RequestMapping("mTradePlus/suscripcion")
public class SuscripcionController {

	@Autowired
	private SuscripcionService suscripcionService;
	
	@GetMapping
	public String starSuscripcion(Model model) {
		try {
			List<Suscripcion> suscripciones = suscripcionService.readAll();
			model.addAttribute("suscripciones", suscripciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/suscripcion/startSuscripcion";
	}
}
