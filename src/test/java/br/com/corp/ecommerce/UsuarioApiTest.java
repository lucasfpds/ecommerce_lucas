package br.com.corp.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioApiTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void sholdReturnListaDeUsuarios() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
//			   .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
			   .andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void sholdReturnUsuarioValido() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/1"))
		   .andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void sholdReturnNotFoundStatus() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/100"))
		   .andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void sholdReturnBadReqiestStatus() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/-1"))
		   .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
	
