package com.sistema.ees14;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sistema.ees14.model.Livro;
import com.sistema.ees14.model.LivroBD;



@ManagedBean(name="LivroAction")
@RequestScoped
public class LivroAction {
	
	public Livro livro;
	public String nomeLivro;
	public String nomeAlteraLivro;
	public String anoLivro;
	public String autorLivro;
	public int idLivro;
	public String reservado;
	public int retornoReserva;
	public String tempReserva;

	public String apareceDiv = "none";
	
	public String getApareceDiv() {
		return apareceDiv;
	}

	public void setApareceDiv(String apareceDiv) {
		this.apareceDiv = apareceDiv;
	}

	public void consulta(){
		LivroBD lBD = new LivroBD();
		
		this.setLivro(lBD.consultaBD(this.getNomeLivro()));
		this.setNomeLivro("");
		this.setIdLivro(livro.getId());
		this.setNomeAlteraLivro(livro.getNome());
		this.setAnoLivro(livro.getAno());
		this.setAutorLivro(livro.getAutor());
		retornoReserva=livro.getReserva();
		if(retornoReserva==0){
			reservado="Nao";
			}else{
			reservado="Sim";	
			}
		
		if (livro.getNome().isEmpty())
			apareceDiv = "none";
		else
			apareceDiv = "block";

		

	}
	
	
	
	public void alterar(){
		Livro x = new  Livro();
		x.setId(idLivro);
		x.setNome(nomeAlteraLivro);
		x.setAno(anoLivro);
		x.setAutor(autorLivro);
		if (reservado.equals("Sim")){
			x.setReserva(1);
		}else{
			x.setReserva(0);
		}
		LivroBD lBD = new LivroBD();
		lBD.updateBD(x);
				
	}
	
	public void alterarReserva(){
		Livro x = new  Livro();
		x.setId(idLivro);
		System.out.println(reservado);
		if (reservado.equals("Sim")){
			x.setReserva(1);
		}else{
			x.setReserva(0);
		}
		LivroBD lBD = new LivroBD();
		lBD.updateBD(x);
		
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getNomeAlteraLivro() {
		return nomeAlteraLivro;
	}

	public void setNomeAlteraLivro(String nomeAlteraLivro) {
		this.nomeAlteraLivro = nomeAlteraLivro;
	}

	public String getAnoLivro() {
		return anoLivro;
	}

	public void setAnoLivro(String anoLivro) {
		this.anoLivro = anoLivro;
	}
	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getReservado() {
		return reservado;
	}

	public void setReservado(String reservado) {
		this.reservado = reservado;
	}

	public int getRetornoReserva() {
		return retornoReserva;
	}

	public void setRetornoReserva(int retornoReserva) {
		this.retornoReserva = retornoReserva;
	}

	public String getTempReserva() {
		return tempReserva;
	}

	public void setTempReserva(String tempReserva) {
		this.tempReserva = tempReserva;
	}
	
}


