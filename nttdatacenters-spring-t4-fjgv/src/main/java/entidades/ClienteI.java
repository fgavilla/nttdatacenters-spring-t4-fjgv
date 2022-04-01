package entidades;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteI extends JpaRepository<Cliente, Long> {
	
	public List<Cliente> buscarPorNombre(String nombre);

	public List<Cliente> buscarNombreCompleto(String nombre, String primerApellido, String segundoApellido);

	
}
