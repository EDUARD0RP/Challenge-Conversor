package Redes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Datos_De_Api {

    public String obtenerDatosApi(String monedaConsultada) {
        String jsonSolicitado;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/7c504782dd2702001d4ff440/latest/"+
                        monedaConsultada))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonSolicitado = response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error inesperado");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return jsonSolicitado;
    }

    public float conversionDeMoneda(double tasaDeCambio, float dineroACambiar) {
        return (float) tasaDeCambio * dineroACambiar;
    }
}
