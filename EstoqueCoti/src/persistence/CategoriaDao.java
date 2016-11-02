package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Categoria;

public class CategoriaDao {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public List<Categoria> listar()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> lista = new ArrayList<Categoria>();
		query = session.createQuery("from Categoria");
		lista = query.list();
		session.close();
		return lista;
	}

	public void cadastrar(Categoria c)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.close();
	}
	
	/*public List<Categoria> buscar()throws Exception {
			
		
		return lista;
	}*/
	
	
}
