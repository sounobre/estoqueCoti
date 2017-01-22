package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Fornecedor;
import model.Funcionario;
import model.Materiais;

public class FornecedorDao {
		Session session;
		Transaction transaction;
		Query query;
		
		public void cadadstro(Fornecedor f)throws Exception {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(f);
			transaction.commit();
			session.close();
		}
		
		public List<Fornecedor> verificaCNPJ(String cnpj) {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Fornecedor> lista = new ArrayList<Fornecedor>();
			query = session.createQuery("SELECT F FROM Fornecedor F WHERE F.cnpj = '"+ cnpj + "'");
			lista = query.list();
			session.close();
			return lista;
		}
		
		public List<Fornecedor> listarFornecedores() {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
			query = session.createQuery("FROM Fornecedor");
			
			listaFornecedores = query.list();
			session.close();
			return listaFornecedores;
			
		}
		
		public void excluir(Fornecedor f) {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(f);
			transaction.commit();
			session.close();
		}

}
