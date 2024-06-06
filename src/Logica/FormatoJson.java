package Logica;

import com.google.gson.Gson;

public class FormatoJson {

    Respuesta respuestaHttp;

    private double cantidad;
    private double total;
    private double conversion;
    private String loQuiero;
    private String loObtengo;

    public void digitarCantidad(double cantidad){

        formatoJson();

        this.cantidad = cantidad;

        double total = conversion * cantidad;
        this.total = total;

    }


    private void formatoJson(){

        Gson gson = new Gson();
        Record conversionRecord = gson.fromJson(respuestaHttp.getRespuesta(), Record.class);
        respuestaHttp = new Respuesta(conversionRecord);

        double conversion = Double.parseDouble(conversionRecord.conversion_rate());
        this.conversion = conversion;


    }

    public double getTotal() {
        return total;
    }

    public double getCantidad() {
        return cantidad;
    }
}
