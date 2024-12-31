package Principal;

import Modelos.Moneda;
import Redes.Datos_De_Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner eleccion = new Scanner(System.in);
        var option= 0;
        double tasaDeCambio;
        float dineroACambiar;
        String json;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        do{
            System.out.println("************************************************************");
            System.out.println("Sea bienveinido/a al Conversor de Monedas =) \n");
            System.out.println(" 1) Dólar =>> Peso Argentino");
            System.out.println(" 2) Peso Argentino =>> Dólar");
            System.out.println(" 3) Dólar =>> Real Brasileño");
            System.out.println(" 4) Real Brasileño =>> Dólar");
            System.out.println(" 5) Dólar =>> Peso Colombiano");
            System.out.println(" 6) Peso Colombiano =>> Dólar");
            System.out.println(" 7) Salir");
            System.out.println("Eliga una opcion valida:");
            option = Integer.parseInt(eleccion.nextLine());
            System.out.println("************************************************************");

            switch (option){
                case 1:
                    Datos_De_Api Consulta = new Datos_De_Api();
                    json =  Consulta.obtenerDatosApi("USD");
                    Moneda moneda = gson.fromJson(json, Moneda.class);
                    tasaDeCambio = moneda.conversion_rates().get("ARS");

                    System.out.println("Ingrese la cantidad que desea convertir: ");
                    Scanner opcion1 = new Scanner(System.in);
                    dineroACambiar = opcion1.nextFloat();
                    System.out.println("\t\t Calculando Dólar =>> Peso Argentino...... \n");

                    System.out.println(           dineroACambiar +" [USD] =>> = "
                            + Consulta.conversionDeMoneda(tasaDeCambio, dineroACambiar)
                            + " [ARS].\n");
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:


            }
        }while(option != 7);

    }
}