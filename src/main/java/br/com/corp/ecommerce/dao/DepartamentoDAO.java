package br.com.corp.ecommerce.dao;

import br.com.corp.ecommerce.model.Departamento;

import org.springframework.data.repository.CrudRepository;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer> {

}
