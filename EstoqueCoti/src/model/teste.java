package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import persistence.MateriaisDao;

public class teste {
	
	public static void main(String[] args) {
		List<Materiais> lista = new MateriaisDao().listar();
		System.out.println(lista);
		List<String> lista2 = new ArrayList<String>();
		for(int a = 0; a <= lista.size() - 1; a++){
			System.out.println(lista.size());
			System.out.println(lista.get(a).getCategoria());
			if(lista2.contains(lista.get(a).getCategoria())){
				System.out.println(lista2);
				continue;
			}else{
				lista2.add(lista.get(a).getCategoria());
			}
		}
		System.out.println(lista2);
		
		

	}
}
