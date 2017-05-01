package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.HistoricoEstoque;
import model.Materiais;
import model.MovimentacaoEstoque;

public class MovimentacaoDao {
	
	Session session;
	Transaction transaction;
	Query query;
	Criteria crit;
	
	public List<MovimentacaoEstoque> buscarDetalhes(String q) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery(q);
		List<MovimentacaoEstoque> lista = query.list();
		session.close();
		return lista;
	}
	
	
	public List<MovimentacaoEstoque> buscar() {
		session = HibernateUtil.getSessionFactory().openSession();
		crit = session.createCriteria(Materiais.class);
		//crit.add(Restrictions.sqlRestriction("select M.nome, M.codigo, C.categoria from Materiais M  inner join Categoria C on C.id_categoria = M.C.id_categoria"));
		List<MovimentacaoEstoque> lista = crit.list();
		session.close();
		return lista;

}
	public List<MovimentacaoEstoque> existCadastrado(String q) {
		session = HibernateUtil.getSessionFactory().openSession();
		List<MovimentacaoEstoque> VerificaExistencia = new ArrayList<MovimentacaoEstoque>();
		query = session.createQuery(q);
		VerificaExistencia = query.list();
		session.close();
		return VerificaExistencia;
			
		
	}
	public String qtdEstoque(String codigo) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select M.qtdEstoque from MovimentacaoEstoque M where M.codigo = '"+codigo+"'");
		String qtdEstoque = (String) query.uniqueResult();
		System.out.println(qtdEstoque);
		session.close();
		return qtdEstoque;
		
	}
	
	public void cadastrarEntrada(MovimentacaoEstoque mv) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(mv);
		transaction.commit();
		session.close();
	}
	
	public void atualizarEntrada(MovimentacaoEstoque mv) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(mv);
		transaction.commit();
		session.close();
	}
	public void cadastrarEntradaHistorico(HistoricoEstoque mv) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(mv);
		transaction.commit();
		session.close();
	}
	
	//public return_type name() {
		
	//}
	
}
