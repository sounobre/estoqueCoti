package persistence;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Funcionario;


public class LoginDao {
	Session session;
	Transaction transaction;
	Query query;
	
	public Boolean logar(String login, String senha) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("select F.login, F.senha from Funcionario F where F.login = "+login+" and F.senha = "+senha);
			if(query.list().size() == 1){
				return true;
			}else
				return false;
		
	}
	
	public Funcionario buscarUsuario(String email) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("select F from Funcionario F where F.email = "+email);
		
		Funcionario func = new Funcionario();
		func.setid(((int) query.getParameterValue(1)));
		System.out.println(query.getParameterValue(1));
		session.close();
		return func;
	}
}
