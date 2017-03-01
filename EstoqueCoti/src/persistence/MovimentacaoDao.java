package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.MovimentacaoEstoque;

public class MovimentacaoDao {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public List<MovimentacaoEstoque> buscar(String q) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery(q);
		List<MovimentacaoEstoque> lista = query.list();
		session.close();
		return lista;
	}

}
