package Testes;

import br.unipe.fujioka.java.web.PreferenciaDao;
import br.unipe.fujioka.java.web.entidades.Preferencias;

public class PreferenciasTestes {
	public static void main(String[] args) {

		Preferencias preferencias = new Preferencias();
		PreferenciaDao dao = new PreferenciaDao();
		
		 preferencias.setId_cliente((long) 4);
		 preferencias.setPreferencia("Dinheiro");
		 
		 preferencias = dao.salvar(preferencias);



		 for(Preferencias preferencia : dao.listarPreferenciasCliente((long) 5)){
		  
		 System.out.println("Prefencias do cliente: " +
		  preferencias.getPreferencia());
		  
		 }


		for (Preferencias prefer : dao.listarPreferenciasClientePorMatricula("1610014750")) {

			System.out.println(preferencias.getPreferencia());

		}

	}

}
