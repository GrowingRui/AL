import java.util.ArrayList;

public class Mochila {
    private static Objeto seleccionarCandidatoListaDesordenada(ArrayList<Objeto> objetos){
        Objeto sol = null;
        //Objeto sol = objetos.getFirst();
        for (int i = 0; i < objetos.size(); i++){
            if (sol == null || sol.getBeneficio() < objetos.get(i).getBeneficio()){
                sol = objetos.get(i);
            }
        }
        return sol;
    }

    public static ArrayList<Objeto> algoritmoVoraz (ArrayList<Objeto> candidatos,
                                             int peso){
        ArrayList<Objeto> sol = new ArrayList<>();
        Objeto candidato;
        while ((!candidatos.isEmpty()) && peso > 0){
            candidato = seleccionarCandidatoListaDesordenada(candidatos);
            candidatos.remove(candidato);
            if (peso >= candidato.getPeso()){
                sol.add(candidato);
                peso = peso - candidato.getPeso();
            }
        }
        if (!sol.isEmpty()){
            return sol;
        }else {
            return null;
        }
    }
}
