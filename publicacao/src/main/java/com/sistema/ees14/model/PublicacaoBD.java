package com.sistema.ees14.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sistema.ees14.utils.HibernateUtil;


@ManagedBean(name="PublicacaoBD")
@RequestScoped
public class PublicacaoBD {

	public Publicacao publicacao;
	public void salvarBD (Publicacao publicacao){
		Session sessao = null;
		Transaction transac = null;
		try{
			sessao = HibernateUtil.buildSessionFactory();//.openSession();
			transac = sessao.beginTransaction();
			sessao.save(publicacao);
			transac.commit();
			
		}catch (HibernateException e){
			System.out.println(e.getMessage());
			System.out.println("erro ao salvar2");
		}finally{
			try{
				sessao.close();
			}catch(Throwable e){
				System.out.println("erro ao fechar");
			}
		}
	}
	
	public Publicacao consultaBD(String nome){
		Session sessao = null;
		Transaction transac = null;

		try{
			sessao = HibernateUtil.buildSessionFactory();
	
			transac = sessao.beginTransaction();
			String queryString = "from Livro where nome = :nome";
			Query query = sessao.createQuery(queryString);
			query.setString("nome", nome); 
			publicacao=(Publicacao) query.uniqueResult();

			
		} catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.flush();
            sessao.close();
        }
		return publicacao;
	}
	
	public void updateBD(Publicacao publicacao) {
		Session sessao = null;
		Transaction transac = null;
		sessao = HibernateUtil.buildSessionFactory();
		publicacao = (Publicacao)sessao.get(Publicacao.class, publicacao.getId());
		
		publicacao.setTitulo(publicacao.getTitulo());
		publicacao.setAno(publicacao.getAno());
		publicacao.setAutor(publicacao.getAutor());
		publicacao.setResumo(publicacao.getResumo());
				
		try{

			transac = sessao.beginTransaction();

			sessao.update(publicacao);

		
			
			transac.commit();
			
		}catch (HibernateException e){
			System.out.println(e.getMessage());
			System.out.println("erro ao salvar");
		}finally{
			try{
				sessao.close();
			}catch(Throwable e){
				System.out.println("erro ao fechar");
			}
		}
	}
}

