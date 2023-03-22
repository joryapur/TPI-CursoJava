import java.io.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        LectorCSV lectorCSV = new LectorCSV();//Se crea un objeto de tipo LectorCSV para leer los archivos
        //Se leen los archivos que contienen los resultados y los pronosticos
        ArrayList<ArrayList<String>> resultados = LectorCSV.leer("src/resultados.csv");
        ArrayList<ArrayList<String>> pronosticos = LectorCSV.leer("src/pronostico.csv");
        //Se muestra en pantalla los datos leidos
        System.out.println(resultados.get(0)+"\n"+resultados.get(1)+"\n"+resultados.get(2)+"\n");
        System.out.println(pronosticos.get(0)+"\n"+pronosticos.get(1)+"\n"+pronosticos.get(2)+"\n");

        //Se genera un array de tipo Equipo para cargar todos los equipos participantes
        Equipo[] equipo= new Equipo[(resultados.size()-1)*2];
        int indice=0;
        for(int i=1;i< resultados.size();i++){
            for(int j=0;j< resultados.get(i).size();j++){
                if(j==0 || j==resultados.get(i).size()-1){
                    equipo[indice]=new Equipo(resultados.get(i).get(j).trim());
                    indice++;
                }
            }
        }
        //System.out.println(equipo[1].getNombre());
        //Se genera un array de tipo Partido para cargar los datos de los partidos
        Partido[] partido = new Partido[(resultados.size()-1)];
        for(int i=1;i < resultados.size();i++){
            partido[i-1]= new Partido(equipo[(i-1)*2],equipo[((i-1)*2)+1],Integer.parseInt(resultados.get(i).get(1).trim()),Integer.parseInt(resultados.get(i).get(2).trim()));
        }
        //System.out.println(partido[0].getGolesEquipo1()+" "+partido[0].getGolesEquipo2());

        //Se genera un array de tipo Pronostico para cargar los pronosticos de cada partido
        Pronostico[] pronostico = new Pronostico[pronosticos.size()-1];
        for(int i=1;i < pronosticos.size();i++){
            for(int j=1;j< pronosticos.get(i).size()-1;j++){
                if(pronosticos.get(i).get(j).trim().equals("X")){
                    switch(j){
                        case 1:
                            pronostico[i-1]=new Pronostico(partido[i-1],partido[i-1].getEquipo1(),ResultadoEnum.ganador);
                            break;
                        case 2:
                            pronostico[i-1]=new Pronostico(partido[i-1],partido[i-1].getEquipo1(),ResultadoEnum.empate);
                            break;
                        case 3:
                            pronostico[i-1]=new Pronostico(partido[i-1],partido[i-1].getEquipo1(),ResultadoEnum.perdedor);
                            break;
                    }
                }
            }
        }
        //Se obtiene el total de puntos obtenidos por el participante y se muestra en pantalla
        int puntostotal=0;
        for(int i=0;i < pronostico.length;i++){
            puntostotal=puntostotal+pronostico[i].puntos();
        }
        System.out.println("El participante obtuvo "+puntostotal+" puntos en total");

    }
}