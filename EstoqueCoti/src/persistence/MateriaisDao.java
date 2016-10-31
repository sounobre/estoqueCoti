package persistence;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
