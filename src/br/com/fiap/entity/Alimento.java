package br.com.fiap.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACC_ALIMENTO")
@SequenceGenerator(name="alimento", sequenceName="SQ_ACC_ALIMENTO", allocationSize=1)
public class Alimento {

	@Id
	@Column(name="id_alimento")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="alimento")
	private int id;
	
	@Column(name="nm_alimento", nullable=false, length=40)
	private String nome;
	
	@Column(name="ds_descricao_alimento", nullable=false, length=100)
	private String descricaoAlimento;
	
	// Mapeamento do relacionamento muitos-para-muitos bidirecional
	@ManyToMany(mappedBy = "alimentos")
	private List<Receita> receitas;
	
	public Alimento() {}

	public Alimento(String nome, String descricaoAlimento) {
		super();
		this.nome = nome;
		this.descricaoAlimento = descricaoAlimento;
	}

	public Alimento(int id, String nome, String descricaoAlimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricaoAlimento = descricaoAlimento;
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

	public String getDescricaoAlimento() {
		return descricaoAlimento;
	}

	public void setDescricaoAlimento(String descricaoAlimento) {
		this.descricaoAlimento = descricaoAlimento;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}
	
}
