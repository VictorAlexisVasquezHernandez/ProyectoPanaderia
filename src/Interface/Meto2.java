package Interface;

import java.util.List;

import Dominio.Panes;

public interface Meto2 {
	
	public Panes buscarXnombre(String nombre);
	public List<Panes> buscarXsabor(String sabor);
	public void calcularInversion();
	public void editarXnombre(String nombre, Panes pan);
	public void eliminarXnombre(String nombre);

}
