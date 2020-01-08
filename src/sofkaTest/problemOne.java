package sofkaTest;

import java.util.Scanner;

public class problemOne {

	public static void main(String[] args) {
		
		double dist = 0.0;
		int estancia = 0;
		double desc = 0.0;
		double precioPerKm = 35.0;
		double valPasaje = 0.0;
		double subTotal = 0.0;
		double totalDesc = 0.0;
		int discDesc = 1000;
		int estanDesc = 7;
		boolean apliDesc = false;
		Scanner	sc = new Scanner(System.in);
		
		System.out.println("Programa para calcular el valor de un pasaje de Avion"+"\n");
		
		//validar que la dist y la estancia tengan valores superiores a cero
		do {
			System.out.println("Inserte la distancia a recorrer");
			dist = sc.nextDouble();
			if (dist <=  0) {
				System.out.println("por favor ingrese un valor mayor a 0 (cero)");
			}

		} while (dist <=  0);
		
		do {
			System.out.println("Inserte  el numero de dias de estancia");
			estancia = sc.nextInt();
			if (estancia <=  0) {
				System.out.println("por favor ingrese un valor mayor a 0 (cero)");
			}

		} while (estancia <=  0);
				
		System.out.println("Distancia: "+ "\t" + dist + "km" + "\n" + "Estancia: " + "\t" + estancia + "dias");
		//validar si aplica el descuento 
		if (dist > discDesc && estancia > estanDesc) {
			desc = 0.30;
			apliDesc = true;
			totalDesc = (precioPerKm * dist )* desc;
		}else {
			desc = 1;
		}
		//impresion de totales
		subTotal = dist * precioPerKm;
		System.out.println("Subtotal: \t $" + subTotal );
		if (apliDesc == true) {
			System.out.println("Porcentaje descuento: \t" + desc*100 +"%");
			System.out.println("total Decuento:	\t $" + totalDesc);
			valPasaje = subTotal-totalDesc;
			System.out.println("Valor total de Pasaje: \t $" + valPasaje);
			 
		}else {
		
			valPasaje  = subTotal;
			System.out.println("Valor total del Pasaje: \t $" + valPasaje);
		}
		
		sc.close();
		
		
		
	}

}

