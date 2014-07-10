package com.sistema.ees14.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sistema.ees14.utils.HibernateUtil;


@ManagedBean(name="LivroBD")
@RequestScoped
public class LivroBD {
@Id
public Livro livro=new Livro();
	public Livro l;
	public void salvarBD (Livro livro){
		Session sessao = null;
		Transaction transac = null;
		try{
			//System.out.println(livro);
			sessao = HibernateUtil.buildSessionFactory();//.openSession();
			//System.out.println("conectado2...");
			transac = sessao.beginTransaction();
			//System.out.println(transac);
			sessao.save(livro);
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
	
	public Livro consultaBD(String nome){
		Session sessao = null;
		Transaction transac = null;

		try{
			sessao = HibernateUtil.buildSessionFactory();
	
			transac = sessao.beginTransaction();
			String queryString = "from Livro where nome = :nome";
			Query query = sessao.createQuery(queryString);
			query.setString("nome", nome); 
			livro=(Livro) query.uniqueResult();

			
		} catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            sessao.flush();
            sessao.close();
        }
		return livro;
	}
	
	public void updateBD(Livro x) {
		Session sessao = null;
		Transaction transac = null;
		sessao = HibernateUtil.buildSessionFactory();
		l = (Livro)sessao.get(Livro.class,x.getId());
		
		l.setNome(x.getNome());
		l.setAno(x.getAno());
		l.setAutor(x.getAutor());
		l.setReserva(x.getReserva());
				
		try{

			transac = sessao.beginTransaction();

			sessao.update(l);

		
			
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

