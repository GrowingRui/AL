import java.util.ArrayList;

public class Sesion1 {
    public static Producto selectProduct(ArrayList<Producto> productos){
        // we are looking for the heaviest weight
        Producto sol = null;
        for (int i = 0; i < productos.size(); i++){
            if (sol == null || sol.getPeso() < productos.get(i).getPeso()){
                sol = productos.get(i);
            }
        }
        return sol;
    }

    public static void distribuyeCarga(ArrayList<Producto> productos,
                                       ArrayList<Producto> n1,
                                       ArrayList<Producto> n2, ArrayList<Producto> n3){
        Producto candidato;
        int peso1 = 0, peso2 = 0, peso3 = 0;
        while (!productos.isEmpty()){
            candidato = selectProduct(productos);
            productos.remove(candidato);
            if (peso1 <= peso2 && peso1 <= peso3){
                peso1 = peso1 + candidato.getPeso();
                n1.add(candidato);
            } else if (peso2 <= peso1 && peso2 <= peso3) {
                peso2 = peso2 + candidato.getPeso();
                n2.add(candidato);
            }else {
                peso3 = peso3 + candidato.getPeso();
                n3.add(candidato);
            }
        }
    }

    public static boolean distribuyeCarga2(ArrayList<Producto> productos){
        Producto candidato;
        int peso1 = 0, peso2 = 0, peso3 = 0;
        while (!productos.isEmpty()){
            candidato = selectProduct(productos);
            productos.remove(candidato);
            if (peso1 <= peso2 && peso1 <= peso3){
                peso1 = peso1 + candidato.getPeso();
            } else if (peso2 <= peso1 && peso2 <= peso3) {
                peso2 = peso2 + candidato.getPeso();
            }else {
                peso3 = peso3 + candidato.getPeso();
            }
        }
        return peso1 == peso2 && peso2 == peso3;
    }
}
