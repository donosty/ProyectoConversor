package Logica;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Respuesta {

    protected String deEste;
    protected String aEste;
    private String direccion;
    private String respuesta;

    public void peticion(int peticionCambio){

        if(peticionCambio == 1){

            this.deEste = "USD";
            this.aEste = "ARS";
        } else if (peticionCambio == 2){

            this.deEste = "ARS";
            this.aEste = "USD";
        }else if (peticionCambio == 3){

            this.deEste = "USD";
            this.aEste = "BRL";
        }else if (peticionCambio == 4){

            this.deEste = "BRL";
            this.aEste = "USD";
        }else if (peticionCambio == 5){

            this.deEste = "USD";
            this.aEste = "CAD";
        }else if (peticionCambio == 6) {

            this.deEste = "CAD";
            this.aEste = "USD";
        }

        this.direccion = "https://v6.exchangerate-api.com/v6/de868905623042b63a23472a/pair/" + this.deEste + "/" + this.aEste;

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
}
