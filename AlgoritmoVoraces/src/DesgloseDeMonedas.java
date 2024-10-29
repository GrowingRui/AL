import java.util.ArrayList;

public class DesgloseDeMonedas {
    public static int seleccionarCandidatoListaDesordenada(ArrayList<Integer> valores){
        int mayor = Integer.MIN_VALUE;
        for (int i = 0; i < valores.size(); i++){
            if (mayor < valores.get(i)){
                mayor = valores.get(i);
            }
        }
        return mayor;
    }

    public static ArrayList<Moneda> numMonedasDesordenadas(ArrayList<Integer> valores,
                                             int cantidad){
        ArrayList<Moneda> sol = new ArrayList<Moneda>();
        int valor;
        while ((cantidad > 0) && !valores.isEmpty()){
            valor = seleccionarCandidatoListaDesordenada(valores);
           // valores.remove(new Integer(valor));
            if (cantidad/valor > 0){
                sol.add(new Moneda(valor,cantidad/valor));
                cantidad = cantidad % valor;
            }
        }
        if (cantidad == 0){
            return sol;
        }else {
            return null;
        }
    }
}
