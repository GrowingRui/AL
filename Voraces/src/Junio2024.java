import java.util.ArrayList;

public class Junio2024 {
    public static ArrayList<Inversion> invertir(ArrayList<Proyecto> proyectos, float P){
        ArrayList<Inversion> sol = new ArrayList<>();
        Proyecto candidato;
        while (!proyectos.isEmpty() && P > 0){
            candidato = seleccionar(proyectos);
            proyectos.remove(candidato);
            float invertido = candidato.getCoste();
            if (P < invertido) invertido = P;
            sol.add(new Inversion(candidato.getNombre(), invertido));
            P = P - invertido;
        }
        if (!sol.isEmpty()) return sol;
        else return null;
    }

    public static Proyecto seleccionar(ArrayList<Proyecto> proyectos){
        Proyecto mejor = null;
        for (int i = 0; i < proyectos.size(); i++){
            if (mejor == null || getBeneficio(mejor) < getBeneficio(proyectos.get(i))){
                mejor = proyectos.get(i);
            }
        }
        return mejor;
    }

    public static float getBeneficio(Proyecto proyecto){
        return proyecto.getRetorno() / proyecto.getCoste();
    }
}
