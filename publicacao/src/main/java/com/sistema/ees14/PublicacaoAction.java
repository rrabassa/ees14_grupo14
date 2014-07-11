package com.sistema.ees14;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sistema.ees14.model.Publicacao;
import com.sistema.ees14.model.PublicacaoBD;

@ManagedBean
@RequestScoped
public class PublicacaoAction {
	
	public Publicacao publicacao;
	
	@PostConstruct
    public void postContruct() {
		publicacao = new Publicacao();
    }
	
	public void salvar(){
		PublicacaoBD lBD = new PublicacaoBD();
		lBD.salvarBD(publicacao);
		
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

}