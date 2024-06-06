package Logica;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Respuesta {

    FormatoJson json = new FormatoJson();

    private int peticionCambio;
    protected String conversion;
    protected String deEste;
    protected String aEste;
    private String direccion;
    private String respuesta;

    public Respuesta(){

    }

    public void peticion(int peticionCambio){

        this.peticionCambio = peticionCambio;

        if(peticionCambio == 1){

            String deEste = "USD";
            String aEste = "ARS";

            this.deEste = deEste;
            this.aEste = aEste;
        } else if (peticionCambio == 2){

            String deEste = "ARS";
            String aEste = "USD";

            this.deEste = deEste;
            this.aEste = aEste;
        }else if (peticionCambio == 3){

            String deEste = "USD";
            String aEste = "BRL";

            this.deEste = deEste;
            this.aEste = aEste;
        }else if (peticionCambio == 4){

            String deEste = "BRL";
            String aEste = "USD";

            this.deEste = deEste;
            this.aEste = aEste;
        }else if (peticionCambio == 5){

            String deEste = "USD";
            String aEste = "CAD";

            this.deEste = deEste;
            this.aEste = aEste;
        }else if (peticionCambio == 6) {

            String deEste = "COL";
            String aEste = "CAD";

            this.deEste = deEste;
            this.aEste = aEste;
        } else if(peticionCambio == 7){

            System.out.println("Saliendo del programa...");
        } else {

            System.out.println("Colocar un numero valido");
        }

        String direccion = "https://v6.exchangerate-api.com/v6/de868905623042b63a23472a/pair/" + this.deEste + "/" + this.aEste;
        this.direccion = direccion;

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            this.respuesta = response.body();

        } catch (IOException | InterruptedException e){

            System.out.println("Error: " + e);
        }

    }


    public String getRespuesta(){

        return respuesta;
    }

    protected Respuesta(Record record){

        this.conversion = record.conversion_rate();
        this.deEste = record.base_code();
        this.aEste = record.target_code();
    }

    @Override
    public String toString() {
        return "La cantidad en " + deEste + "del monto: $" + json.getCantidad() + " convertido en " + aEste + " es de: $" + json.getTotal();
    }

}
