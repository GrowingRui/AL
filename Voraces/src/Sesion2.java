import java.util.ArrayList;

public class Sesion2 {
    public static ArrayList<Grupo> mezclaEstudiantes(ArrayList<Estudiante> listaEst,
                                       int numMaxAlumnos){
        ArrayList<Grupo> sol = new ArrayList<>();
        Estudiante candidato;
        boolean x = false;
        if (numMaxAlumnos >= listaEst.size()){
            sol.add(new Grupo(listaEst,numMaxAlumnos));
        }else {
            while (!listaEst.isEmpty()){
                if (!x) candidato = seleccionarMejor(listaEst);
                else candidato = seleccionarPeor(listaEst);
                listaEst.remove(candidato);
                aniadir(candidato,sol,numMaxAlumnos);
                x = !x;
            }
        }
        return sol;
    }

    public static void aniadir(Estudiante est, ArrayList<Grupo> grupos,
                               int maxAlumnos){
        boolean x = false;
        Grupo g;
        if (!grupos.isEmpty()){
            g = grupos.getLast();
            if (g.getAlumnosRestantes() > 0){
                g.aniadeAlumno(est);
                x = true;
            }
        }
        if (!x){
            g = new Grupo(maxAlumnos);
            g.aniadeAlumno(est);
            grupos.add(g);
        }
    }

    public static Estudiante seleccionarMejor(ArrayList<Estudiante> listaEst){
        Estudiante mejor = null;
        for (int i = 0; i < listaEst.size(); i++){
            if (mejor == null || mejor.getNota() < listaEst.get(i).getNota()){
                mejor = listaEst.get(i);
            }
        }
        return mejor;
    }

    public static Estudiante seleccionarPeor(ArrayList<Estudiante> listaEst){
        Estudiante peor = null;
        for (int i = 0; i < listaEst.size(); i++){
            if (peor == null || peor.getNota() > listaEst.get(i).getNota()){
                peor = listaEst.get(i);
            }
        }
        return peor;
    }
}
