import java.util.ArrayList;

public class Sesion1 {
    public static void distribuyeCarga(ArrayList<Producto> productos, ArrayList<Producto> n1,
                         ArrayList<Producto> n2, ArrayList<Producto> n3){
        Producto candidato;
        int peso1 = 0, peso2 = 0, peso3 = 0;
        while (!productos.isEmpty()){
            candidato = seleccionar(productos);
            productos.remove(candidato);
            if (peso1 <= peso2){
                if (peso1 <= peso3){
                    peso1 = peso1 + candidato.getPeso();
                    n1.add(candidato);
                }else {
                    peso3 = peso3 + candidato.getPeso();
                    n3.add(candidato);
                }
            } else if (peso2 <= peso3) {
                peso2 = peso2 + candidato.getPeso();
                n2.add(candidato);
            }else {
                peso3 = peso3 + candidato.getPeso();
                n3.add(candidato);
            }
        }
    }

    // same parts
    public static boolean distribuyeCarga2(ArrayList<Producto> productos){
        Producto candidato;
        int peso1 = 0, peso2 = 0, peso3 = 0;
        while (!productos.isEmpty()){
            candidato = seleccionar(productos);
            productos.remove(candidato);
            if (peso1 <= peso2){
                if (peso1 <= peso3){
                    peso1 = peso1 + candidato.getPeso();
                }else {
                    peso3 = peso3 + candidato.getPeso();
                }
            } else if (peso2 <= peso3) {
                peso2 = peso2 + candidato.getPeso();
            }else {
                peso3 = peso3 + candidato.getPeso();
            }
        }
        return peso1 == peso2 && peso2 == peso3;
    }

    public static Producto seleccionar(ArrayList<Producto> productos){
        Producto mejor = null;
        for (int i = 0; i < productos.size(); i++){
            if (mejor == null || mejor.getPeso() < productos.get(i).getPeso()) {
                mejor = productos.get(i);
            }
        }
        return mejor;
    }
}
