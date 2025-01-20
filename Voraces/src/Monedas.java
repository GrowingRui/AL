import java.util.ArrayList;

public class Monedas {
    public static ArrayList<Moneda> numMonedasDesordenadas(ArrayList<Integer> valores,
                                             int cantidad){
        ArrayList<Moneda> sol = new ArrayList<>();
        int valor;
        while (cantidad > 0 && !valores.isEmpty()){
            valor = seleccionarCandidato(valores);
            valores.remove(Integer.valueOf(valor));
            if (cantidad/valor > 0){
                sol.add(new Moneda(valor,cantidad/valor));
                cantidad = cantidad % valor;
            }
        }
        if (cantidad == 0) return sol;
        else return null;
    }

    public static int seleccionarCandidato(ArrayList<Integer> valores){
        int mayor = Integer.MIN_VALUE;
        for (int i = 0; i < valores.size(); i++){
            if (mayor < valores.get(i)) mayor = valores.get(i);
        }
        return mayor;
    }
}
