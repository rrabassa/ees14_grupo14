package com.sistema.ees14.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@ManagedBean(name="Autor")
@RequestScoped
@Table(name="autor")
@Entity
public class Autor{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id; 
	
	@Column(name="nome")
	private String nome;

	
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

	
	public void salvarAutor(){
		AutorBD lBD = new AutorBD();
		lBD.salvarBDAutor(this);
		
	}
	public void salvarA(){
		Autor autor = new Autor();
        autor.setNome(nome);
        autor.salvarAutor();
		
	}

}
