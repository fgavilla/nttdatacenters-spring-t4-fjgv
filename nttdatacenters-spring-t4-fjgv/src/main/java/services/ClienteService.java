package services;

import java.util.List;

import entidades.Cliente;

public interface ClienteService {
	
	public void insertarCliente(final Cliente nuevoCliente);

	public void actualizarCliente(final Cliente actualizarCliente);

	public void borrarCliente(final Cliente borrarCliente);

	public Cliente buscarId(final Long clienteId);

	public List<Cliente> buscarTodos();

	public List<Cliente> buscarPorNombre(final String nombre);

	public List<Cliente> buscarNombreCompleto(String nombre, String primerApellido, String segundoApellido);
}
