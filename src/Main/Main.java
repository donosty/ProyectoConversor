package Main;

import Logica.FormatoJson;
import Logica.Respuesta;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

            Scanner sc = new Scanner(System.in);
            Respuesta respuesta = new Respuesta();

            int peticionCambio;
            double cantidad;

            do{

                do {
                    System.out.println("\n***************************************");
                    System.out.println("Digite la conversion que desea hacer");
                    System.out.println("1. De dolar a peso Argentino" + "\n2. De peso Argentino a dolar");
                    System.out.println("3. De dolar a real brasileño" + "\n4. De real brasileño a dolar");
                    System.out.println("5. De dolar a dolar canadiende" + "\n6. De dolar canadiense a dolar");
                    System.out.println("7. SALIR ");
                    System.out.print("Peticion : ");
                    peticionCambio = sc.nextInt();
                    System.out.println("****************************************");

                    if(peticionCambio <1 || peticionCambio >7){

                        System.out.println("\n!!Digitar un numero valido!!");
                    }

                } while(peticionCambio <1 || peticionCambio >7);

                if(peticionCambio == 7){

                    System.out.println("\nSaliendo del programa...");
                    break;
                }

                respuesta.peticion(peticionCambio);

                System.out.print("\nDigite la cantidad que desea convertir: ");
                cantidad = sc.nextDouble();

                FormatoJson obteniendoJson = new FormatoJson(respuesta);
                obteniendoJson.digitarCantidad(cantidad);

                obteniendoJson.mostrarDatos();


            } while (peticionCambio >=1 || peticionCambio <=6);

    }
}
