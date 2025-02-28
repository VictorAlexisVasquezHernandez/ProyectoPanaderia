package Implementacion;

import java.util.ArrayList;
import java.util.List;

import Dominio.Panes;
import Interface.Meto2;
import Interface.Metodos;

public class LogicaMetodos implements Metodos, Meto2 {
	
	private List<Panes> lista = new ArrayList<Panes>();
	
	//Validar---que el nombre del pan no se repita
	

	@Override
	public void guardar(Panes pan) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		for(Panes p: lista) {
			if(p.getNombre().equals(pan.getNombre())) {
				System.out.println("Este nombre de pan ya existe, no se puede guardar");
				bandera = true;
				break;
			}
		}
		if(bandera==false) {
			lista.add(pan);
			System.out.println("Se guardó con exito");
		}
		
	}

	@Override
	public List<Panes> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Panes buscarXindice(int indice) {
		// TODO Auto-generated method stub
		return lista.get(indice);
	}

	
	//Excepcion de errores 
	@Override
	public void editar(int indice, Panes pan) {
		// TODO Auto-generated method stub
		lista.set(indice, pan);
		
	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		lista.remove(indice);
		
	}

	@Override
	public Panes buscarXnombre(String nombre) {
		// TODO Auto-generated method stub
		Panes aux = null;
		for(Panes p: lista) {
			if(nombre.equals(p.getNombre())) {
				aux=p;
				break;
			}
		}
		return aux;
		
	}

	@Override
	public List<Panes> buscarXsabor(String sabor) {
		// TODO Auto-generated method stub
		List<Panes> listA =new  ArrayList<Panes>();
		
		for(Panes p: lista) {
			if(sabor.equals(p.getSabor())) {
				
				listA.add(p);
			}
		}
		return listA;
		
	}

	@Override
	public void calcularInversion() {
		// TODO Auto-generated method stub
		float resultado =0;
		for(Panes p:lista) {
			resultado += p.getPrecio()*p.getExistencia();
		}
		System.out.println("El total de la inversión es de $"+ resultado);
		
	}
	@Override
	public void editarXnombre(String nombre, Panes pan) {
		// TODO Auto-generated method stub
		for(int i=0; i<lista.size();i++) {
			if(lista.get(i).getNombre().equals(nombre)) {
				lista.set(i, pan);
				break;
			}
		}
		
	}
	
	@Override
	public void eliminarXnombre(String nombre) {
		// TODO Auto-generated method stub
		for(int i=0; i<lista.size();i++) {
			if(lista.get(i).getNombre().equals(nombre)) {
				lista.remove(i);
		}
		
		
	}
	
	

}
}
