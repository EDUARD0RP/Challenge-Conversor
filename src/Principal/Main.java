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
                    Datos_De_Api Consulta_0 = new Datos_De_Api();
                    json =  Consulta_0.obtenerDatosApi("ARS");
                    Moneda moneda_0 = gson.fromJson(json, Moneda.class);
                    tasaDeCambio = moneda_0.conversion_rates().get("USD");

                    System.out.println("Ingrese la cantidad que desea convertir: ");
                    Scanner opcion_0 = new Scanner(System.in);
                    dineroACambiar = opcion_0.nextFloat();
                    System.out.println("\t\t Calculando Peso Argentino =>> Dólar...... \n");

                    System.out.println(           dineroACambiar +" [ARS] =>> = "
                            + Consulta_0.conversionDeMoneda(tasaDeCambio, dineroACambiar)
                            + " [USD].\n");

                    break;
                case 3:
                    Datos_De_Api Consulta_1 = new Datos_De_Api();
                    json =  Consulta_1.obtenerDatosApi("USD");
                    Moneda moneda_1 = gson.fromJson(json, Moneda.class);
                    tasaDeCambio = moneda_1.conversion_rates().get("BRL");

                    System.out.println("Ingrese la cantidad que desea convertir: ");
                    Scanner opcion_1 = new Scanner(System.in);
                    dineroACambiar = opcion_1.nextFloat();
                    System.out.println("\t\t Calculando Dólar =>> Real Brasileño...... \n");

                    System.out.println(           dineroACambiar +" [USD] =>> = "
                            + Consulta_1.conversionDeMoneda(tasaDeCambio, dineroACambiar)
                            + " [BRL].\n");

                    break;
                case 4:
                    Datos_De_Api Consulta_2 = new Datos_De_Api();
                    json =  Consulta_2.obtenerDatosApi("BRL");
                    Moneda moneda_2 = gson.fromJson(json, Moneda.class);
                    tasaDeCambio = moneda_2.conversion_rates().get("USD");

                    System.out.println("Ingrese la cantidad que desea convertir: ");
                    Scanner opcion_2 = new Scanner(System.in);
                    dineroACambiar = opcion_2.nextFloat();
                    System.out.println("\t\t Calculando Real Brasileño =>> Dólar...... \n");

                    System.out.println(           dineroACambiar +" [BRL] =>> = "
                            + Consulta_2.conversionDeMoneda(tasaDeCambio, dineroACambiar)
                            + " [USD].\n");

                    break;
                case 5:
                    Datos_De_Api Consulta_3 = new Datos_De_Api();
                    json =  Consulta_3.obtenerDatosApi("USD");
                    Moneda moneda_3 = gson.fromJson(json, Moneda.class);
                    tasaDeCambio = moneda_3.conversion_rates().get("COP");

                    System.out.println("Ingrese la cantidad que desea convertir: ");
                    Scanner opcion_3 = new Scanner(System.in);
                    dineroACambiar = opcion_3.nextFloat();
                    System.out.println("\t\t Calculando Dólar =>> Peso Colombiano...... \n");

                    System.out.println(           dineroACambiar +" [USD] =>> = "
                            + Consulta_3.conversionDeMoneda(tasaDeCambio, dineroACambiar)
                            + " [COP].\n");

                    break;
                case 6:
                    Datos_De_Api Consulta_4 = new Datos_De_Api();
                    json =  Consulta_4.obtenerDatosApi("COP");
                    Moneda moneda_4 = gson.fromJson(json, Moneda.class);
                    tasaDeCambio = moneda_4.conversion_rates().get("USD");

                    System.out.println("Ingrese la cantidad que desea convertir: ");
                    Scanner opcion_4 = new Scanner(System.in);
                    dineroACambiar = opcion_4.nextFloat();
                    System.out.println("\t\t Calculando Peso Colombiano =>> Dólar...... \n");

                    System.out.println(           dineroACambiar +" [COP] =>> = "
                            + Consulta_4.conversionDeMoneda(tasaDeCambio, dineroACambiar)
                            + " [USD].\n");

                    break;
                case 7:
                    System.out.println("\t\t !Gracias por usar Conversor de Divisas!");
                    break;
                default:
                    System.out.println("\t\t !Opcion no Valida!");

            }
        }while(option != 7);

    }
}