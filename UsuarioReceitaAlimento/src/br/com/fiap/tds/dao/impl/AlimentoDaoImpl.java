package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Alimento;
import br.com.fiap.tds.dao.AlimentoDao;

public class AlimentoDaoImpl extends GenericDaoImpl<Alimento, Integer>
				implements AlimentoDao{

	public AlimentoDaoImpl(EntityManager em) {
		super(em);
	}

}
