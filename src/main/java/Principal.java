import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.Console;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner consola = new Scanner(System.in);
        HashMap<Integer,String> divisas = new HashMap<>();
        divisas.put(1,"ARS");
        divisas.put(2,"BOB");
        divisas.put(3,"BRL");
        divisas.put(4,"CLP");
        divisas.put(5,"COP");
        divisas.put(6,"USD");

        int opcion=0;
        String divisa1=null,divisa2=null;
        double monto=0;



        while(true)
        {
            System.out.println("""
                    \tSeleccione el numero de la divisa para convertir
                    1- (ARS) Peso argentino
                    2- (BOB) Boliviano boliviano
                    3- (BRL) Real brasileño
                    4- (CLP) Peso chileno
                    5- (COP) Peso colombiano 
                    6- (USD) Dólar estadounidence 
                    7- Salir
                    """);
            opcion = Integer.parseInt(consola.nextLine());
            switch (opcion)
            {
                case 1 -> divisa1 = divisas.get(opcion);
                case 2 -> divisa1 = divisas.get(opcion);
                case 3 -> divisa1 = divisas.get(opcion);
                case 4 -> divisa1 = divisas.get(opcion);
                case 5 -> divisa1 = divisas.get(opcion);
                case 6 -> divisa1 = divisas.get(opcion);
                case 7 -> System.exit(0);
            }
            System.out.println("""
                    \tSeleccione el numero de la divisa a convertir
                    1- (ARS) Peso argentino
                    2- (BOB) Boliviano boliviano
                    3- (BRL) Real brasileño
                    4- (CLP) Peso chileno
                    5- (COP) Peso colombiano 
                    6- (USD) Dólar estadounidence 
                    7- Salir
                    """);
            opcion = Integer.parseInt(consola.nextLine());
            switch (opcion)
            {
                case 1 -> divisa2 = divisas.get(opcion);
                case 2 -> divisa2 = divisas.get(opcion);
                case 3 -> divisa2 = divisas.get(opcion);
                case 4 -> divisa2 = divisas.get(opcion);
                case 5 -> divisa2 = divisas.get(opcion);
                case 6 -> divisa2 = divisas.get(opcion);
                case 7 -> System.exit(0);
            }
            System.out.println("Ingresa la cantidad en "+divisa1+" para convertir en " + divisa2);
            monto = Double.parseDouble(consola.nextLine());

            String url = "https://v6.exchangerate-api.com/v6/da743706fa5920ee9d34bd30/pair/"+
                    divisa1+"/"+divisa2+"/"+monto;
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            //System.out.println(json);

            Gson gson =new GsonBuilder()
                    .create();

            Moneda conversion = gson.fromJson(json,Moneda.class);
            System.out.println(monto +" "+ conversion.base_code() +
                    " equivale a " + conversion.conversion_result() +" " +conversion.target_code());

            System.out.println(conversion);
        }


    }
    private static void menu()
    {

    }
}
