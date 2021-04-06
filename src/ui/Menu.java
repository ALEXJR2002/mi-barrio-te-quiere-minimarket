package ui;

import java.util.Scanner;

import exceptions.SameParityException;
import exceptions.UnderAgeException;
import model.Minimarket;

public class Menu {
	
	private final static int ADD_PERSON = 1;
	private final static int SHOW_TOTAL_ENTER_ATTEMPTS = 2;
	private final static int EXIT = 3;
	
	private Minimarket minimarket;
	
	Scanner sc = new Scanner (System.in);
	
	public Menu () {
		minimarket = new Minimarket ();
	}
	
	public void showMenu () {
		System.out.println("�Bienvenido al Minimercado Mi Barrio Te Quiere!");
		int option; 
		do {
			System.out.println("\n(1) Para agregar personas." +
					"\n(2) Para mostrar el total de intentos de ingreso." +
					"\n(3) Para salir.");	
			option = sc.nextInt();
			doOperation(option);
		}while (option != 0);

	}

	private void doOperation(int option) {

		switch (option) {
		case ADD_PERSON:
			addPerson();
		case SHOW_TOTAL_ENTER_ATTEMPTS:
			showTotalPeople();
		case EXIT:
			System.out.println("�Adios!");
			default:
				System.out.println("Digite una opcion v�lida");
		}
	}

	private void showTotalPeople() {
		System.out.println("El total de personas que ha intentado ingresar es: " + minimarket.getCounter());
		
	}

	private void addPerson() {

		System.out.println("Tipo de identificaci�n: " + 
							"\n (1)TI - TARJETA DE IDENTIDAD \t(2)CC - C�DULA DE CIUDADAN�A" + 
							"\n(3)PP - PASAPORTE \t (4)CE - C�DULA DE EXTRANJER�A");
		int documentType = sc.nextInt();
		System.out.print("Ingrese su numero de identificaci�n: ");
		String id = sc.nextLine();
		
		try {
			minimarket.addPerson(documentType, id);
		} catch (UnderAgeException e) {
			System.out.println("No pueden ingresar personas menores de edad.");
			e.printStackTrace();
		} catch (SameParityException e) {
			System.out.println("Usted no cumple con el pico y c�dula. \nHoy es: " + e.getDayOfTheMonth() + " y su pen�ltimo digito es: " + e.getSecondLastNumber());
			e.printStackTrace();
		}
		
	}
	
	

}
