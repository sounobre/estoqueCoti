package persistence;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.firebirdsql.jdbc.parser.JaybirdSqlParser.function_return;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Fornecedor;
import model.Funcionario;
import model.MovimentacaoEstoque;
import model.Pessoa;


public class LoginDao {
	Session session;
	Transaction transaction;
	Query query;
	
	public Boolean logar(String login, String senha) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("select F.login, F.senha from Funcionario F where F.login = '"+login+"' and F.senha = "+senha);
			System.out.println(query.list().size());
			if(query.list().size() == 1){
				return true;
			}else
				return false;
		
	}
	
	public Funcionario buscarUsuario(String login) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("select F from Funcionario F where F.login = '"+login+"'");
		Funcionario func = (Funcionario) query.uniqueResult();
		session.close();
		return func;
	}
	
	public List<MovimentacaoEstoque> verificaMinimo() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("select E from MovimentacaoEstoque E where "
				+ "cast(E.qtdEstoque as int) < cast(E.qtdMin as int)");	
		List<MovimentacaoEstoque> lista = query.list();
		session.close();
		return lista;
		
	}
}
