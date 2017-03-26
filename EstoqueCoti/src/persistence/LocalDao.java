package persistence;

import java.util.ArrayList;
import java.util.List;

import org.firebirdsql.jdbc.parser.JaybirdSqlParser.returningClause_return;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javassist.expr.NewArray;
import model.Fornecedor;
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
public List<String> locaisExistentes() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("select L.lNome from Local group by L.lNome");
		List<String> lista = query.list();
		session.close();
		return lista;
	
}
public void atualizar(Local l) {
	session = HibernateUtil.getSessionFactory().openSession();
	transaction = session.beginTransaction();
	session.update(l);
	transaction.commit();
	session.close();
}
public List<Local> buscar(String q) {
	session = HibernateUtil.getSessionFactory().openSession();
	transaction = session.beginTransaction();
	query = session.createQuery(q);
	List<Local> lista = query.list();
	session.close();
	return lista;
}
public void remover(Local l) {
	session = HibernateUtil.getSessionFactory().openSession();
	transaction = session.beginTransaction();
	session.delete(l);
	transaction.commit();
	session.close();
}
public List<Local> todosOsLocais() {
	session = HibernateUtil.getSessionFactory().openSession();
	List<Local> listal = new ArrayList<Local>();
	query = session.createQuery("SELECT L.lNome, L.cNome, L.pNome from Local as L");
	listal = query.list();
	session.close();
	System.out.println(listal);
	return listal;
}



public List<Local> todosOsCorredores() {
	session = HibernateUtil.getSessionFactory().openSession();
	List<Local> listac = new ArrayList<Local>();
	query = session.createQuery("select c.cNome from Local c ");
	listac = query.list();
	session.close();
	return listac;
}

public List<Local> todasAsPrateleiras() {
	session = HibernateUtil.getSessionFactory().openSession();
	List<Local> listap = new ArrayList<Local>();
	query = session.createQuery("select p.pNome from Local p ");
	listap = query.list();
	session.close();
	return listap;
}
}
