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

import pe.edu.upc.mTradePlus.model.entity.Cliente;
import pe.edu.upc.mTradePlus.model.service.ClienteService;

@Controller
@RequestMapping("mTradePlus/cliente")
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String startCliente(Model model) {
		
		try {
			List<Cliente> clientes = clienteService.readAll();
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return "/cliente/startCliente"; //AQUI RETORNA EL html
	}
	
//------------------------- SE AGREGA NUEVO CLIENTE -------------------------
	@GetMapping("/nuevo")
	public String nuevoCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "/cliente/nuevoCliente";
	}
//------------------------- SE GUARDA NUEVO CLIENTE -------------------------
	@PostMapping("/guardarCliente")
	public String guardarCliente(@ModelAttribute("cliente") Cliente cliente, Model model, SessionStatus status) {
		try {
			clienteService.create(cliente);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/mTradePlus/cliente";
	}
//------------------------- SE EDITA CLIENTE -------------------------
	@GetMapping("/editarCliente/{idCliente}")
	public String editarCliente(@PathVariable("idCliente") Integer id, Model model) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("cliente", optional.get());
			}
			else {
				return "redirect: /mTradePlus/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "/cliente/editarCliente";
	}
//------------------------- SE EDITA CLIENTE -------------------------
	@GetMapping("eliminarCliente/{idCliente}")
	public String eliminarCliente(@PathVariable("idCliente") Integer id, Model model) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if (optional.isPresent()) {
				clienteService.deleteById(id);
			}
			else {
				return "redirect:/mTradePlus/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/mTradePlus/cliente";
	}
}
