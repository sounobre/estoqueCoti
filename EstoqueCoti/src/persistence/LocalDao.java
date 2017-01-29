package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Local;

public class LocalDao {
	Session session;
	Transaction transaction;
	Query query;
	
	public void cadastrar(Local l) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(l);
		transaction.commit();
		session.close();
	}
	
public List<Local> validarDuoplicidadeDeLocal(String q) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery(q);
		List<Local> lista = query.list();
		session.close();
		return lista;
	}

}
