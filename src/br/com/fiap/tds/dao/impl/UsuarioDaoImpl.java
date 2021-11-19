package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuario;
import br.com.fiap.tds.dao.UsuarioDao;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer>
				implements UsuarioDao{

	public UsuarioDaoImpl(EntityManager em) {
		super(em);
	}

}
