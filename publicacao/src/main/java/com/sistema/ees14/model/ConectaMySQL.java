package com.sistema.ees14.model;

import org.hibernate.Session;

import com.sistema.ees14.utils.HibernateUtil;


public class ConectaMySQL {
	
	public static void main(String args[]){
		Session sessao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
		} finally {
			sessao.close();
		}
	}
}
