package br.com.corp.ecommerce.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

//Essa definição indica que o filtro será executado a cada nova req (ou seja, não haverá nenhum tipo
// de cache de autenticações para isso
public class EcommerceFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// aqui vem a lógica de autorizar ou não

		System.out.println("Requisição passando pelo filtro...");

		// o que preciso fazer em um filtro?
		// validar minha lógica de autorização
		if (request.getHeader("Authorization") != null) {
			Authentication auth = TokenUtil.validate(request); // veriffico se é válida
			// se for válida, insiro um cabeçalho do tipo Authentication indicando que a
			// requisição é autenticada
			SecurityContextHolder.getContext().setAuthentication(auth);
		}

		// encaminhar a requisição para frente
		filterChain.doFilter(request, response);
	}
}
