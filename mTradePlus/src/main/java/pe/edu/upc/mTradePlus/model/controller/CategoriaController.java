package pe.edu.upc.mTradePlus.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.mTradePlus.model.entity.Categoria;
import pe.edu.upc.mTradePlus.model.service.CategoriaService;

@Controller
@RequestMapping("mTradePlus/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	public String startCategoria(Model model) {
		try {
			List<Categoria> categorias = categoriaService.readAll();
			model.addAttribute("categorias", categorias);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/categoria/startCategoria";
	}
}
