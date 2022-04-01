package controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import entidades.Cliente;
import services.ClienteService;

@Controller
public class ClienteControlador {
	@Autowired
	ClienteService service;

	@GetMapping("/cliente")
	public String mostrarClientes(Model model) {

		List<Cliente> listaClientes = this.service.buscarTodos();
		model.addAttribute("clienteKey",listaClientes);
		return "cliente";
	}

	@GetMapping("/ingresar")
	public String showAddForm(Cliente nuevoCliente) {
		return "añadir-cliente";
	}

	@PostMapping("/añadircliente")
	public String addClient(@Valid Cliente nuevoCliente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "añadir-cliente";
		}
		service.insertarCliente(nuevoCliente);
		return "redirect:/index";

	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Cliente actualizarCliente = service.buscarId(id);
		model.addAttribute("cliente", actualizarCliente);
		return "actualizar-cliente";
	}

	@PostMapping("/actualizar/{id}")
	public String updateClient(@PathVariable("id") long id, @Valid Cliente actualizarCliente, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			actualizarCliente.setId(id);
			return "actualizar-cliente";
		}

		service.actualizarCliente(actualizarCliente);
		return "redirect:/index";
	}

	@GetMapping("/borrar/{id}")
	public String deleteClient(@PathVariable("id") long id, Model model) {
		Cliente borrarCliente = service.buscarId(id);
		service.borrarCliente(borrarCliente);
		return "redirect:/index";
	}
}
