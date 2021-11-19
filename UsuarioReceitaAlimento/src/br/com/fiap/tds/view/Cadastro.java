package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Alimento;
import br.com.fiap.entity.Receita;
import br.com.fiap.entity.Usuario;
import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.dao.impl.UsuarioDaoImpl;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	public static void main(String[] args) {
		
		// Instanciar um usuario
		Usuario user1 = new Usuario("João Pedro", "joaopedro@gmail.com", "jp123", 945452121);

		// Instanciar duas receitas
		Receita rec1 = new Receita("Primeira receita", "receita composta de alimentos saudaveis");
		Receita rec2 = new Receita("Segunda receita", "receita composta de alimentos saudaveis");
		
		// Adicionar as receitas ao usuario
		user1.addReceita(rec1);
		user1.addReceita(rec2);
		
		// Instanciar quatro alimentos
		Alimento ali1 = new Alimento("Alface", "alface verde e fresca");
		Alimento ali2 = new Alimento("Tomate", "tomate maduro e fresco");
		Alimento ali3 = new Alimento("Batata Doce", "6 batatas doces");
		Alimento ali4 = new Alimento("Frango", "peito de frango desfiado");
		
		// Instanciar uma lista de alimentos e adiciona-las na lista
		List<Alimento> alimentos = new ArrayList<>();
		alimentos.add(ali1);
		alimentos.add(ali2);
		alimentos.add(ali3);
		alimentos.add(ali4);
		
		// Adicionar os alimentos as receitas
		rec1.setAlimentos(alimentos);
		rec1.setAlimentos(alimentos);
		rec2.setAlimentos(alimentos);
		rec2.setAlimentos(alimentos);
		
		// Cadastrar um usuario
		// Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// Instanciar um usuarioDao
		UsuarioDao dao = new UsuarioDaoImpl(em);
		
		try {
			// Persistir o sistema
			dao.create(user1);
			
			// Commit 
			dao.commit();
			System.out.println("Tudo ok!");
		}catch(CommitException e) {
			System.out.println("Deu ruim...");
		}
		
		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
