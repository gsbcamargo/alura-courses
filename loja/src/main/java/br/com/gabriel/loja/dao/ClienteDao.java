package br.com.gabriel.loja.dao;

import javax.persistence.EntityManager;

import br.com.gabriel.loja.modelo.Cliente;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}

	public Cliente bucarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
}