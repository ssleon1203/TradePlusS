package pe.edu.upc.mTradePlus.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mTradePlus/landing")
public class LandingController {

	@GetMapping
	public String startLanding() {
		return "landing/startLanding";
	}
}
