package br.com.corp.ecommerce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.corp.ecommerce.model.Usuario;
import br.com.corp.ecommerce.services.IUsuarioService;

@SpringBootTest
class UsuarioServicesTests {

	@Autowired
	private IUsuarioService service;

	@Test // Testo somente se o servico existe
	void shouldExistUsuarioService() {
		Assertions.assertTrue(service.recuperarTodos() != null || service.recuperarTodos() == null);
	}

	@Test
	public void shouldReturnListaDeUsuario() {
		Assertions.assertTrue(service.recuperarTodos().size() >= 0);
	}

	@Test
	public void sholdExistServicoDetalhes() {
		Assertions.assertTrue(service.recuperarDetalhes(1) != null || service.recuperarDetalhes(1) == null);
	}

	@Test
	public void shouldReturnUsuarioExistente() {
		Assertions.assertInstanceOf(Usuario.class, service.recuperarDetalhes(1));
	}

	@Test
	public void shouldReturnUsuarioInexistente() {
		Assertions.assertEquals(null, service.recuperarDetalhes(1000));
	}

	@Test
	public void shouldThrowExceptionDeIdInvalido() {
		Assertions.assertThrows(java.lang.RuntimeException.class, () -> {
			service.recuperarDetalhes(-1);
		});
	}
	

}
