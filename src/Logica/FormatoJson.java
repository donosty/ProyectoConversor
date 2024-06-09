package Logica;

import com.google.gson.Gson;

public class FormatoJson {

    private Respuesta respuestaHttp;

    private double cantidad;
    private double total;
    private double conversion;
    private String ingresado;
    private String obtenido;


    public FormatoJson(Respuesta otraRespuesta){

        this.respuestaHttp = otraRespuesta;
        formatoJson();

    }

    public void digitarCantidad(double cantidad){

        this.cantidad = cantidad;

        double total = conversion * cantidad;
        this.total = total;

    }

    public FormatoJson(Record record){

        this.ingresado = record.base_code();
        this.obtenido = record.target_code();
    }

    public void formatoJson(){

        try {

            Gson gson = new Gson();
            Record conversionRecord = gson.fromJson(respuestaHttp.getRespuesta(), Record.class);
            FormatoJson formato = new FormatoJson(conversionRecord);
            this.conversion = Double.parseDouble(conversionRecord.conversion_rate());
            this.ingresado = String.format(conversionRecord.base_code());
            this.obtenido = String.format(conversionRecord.target_code());

        } catch (NullPointerException e){

            System.out.println("Error: " + e);
        }
    }


    public void mostrarDatos(){

        System.out.println("La conversion de [" + ingresado + "] del monto $" + cantidad + " a [" + obtenido + "] es de $" + total);
    }
}
