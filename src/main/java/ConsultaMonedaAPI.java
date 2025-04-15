import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedaAPI {
    public  Moneda convertirMoneda(String divisa1,String divisa2,Double monto){
        String cadena = "https://v6.exchangerate-api.com/v6/da743706fa5920ee9d34bd30/pair/" +
                divisa1+"/"+divisa2+"/"+monto;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(cadena))
                .build();

        try{
            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(),Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("No se pudo convertir las monedas");
        }
    }
}
