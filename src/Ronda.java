import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private String nro;
    private List<Pronostico> pronosticos;
    private List<Partido> partidos;

    public Ronda(String nro){
        this.nro=nro;
        pronosticos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public void argegarPartidos(Partido partido){
        partidos.add(partido);
    }
    public void agregarPronostico(Pronostico pronostico){
        pronosticos.add(pronostico);
    }
    public int puntos(){
        int puntos=0;
        for(Pronostico pronostico : pronosticos){
            puntos = puntos + pronostico.puntos();
        }
        return puntos;
    }
}