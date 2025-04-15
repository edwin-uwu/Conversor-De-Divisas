import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.Console;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.NumberFormat;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner consola = new Scanner(System.in);
        HashMap<Integer,String> divisas = inicializarDivisas();
        ConsultaMonedaAPI consulta = new ConsultaMonedaAPI();

        int opcion=0;
        String divisa1=null,divisa2=null;
        double monto=0;



        while(true)
        {
            opcion =0;
            try{
                menu(opcion);
                opcion = Integer.parseInt(consola.nextLine());
                switch (opcion)
                {
                    case 1 -> divisa1 = divisas.get(opcion);
                    case 2 -> divisa1 = divisas.get(opcion);
                    case 3 -> divisa1 = divisas.get(opcion);
                    case 4 -> divisa1 = divisas.get(opcion);
                    case 5 -> divisa1 = divisas.get(opcion);
                    case 6 -> divisa1 = divisas.get(opcion);
                    case 7 -> divisa1 = divisas.get(opcion);
                    case 8 -> System.exit(0);
                    default -> System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 8");
                }

                menu(opcion);
                opcion = Integer.parseInt(consola.nextLine());
                switch (opcion)
                {
                    case 1 -> divisa2 = divisas.get(opcion);
                    case 2 -> divisa2 = divisas.get(opcion);
                    case 3 -> divisa2 = divisas.get(opcion);
                    case 4 -> divisa2 = divisas.get(opcion);
                    case 5 -> divisa2 = divisas.get(opcion);
                    case 6 -> divisa2 = divisas.get(opcion);
                    case 7 -> divisa2 = divisas.get(opcion);
                    case 8 -> System.exit(0);
                    default -> System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 8");
                }

                System.out.println("Ingresa la cantidad en "+divisa1+" para convertir en " + divisa2);
                monto = Double.parseDouble(consola.nextLine());

                Moneda conversion = consulta.convertirMoneda(divisa1,divisa2,monto);
                System.out.println("\n"+monto +" "+ conversion.base_code() +
                        " equivale a " + conversion.conversion_result() +" " +conversion.target_code());

            }catch (NumberFormatException e)
            {
                System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 8");
            }
            
            System.out.println("\n\nPresione cualquier tecla para continuar...");
            consola.nextLine();
        }
    }
    private static void menu(int opcion) {
        System.out.println("""
                    \tSeleccione el número de la divisa """+(opcion==0?"para convertir\n":"a convertir\n") +
                    (opcion != 1?"1- (ARS) Peso argentino\n":"")+
                    (opcion != 2?"2- (BOB) Boliviano boliviano\n":"")+
                    (opcion != 3?"3- (BRL) Real brasileño\n":"")+
                    (opcion != 4?"4- (CLP) Peso chileno\n":"")+
                    (opcion != 5?"5- (COP) Peso colombiano\n":"")+
                    (opcion != 6?"6- (USD) Dólar estadounidence\n":"")+
                    (opcion != 7?"7- (MXN) Peso méxicano\n":"")+
                    """
                    8- Salir
                    """);
    }
    private static HashMap<Integer,String> inicializarDivisas() {
        HashMap<Integer,String> divisas = new HashMap<>();
        divisas.put(1,"ARS");
        divisas.put(2,"BOB");
        divisas.put(3,"BRL");
        divisas.put(4,"CLP");
        divisas.put(5,"COP");
        divisas.put(6,"USD");
        divisas.put(7,"MXN");
        return divisas;
    }
}
