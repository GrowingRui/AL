import java.util.ArrayList;

public class PlanificacionTareas {
     private static Actividad seleccionarCandidatoListaDesordenada(
            ArrayList<Actividad> candidatos){
          Actividad sol = null;
          //Actividad sol = candidatos.getFirst();
          for (int i = 0; i < candidatos.size(); i++){
               if (sol == null || sol.getFin() > candidatos.get(i).getFin()){
                    sol = candidatos.get(i);
               }
          }
          return sol;
     }

     private static boolean esFactibleCandidato(Actividad candidato,
                                         ArrayList<Actividad> solucion){
          boolean sol = true;
          if (!solucion.isEmpty()){
               if (solucion.getLast().getFin() > candidato.getInicio()){
                    sol = false;
               }
          }
          return sol;
     }

     public static ArrayList<Actividad> algoritmoVoraz(
             ArrayList<Actividad> candidatos){
          ArrayList<Actividad> sol = new ArrayList<>();
          Actividad actividad;
          while (!candidatos.isEmpty()){
               actividad = seleccionarCandidatoListaDesordenada(candidatos);
               candidatos.remove(actividad);
               if (esFactibleCandidato(actividad,sol)) sol.add(actividad);
          }
          if (!sol.isEmpty()){
               return sol;
          }else {
               return null;
          }
     }
}
