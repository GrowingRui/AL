import java.util.ArrayList;

public class Sesion4 {
    public static ArrayList<Contenedor> rescate(ArrayList<Contenedor> contenedores, int hundir){
        ArrayList<Contenedor> sol = new ArrayList<>();
        Contenedor candidato;
        while (!contenedores.isEmpty() && hundir != 0){
            candidato = seleccionar(contenedores);
            contenedores.remove(candidato);
            if (candidato.getTiempo() <= hundir){
                sol.add(candidato);
                hundir = hundir - candidato.getTiempo();
            }
        }
        if (!sol.isEmpty()) return sol;
        else return null;
    }

    public static Contenedor seleccionar(ArrayList<Contenedor> contenedores){
        Contenedor mejor = null;
        for (int i = 0; i < contenedores.size(); i++){
            if (mejor == null || getBeneficio(mejor) < getBeneficio(contenedores.get(i))){
                mejor = contenedores.get(i);
            }
        }
        return mejor;
    }

    public static double getBeneficio(Contenedor contenedor){
        return (double) contenedor.getDias() /contenedor.getTiempo();
    }
}
