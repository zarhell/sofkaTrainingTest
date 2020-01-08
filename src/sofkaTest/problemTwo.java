package sofkaTest;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemTwo {

	public static void main(String[] args) {

		int capMaxCarga = 18000;
		double pesoPerBulto = 0.0;
		double maxPesoBulto = 500.0;
		double costPerBulto = 0.0;
		int  valKgSmall = 0;
		int valKgMedium = 2500;
		int valKgLarge = 1500;
		int precioKg = 0;
		List bultos = new ArrayList();
		int numBultoCargado = 0;
		double bultoMaxPeso = 0.0;
		double bultoMinPeso = 0.0;
		double promPesoBultos = 0.0;
		double pesoTotal = 0;
		double pesoMoneda = 1.0;
		double dolar = pesoMoneda * 3500;
		int bultoId = 1;
		double ingresoTotal = 0.0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Programa para controlar el sistema de carga para equipaje de un Avion ");

		// llenado y validacion de carga maxima permitida
		do {
			System.out.println("Ingrese el Peso del bulto num. " + bultoId + " para calcular su valor por kg");

			pesoPerBulto = sc.nextInt();

			if (pesoPerBulto >= maxPesoBulto && pesoPerBulto > 0 ) {
				System.out.println("el Peso del Bulto es el máximo de 500kg permitido o exceder la carga límite del ávion");
				for (int i = 0; i < bultos.size(); i++) {
					if ((double)bultos.get(i)>maxPesoBulto) {
						bultos.remove(i);
					}
				}

			} else {
				bultoId++;
				bultos.add(pesoPerBulto);
				pesoTotal += pesoPerBulto;

			}
			
		} while (pesoPerBulto > maxPesoBulto && pesoPerBulto > 0 || pesoTotal < capMaxCarga);

		pesoTotal =0;
		
		//asiganción de valor por kilo de carga
		for (int i = 0; i < bultos.size(); i++) {

			numBultoCargado++;
			pesoPerBulto = (double) bultos.get(i);
			if (pesoPerBulto <= 25) {
				costPerBulto = pesoPerBulto * valKgSmall;
				precioKg = valKgSmall;
			}else if (pesoPerBulto < 26 || pesoPerBulto >= 300) {
				costPerBulto = pesoPerBulto * valKgMedium;
				precioKg = valKgMedium;
			} else if (pesoPerBulto < 301 || pesoPerBulto >= 500) {
				costPerBulto = pesoPerBulto * valKgLarge;
				precioKg = valKgLarge;
			}
			
			System.out.println("bulto num: " + numBultoCargado + " \t Peso: " + pesoPerBulto + "kg " + "\t Precio por Kilo: "+ precioKg +"\t Total Precio: $" + costPerBulto);
			
			pesoTotal  += pesoPerBulto;
			ingresoTotal += costPerBulto;

		}
		
		//validación del bulto mas pesado y el bulto mas liviano
		for (int i = 0; i < bultos.size(); i++) {
			if ((double)bultos.get(i) > bultoMaxPeso) {
				bultoMaxPeso = (double) bultos.get(i);
			}
			if ((double)bultos.get(i) < bultoMinPeso) {
				bultoMinPeso = (double) bultos.get(i);
			}
			
		}

		System.out.println("Número total de bultos cargados: " + bultos.size());
		System.out.println("El bulto mas pesado es: " + bultoMaxPeso);
		System.out.println("El bulto mas liviano es: " + bultoMinPeso);
		
		//calcular el peso promedio de los bultos
		promPesoBultos = (bultoMaxPeso + bultoMinPeso ) /2;
		System.out.println("El peso promedio de los bultos es de: " + promPesoBultos);
		System.out.println("Ingreso Total por carga en Pesos: $" + ingresoTotal + "\nIngreso Total por carga en Dolares : US$" + ingresoTotal*dolar);
		
		sc.close();

	}

}
