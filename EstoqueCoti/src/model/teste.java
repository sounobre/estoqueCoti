package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import persistence.FornecedorDao;
import persistence.MateriaisDao;

public class teste {
	
	public static void main(String[] args)throws Exception {
		try{
		Fornecedor f = new Fornecedor();
		
		f.setNome("diego");
		f.setBairro("Honório GUrgel");
		f.setCep("21511330");
		f.setCidade("Rio de Jnaeiro");
		f.setCnpj("111111111");
		f.setCodigo(12);
		f.setEmail("sounobre@hotmail.com");
		f.setEndereco("Rua general Pinto amando");
		f.setEstado("RJ");
		
		f.setid(null);
		
		new FornecedorDao().cadadstro(f);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}
}
