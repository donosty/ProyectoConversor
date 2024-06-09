package Main;

import Logica.FormatoJson;
import Logica.Respuesta;

import java.io.IOException;
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
                    System.out.println("1. De USD a ARS" + "\n2. De ARS a USD");
                    System.out.println("3. De USD a BRL" + "\n4. De BRL a USD");
                    System.out.println("5. De USD a CAD" + "\n6. De CAD a USD");
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
