package pe.edu.upc.mTradePlus.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("starter")//DEBE TENER EL NOMBRE DEL .html
public class StarterController {

	@GetMapping
	public String Starter() {
		return "index";
	}
}
