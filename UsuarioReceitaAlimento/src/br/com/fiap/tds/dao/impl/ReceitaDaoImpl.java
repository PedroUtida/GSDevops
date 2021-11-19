package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Receita;
import br.com.fiap.tds.dao.ReceitaDao;

public class ReceitaDaoImpl extends GenericDaoImpl<Receita, Integer>
				implements ReceitaDao{

	public ReceitaDaoImpl(EntityManager em) {
		super(em);
	}

}
