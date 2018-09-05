package br.unipe.fujioka.java.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Otimização
public class Entity {

private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
	
	public EntityManager getEntityManager() {
		
		return factory.createEntityManager();
	}
	
}