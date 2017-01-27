package persistence;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import control.ControleMateriais;
import model.Materiais;

public class MateriaisDao {
	Session session;
	Transaction transaction;
	Query query;
	
	public List<Materiais> listar() {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("SELECT M FROM Materiais AS M");
		List<Materiais> lista = query.list();
		session.close();
		
		return lista;
	}
	
	public List<Materiais> pesquisar(String q) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery(q);
		List<Materiais> lista = query.list();
		session.close();
		
		return lista;
	}
	
		
	public void cadastrar(Materiais materiais)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(materiais);
		transaction.commit();
		session.close();
		
	}
	
	public void remover(Materiais materiais) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(materiais);
		transaction.commit();
		session.close();
	}
	
	public void alterar(Materiais m) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(m);
		transaction.commit();
		session.close();
	}
	
	
}
