package Testes;

import br.unipe.fujioka.java.web.ClienteDao;
import br.unipe.fujioka.java.web.entidades.Cliente;

public class ClienteTestes {
public static void main(String[] args) {
		
		ClienteTestes teste = new ClienteTestes();
		teste.listar();
		
	}
	
	public void cadastrar() {
		
		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao();
		
		cliente.setNome("Theo");
		cliente.setSobrenome("Araujo");
		cliente.setMatricula("1610014750");
		cliente.setAtivo(true);

		dao.salvar(cliente);
		
		System.out.println("\nClientes cadastrado: ");
		System.out.println("Código: " + cliente.getId()+"\nNome: " + cliente.getNome() + " "+ cliente.getSobrenome());

	}
	
	public void remover() {
		
		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao();
		
		cliente = dao.remover((long) 2);
		
		System.out.println("Cliente Removido com Sucesso: " + cliente.getNome());
		
	}
	
	public void ativar() {
		
		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao();
		
		dao.ativar((long) 2);
		
		System.out.println("Cliente status: " + cliente.isAtivo());
		
	}
	
	public void desativar() {
		
		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao();
		
		cliente = dao.desativar((long) 2);
		
		System.out.println("Cliente status: " + cliente.isAtivo());
		
	}
	
	public void listar() {
		
		ClienteDao dao = new ClienteDao();
		
		for(Cliente cliente : dao.listar()) {
			
			System.out.println("\nCódigo: " + cliente.getId()+ "\nNome completo: " + cliente.getNome() + " " + cliente.getSobrenome() + "\nMatrícula:" + cliente.getMatricula());

			if(cliente.isAtivo() == true) {
				
				System.out.println("Status: Ativo");
				
			}else {
				System.out.println("Status: Desativo");
			}
			
			
		}
		
	}

}

