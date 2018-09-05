package br.unipe.fujioka.java.web;

import java.util.List;

import br.unipe.fujioka.java.web.entidades.Cliente;
import br.unipe.fujioka.java.web.entidades.Preferencias;
import javax.persistence.EntityManager;

public class PreferenciaDao {
	
	EntityManager manager = new Entity().getEntityManager();
	
	
	//Salvar Preferencias do Cliente
	public Preferencias salvar(Preferencias preferencias) {
		
			manager.getTransaction().begin();
			manager.persist(preferencias);
			manager.getTransaction().commit();
			
		return preferencias;

	}
	
	//Listar Preferencias
	public List<Preferencias> listar() {
		
		List<Preferencias> preferencias = null;
				
			preferencias = manager.createQuery("from Preferencias p").getResultList();
			System.out.println(preferencias);
		
		return preferencias;

		
	}
	
	//Listar Preferencias do Cliente
	public List<Preferencias> listarPreferenciasCliente(Long id) {
		
		List<Preferencias> preferencias = null;
				
			preferencias = manager.createQuery("from Preferencias p where id_cliente = " + id).getResultList();
		
		return preferencias;

	}
	
	//Listar Preferencias do Cliente pela Matrícula
	public List<Preferencias> listarPreferenciasClientePorMatricula(String matricula) {
		
		List<Preferencias> preferencias = null;
		Cliente c = null;

			c = (Cliente) manager.createQuery("from Cliente c where matricula = " + matricula).getSingleResult();
			preferencias = manager.createQuery("from Preferencias p where id_cliente = " + c.getId()).getResultList();
			
			return preferencias;

	}
}


