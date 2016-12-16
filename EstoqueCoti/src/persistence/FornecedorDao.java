package persistence;

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
		
		
		

}
