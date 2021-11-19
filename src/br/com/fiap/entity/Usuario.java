package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACC_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_ACC_USUARIO", allocationSize=1)
public class Usuario {

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario")
	private int id;
	
	@Column(name="nm_usuario", nullable=false, length=50)
	private String nome;

	@Column(name="nm_email", nullable=false, length=30)
	private String email;
	
	@Column(name="ds_senha", nullable=false, length=20)
	private String senha;
	
	@Column(name="nr_celular")
	private int celular;

	// CascadeType.REMOVE para remover em cascata
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Receita> receitas;
	
	public Usuario() {}
	
	public Usuario(String nome, String email, String senha, int celular) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
	}

	public Usuario(int id, String nome, String email, String senha, int celular) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
	}
	
	public void addReceita(Receita receita) {
		if (getReceitas() == null)
			setReceitas(new ArrayList<>());
		
		getReceitas().add(receita);
		receita.setUsuario(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}
	
}
