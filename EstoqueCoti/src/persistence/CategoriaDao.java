package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Categoria;
import model.Materiais;

public class CategoriaDao {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public List<Categoria> listar()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> lista = new ArrayList<Categoria>();
		query = session.createQuery("SELECT C FROM Categoria AS C");
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
	
	public void cadastrarOutros()throws Exception{
		Categoria c = new Categoria();
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		c.setId_categoria(null);
		c.setCategoria("Outros");
		c.setDescricao("Cadastrar outras categorias");
		session.save(c);
		transaction.commit();
		session.close();
	}
	
	public void alterar(Materiais m)throws Exception {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(m);
			transaction.commit();
			session.close();
		
		
	}
	
	public void alterarCat(Categoria categoria)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(categoria);
		transaction.commit();
		session.close();
	
	
}
	
	public void remover(Categoria categoria)throws Exception{
		session= HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(categoria);
		transaction.commit();
		session.close();
	}
	
	
}
