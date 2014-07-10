package com.sistema.ees14.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sistema.ees14.utils.HibernateUtil;

public class AutorBD {
	
	public void salvarBDAutor (Autor autor){
		Session sessao = null;
		Transaction transac = null;
		try{
			sessao = HibernateUtil.buildSessionFactory();//.openSession();
			transac = sessao.beginTransaction();
			sessao.save(autor);
			transac.commit();
			
		}catch (HibernateException e){
		}finally{
			try{
				sessao.close();
			}catch(Throwable e){
			}
		}
	}
	
	public void main (String args[]){
		AutorBD autorBD = new AutorBD();
		Autor autor = new Autor();
		autorBD.salvarBDAutor(autor);
		
	}
}

