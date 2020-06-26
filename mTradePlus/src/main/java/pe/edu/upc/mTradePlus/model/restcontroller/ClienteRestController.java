package pe.edu.upc.mTradePlus.model.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.mTradePlus.model.entity.Cliente;
import pe.edu.upc.mTradePlus.model.service.ClienteService;

@RestController
@RequestMapping("/mTradePlus/api/cliente")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Cliente>  > startCliente(){
		try {
			List<Cliente> clientes = clienteService.readAll();
			return new ResponseEntity< List<Cliente>  >(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Cliente  > fetchById(@PathVariable("idCliente") Integer id){
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if(optional.isPresent()) {
				return new ResponseEntity< Cliente >(optional.get(), HttpStatus.OK);
			}
			else {
				return new ResponseEntity< Cliente >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< Cliente >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Cliente > saveCliente(@RequestBody Cliente cliente){
		try {
			Cliente newCliente = clienteService.create(cliente);
			return new ResponseEntity< Cliente >(newCliente, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
