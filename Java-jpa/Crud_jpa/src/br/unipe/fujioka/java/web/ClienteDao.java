package br.unipe.fujioka.java.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import br.unipe.fujioka.java.web.entidades.Cliente;

public class ClienteDao {

	EntityManager manager = new Entity().getEntityManager();

	//Salvar Cliente
	public void salvar(Cliente c) {

		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Cliente salvo com Sucesso!");

	}
	
	//Remover Cliente
	public Cliente remover(Long id) {

		Cliente c = null;
		c = manager.find(Cliente.class, id);
		if (c != null) {
			manager.getTransaction().begin();
			manager.remove(c);
			manager.getTransaction().commit();
			System.out.println("Cliente Removido com Sucesso.");
		} else {

			System.out.println("O cliente com" + id + " não está cadastrado!");

		}

		return c;

	}
	
	//Alterar Cliente
	public Cliente alterar(String matricula) {

		manager.getTransaction().begin();
		Cliente cliente = manager.find(Cliente.class, matricula);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Cliente Alterado com Sucesso.");
		return cliente;

	}

	
	//Ativar Cliente
	public Cliente ativar(Long id) {

		Cliente c = null;
		c = manager.find(Cliente.class, id);
		if (c != null) {
			c.setAtivo(true);
			manager.getTransaction().begin();
			manager.merge(c);
			manager.getTransaction().commit();
		} else {

			System.out.println("O cliente com codigo " + id + " não está cadastrado!");

		}
		return c;

	}
	
	//Desativar Cliente
	public Cliente desativar(Long id) {

		Cliente c = null;

		c = manager.find(Cliente.class, id);
		if (c != null) {
			c.setAtivo(false);
			manager.getTransaction().begin();
			manager.merge(c);
			manager.getTransaction().commit();
		} else {

			System.out.println("O cliente com código " + id + " não está cadastrado!");

		}
		return c;

	}
	
	//Listar Clientes
	public List<Cliente> listar() {
		
		List<Cliente> clientes = null;
	
			clientes = manager.createQuery("from Cliente c").getResultList();
			System.out.println(clientes);
		
		return clientes;
		
	}

}

