package Main;

import java.time.LocalDate;
import java.util.Scanner;

import Dominio.Panes;
import Implementacion.LogicaMetodos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaración de variables
		Scanner lectura = null;

		String nombre, nuevoNombre;
		float precio;
		int existencia, menuPrin, indice;
		String sabor;
		LocalDate fechaLabo;

		Panes pan = null;
		LogicaMetodos imp = new LogicaMetodos();

		System.out.println("Marca de agua, ola de mar");
		float operacion = 3.1416f * 5;
		System.out.println(operacion);

		do {
			System.out.println("MENU PRINCIPAL DE PANADERIA");
			System.out.println("1---ALTA");
			System.out.println("2---MOSTRAR");
			System.out.println("3---BUSCAR POR INDICE");
			System.out.println("4---EDITAR");
			System.out.println("5---ELIMINAR");
			System.out.println("6---BUSCAR POR NOMBRE");
			System.out.println("7---BUSCAR POR SABOR");
			System.out.println("8---CALCULAR EL TOTAL DE DINERO INVERTIDO");
			System.out.println("9---EDITAR BUSCANDO POR NOMBRE");
			System.out.println("10---ELIMINAR BUSCANDO POR NOMBRE");
			System.out.println("11---SALIR");

			lectura = new Scanner(System.in);
			menuPrin = lectura.nextInt();

			switch (menuPrin) {
			case 1:
				try {
					System.out.println("Ingrese el nombre");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					System.out.println("Ingrese el precio");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();

					System.out.println("Ingrese la existencia");
					lectura = new Scanner(System.in);
					existencia = lectura.nextInt();

					System.out.println("Ingrese el sabor");
					lectura = new Scanner(System.in);
					sabor = lectura.nextLine();

					System.out.println("Ingrese la fecha de elaboración(Formato: año-mes-dia)");
					lectura = new Scanner(System.in);
					String fecha = lectura.nextLine();

					fechaLabo = LocalDate.parse(fecha);

					pan = new Panes(nombre, precio, existencia, sabor, fechaLabo);

					// Guardar
					imp.guardar(pan);

				} catch (Exception e) {
					// TODO: handle exception

					System.out.println("Error al guardar " + e.getMessage());
				}
				break;

			case 2:
				if (imp.mostrar().size() > 0)
					System.out.println(imp.mostrar());
				else
					System.out.println("No hay registros");

				break;

			case 3:
				try {
					System.out.println("Ingrese el indice del registro a buscar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Buscar
					pan = imp.buscarXindice(indice);
					System.out.println("Se encontró " + pan);
				} catch (Exception e) {
					// TODO: handle exception

					System.out.println("Error al buscar " + e.getMessage());
				}
				break;

			case 4:
				try {
					System.out.println("Ingrese el indice del registro a editar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Para editar primero hay que Buscar
					pan = imp.buscarXindice(indice);
					System.out.println("Se encontró " + pan.getNombre());

					// Pedir el nuevo dato
					System.out.println("Ingrese el nuevo nombre del pan");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					// Actualizar
					pan.setNombre(nombre);
					imp.editar(indice, pan);
					System.out.println("Se editó correctamente");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al editar " + e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println("Ingrese el indice del registro a eliminar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Eliminar
					imp.eliminar(indice);
					System.out.println("Se eliminó con exito");

				} catch (Exception e) {
					// TODO: handle exception

					System.out.println("Error al eliminar " + e.getMessage());
				}
				break;

			case 6:
				System.out.println("Ingrese el nombre a buscar");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine();

				if (nombre.equals(imp.buscarXnombre(nombre).getNombre())) {
					System.out.println("Se encontró " + imp.buscarXnombre(nombre));
				} else
					System.out.println("No se encontraron registros con el nombre " + nombre);

				break;

			case 7:

				System.out.println("Ingrese el sabor a buscar ");
				lectura = new Scanner(System.in);
				sabor = lectura.nextLine();

				if (imp.buscarXsabor(sabor).isEmpty()) {
					System.out.println("No hay registros con el sabor " + sabor);
				} else
					System.out.println("Se encontró " + imp.buscarXsabor(sabor));

				break;

			case 8:

				imp.calcularInversion();
				break;

			case 9:
				System.out.println("Ingrese el nombre del pan a editar");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine();

				pan = imp.buscarXnombre(nombre);

				if (pan != null) {
					System.out.println("Se encontro " + pan);
					System.out.println("Ingrese el nuevo nombre ");
					lectura = new Scanner(System.in);
					nuevoNombre = lectura.nextLine();

					pan.setNombre(nuevoNombre);

					imp.editarXnombre(nombre, pan);
					System.out.println("Se realizó la edición correctamente");
				} else
					System.out.println("No existen registros con el nombre " + nombre);

				break;

			case 10:
				System.out.println("Ingrese el nombre a eliminar ");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine();

				if (nombre.equals(imp.buscarXnombre(nombre).getNombre())) {
					imp.eliminarXnombre(nombre);
					System.out.println("Se eliminó el registro con el nombre " + nombre);
				} else {
					System.out.println("No existen registros con el nombre " + nombre);
				}

				break;

			case 11:
				break;
			}

		} while (menuPrin < 11);

	}

}
