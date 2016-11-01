package control;

import java.util.ArrayList;

import java.util.List;


import model.Materiais;
import persistence.MateriaisDao;

public class PopularSelect {
	List<Materiais> listarCategoria;

	public List<Materiais> getListarCategoria() {
			try{
			
				listarCategoria = new MateriaisDao().listarCategoria();
				System.out.println(listarCategoria);
				
			}catch(Exception e){
				
			}
		return listarCategoria;
	}

	public void setListarCategoria(List<Materiais> listarCategoria) {
		this.listarCategoria = listarCategoria;
	}

	@Override
	public String toString() {
		return "PopularSelect [listarCategoria=" + listarCategoria + "]";
	}
	
	

}
