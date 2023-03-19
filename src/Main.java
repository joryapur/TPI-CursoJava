import java.io.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
       LectorCSV lectorCSV = new LectorCSV();
       ArrayList<ArrayList<String>> resultados = LectorCSV.leer("src/resultados.csv");
       ArrayList<ArrayList<String>> pronostico = LectorCSV.leer("src/pronostico.csv");
       System.out.println(resultados.get(1).get(1));
       System.out.println(pronostico.get(1));

        }
}