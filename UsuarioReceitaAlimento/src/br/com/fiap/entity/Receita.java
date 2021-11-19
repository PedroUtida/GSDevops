package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACC_RECEITA")
@SequenceGenerator(name="receita", sequenceName="SQ_ACC_RECEITA", allocationSize=1)
public class Receita {

	@Id
	@Column(name="id_receita")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="receita")
	private int id;
	
	@Column(name="nm_receita", nullable=false, length=30)
	private String nome;
	
	@Column(name="ds_descricao_receita", nullable=false, length=100)
	private String descricaoReceita;
	
	// Mapeamento do relacionamento muitos-para-muitos
	@ManyToMany(cascade = CascadeType.PERSIST)
			
	@JoinTable(name="ACC_Receita_Alimento", 
			joinColumns = @JoinColumn(name="id_receita"),
			inverseJoinColumns = @JoinColumn(name="id_alimento"))
	private List<Alimento> alimentos;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	public Receita() {}
	
	public Receita(String nome, String descricaoReceita) {
		super();
		this.nome = nome;
		this.descricaoReceita = descricaoReceita;
	}
	
	public Receita(int id, String nome, String descricaoReceita) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricaoReceita = descricaoReceita;
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

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	
}
