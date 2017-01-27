package persistence;

import java.util.ArrayList;
import java.util.List;

import org.firebirdsql.jdbc.parser.JaybirdSqlParser.returningClause_return;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Funcionario;



public class FuncionarioDao {
		Session session;
		Transaction transaction;
		Query query;
		
		public void cadadstro(Funcionario f)throws Exception {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(f);
			transaction.commit();
			session.close();
		}
		
		public List<Funcionario> verificaIdentidade(String identidade) {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Funcionario> lista = new ArrayList<Funcionario>();
			query = session.createQuery("SELECT F FROM Funcionario F WHERE F.identidade = '"+ identidade + "'");
			lista = query.list();
			session.close();
			return lista;
		}
		
		public List<Funcionario> listarFuncionarios() {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Funcionario> listaFuncionarioes = new ArrayList<Funcionario>();
			query = session.createQuery("FROM Funcionario");
			listaFuncionarioes = query.list();
			session.close();
			return listaFuncionarioes;
			
		}
		
		public void excluir(Funcionario f) {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(f);
			transaction.commit();
			session.close();
		}
	   public void alterar(Funcionario f) {
		   session = HibernateUtil.getSessionFactory().openSession();
		   transaction = session.beginTransaction();
		   session.update(f);
		   transaction.commit();
		   session.close();
		
	}
	   public List<Funcionario> pesquisar(String q) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery(q);
		List<Funcionario> lista = query.list();
		session.close();
		
		return lista;
	}
}
