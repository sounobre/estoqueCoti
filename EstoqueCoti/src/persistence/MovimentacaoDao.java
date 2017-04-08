package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Materiais;
import model.MovimentacaoEstoque;

public class MovimentacaoDao {
	
	Session session;
	Transaction transaction;
	Query query;
	Criteria crit;
	
/*	public List<MovimentacaoEstoque> buscar(String q) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery(q);
		List<MovimentacaoEstoque> lista = query.list();
		session.close();
		return lista;
	}*/
	
	
	public List<MovimentacaoEstoque> buscar() {
		session = HibernateUtil.getSessionFactory().openSession();
		crit = session.createCriteria(Materiais.class);
		//crit.add(Restrictions.sqlRestriction("select M.nome, M.codigo, C.categoria from Materiais M  inner join Categoria C on C.id_categoria = M.C.id_categoria"));
		List<MovimentacaoEstoque> lista = crit.list();
		session.close();
		return lista;

}
	public String existCadastrado(String q) {
		session = HibernateUtil.getSessionFactory().openSession();
		List<MovimentacaoEstoque> VerificaExistencia = new ArrayList<MovimentacaoEstoque>();
		query = session.createQuery("select M from MovimentacaoEstoque M where M.codigo = " + q);
		VerificaExistencia = query.list();
		session.close();
		if (VerificaExistencia.isEmpty()){
			return "<strong> Material n�o cadastrado no estoque </strong>";
		}else{
			return "<strong> Material cadastrado no estoque </strong>";
		}
			
		
	}
	
}