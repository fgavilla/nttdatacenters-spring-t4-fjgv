package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Cliente;
import entidades.ClienteI;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteI repo;

	@Override
	public void insertarCliente(Cliente nuevoCliente) {
		Boolean dniUnico = !buscarTodos().stream().anyMatch(c -> c.getDni().equals(nuevoCliente.getDni()));
		if (nuevoCliente != null && nuevoCliente.getId() == null && dniUnico) {

			repo.saveAndFlush(nuevoCliente);
		}
	}

	@Override
	public void actualizarCliente(Cliente actualizarCliente) {
		if (actualizarCliente != null && actualizarCliente.getId() != null) {

			repo.saveAndFlush(actualizarCliente);

		}

	}

	@Override
	public void borrarCliente(Cliente borrarCliente) {
		if (borrarCliente != null && borrarCliente.getId() != null) {

			repo.delete(borrarCliente);
		}

	}

	@Override
	public Cliente buscarId(Long clienteId) {
		Cliente result = null;

		if (clienteId != null) {
			result = repo.findById(clienteId).get();
		}
		return result;
	}

	@Override
	public List<Cliente> buscarTodos() {
		
		return repo.findAll();
	}

	@Override
	public List<Cliente> buscarPorNombre(String nombre) {
		
		return repo.buscarPorNombre(nombre);
	}

	@Override
	public List<Cliente> buscarNombreCompleto(String nombre, String primerApellido, String segundoApellido) {
		return repo.buscarNombreCompleto(nombre, primerApellido, segundoApellido);
	}

}
