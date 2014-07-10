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
@Table(name="livro",catalog="livro")
@ManagedBean(name="Livro")
@RequestScoped
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id; 
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="autor")
	private Autor autor;
	
	@Column(name="ano")
	private String ano;
	
	@Column(name="reserva")
	private int reserva;
	
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String novo(){
		return "NOVO";
	}

	public void salvarLivro(){
		LivroBD lBD = new LivroBD();
		//System.out.println(this);
		lBD.salvarBD(this);
		
	}
	public void salvar(){
        Livro livro = new Livro();
        livro.setNome(nome);
        //System.out.println(nome);
        livro.setAutor(autor);
        //System.out.println(autor);
        livro.setAno(ano);
        //System.out.println(ano);
        livro.setReserva(0);
        livro.salvarLivro();
		
	}	
	public void consulta(){
		LivroBD lBD = new LivroBD();
		lBD.consultaBD(nome);
		//return "/visualizaLivro";
		//Livro livro = new Livro();
		System.out.println(nome);
		//System.out.println(livro.getNome());
		//System.out.println("teste");
		//System.out.println(livro.ano);
		//System.out.println(livro.id);


	}
	public void imprime(String nome,String ano,Autor autor,int id){
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setAno(ano);
		livro.setAutor(autor);
		livro.setId(id);
		//System.out.println(livro.getNome());
		//System.out.println(livro.getAutor());
		//System.out.println(livro.getAno());
		//System.out.println(livro.getId());
		
		
	}

	public int getReserva() {
		return reserva;
	}

	public void setReserva(int reserva) {
		this.reserva = reserva;
	}
		
}

