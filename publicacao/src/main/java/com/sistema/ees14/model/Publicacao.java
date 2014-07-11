package com.sistema.ees14.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publicacao",catalog="ees14")
@ManagedBean(name="Publicacao")
@RequestScoped
public class Publicacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id; 
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="ano")
	private Integer ano;
	
	@Column(name="resumo")
	private String resumo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void salvarPublicacao(){
		PublicacaoBD lBD = new PublicacaoBD();
		//System.out.println(this);
		lBD.salvarBD(this);
		
	}
	    
	public void consulta(){
		PublicacaoBD lBD = new PublicacaoBD();
		lBD.consultaBD(titulo);
	
	}
	

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
		
}

