package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Receita;
import br.com.fiap.entity.Usuario;
import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.dao.impl.UsuarioDaoImpl;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Busca {

	public static void main(String[] args) {
		 
		// Alterar o persistence.xml na pasta META-INF para update após a criação das tabelas, para poder buscar
		// Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// Obter um usuarioDao
		UsuarioDao dao = new UsuarioDaoImpl(em);
		
		// Pesquisar o usuario de código 1
		try {
			Usuario usuario = dao.findById(1);
			
			// Exibir o nome do usuario
			System.out.println("Usuario: " + usuario.getNome());
			
			// Exibir as receitas do usuario
			System.out.println("Receitas: ");
			for (Receita rec : usuario.getReceitas()) {
				System.out.println("Descrição receita: " + rec.getDescricaoReceita());
			}
		}catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
				em.close();
				EntityManagerFactorySingleton.getInstance().createEntityManager();
	}
}
