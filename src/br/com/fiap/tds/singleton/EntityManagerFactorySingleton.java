package br.com.fiap.tds.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Classe que gerencia a �nica inst�ncia da f�brica de entity manager
 
public class EntityManagerFactorySingleton {
	
	// Atributo est�tico que armazena a �nica inst�ncia
	private static EntityManagerFactory fabrica;
	
	// Construtor privado (n�o pode)-> new EntityManageFactorySingleton();
	private EntityManagerFactorySingleton() {}
	
	// M�todo est�tico que retorna a �nica inst�ncia
	public static EntityManagerFactory getInstance() {
		// Validar se existe uma inst�ncia da f�brica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
}
