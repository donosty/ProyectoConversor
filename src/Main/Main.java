package Main;

import Logica.FormatoJson;
import Logica.Respuesta;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

            Scanner sc = new Scanner(System.in);
            Respuesta respuesta = new Respuesta();
            FormatoJson obteniendoJson = new FormatoJson();

            int peticionCambio;
            double cantidad;

            do{

                System.out.println("***************************************");
                System.out.println("Digite la conversion que desea hacer");
                System.out.println("1. De USD a ARS" + "\n2. De ARS a USD");
                System.out.println("3. De USD a BRL" + "\n4. De BRL a USD");
                System.out.println("5. De USD a CAD" + "\n6. De COL a CAD");
                System.out.println("7. SALIR ");
                System.out.print("Peticion : ");
                peticionCambio = sc.nextInt();
                System.out.println("****************************************");

                if (peticionCambio == 7){

                    break;
                }

                respuesta.peticion(peticionCambio);

                System.out.print("Digite la cantidad que desea convertir: ");
                cantidad = sc.nextDouble();

                obteniendoJson.digitarCantidad(cantidad);




            } while (peticionCambio <1 || peticionCambio >6);

    }
}
