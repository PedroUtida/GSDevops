package br.com.fiap.GsWebApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Healthy {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{healthy.title.blank}")
	private String title;
	
	@Size(min = 10, message = "A descrição deve ter pelo penos 10 caracteres")
	private String description;
	
	@Min(value=15 , message = "O preco mínimo é 15")
	@Max(value = 100 , message = "O preco máxima é 100")
	private int preco;

	@Min(value= 0, message = "{healthy.status.min}")
	@Max(value = 100, message = "{healthy.status.max}")
	private int status;
	
	
}