import java.util.ArrayList;
import java.util.Arrays;

public class Diciembre2023 {
    public static ArrayList<Integer> estacionesMinimo(boolean[][] grafo){
        ArrayList<Integer> sol = new ArrayList<>();
        boolean[] visitados = new boolean[grafo.length];
        int candidato;
        while (!TodoVisitados(visitados)){
            candidato = seleccionar(grafo,visitados);
            sol.add(candidato);
            marcarVisitados(visitados,candidato,grafo);
        }
        if (!sol.isEmpty()) return sol;
        else return null;
    }

    public static void marcarVisitados(boolean[] visitados, int c, boolean[][] grafo){
        for (int i = 0; i < grafo.length; i++){
            if (i != c && grafo[c][i]) visitados[i] = true;
        }
    }

    public static boolean TodoVisitados(boolean[] x){
        for (int i = 0 ; i < x.length; i++){
            if (!x[i]) return false;
        }
        return true;
    }

    public static int seleccionar(boolean[][] grafo, boolean[] visitados){
        int mejor = 0;
        int num = 0;
        int indice = -1;
        for (int i = 0; i < visitados.length; i++){
            if (!visitados[i]){
                for (int j = 0; j < grafo.length; j++){
                    if (i != j && grafo[i][j]) num++;
                }
            }
            if (mejor < num){
                mejor = num;
                indice = i;
            }
        }
        if (indice != -1) visitados[indice] = true;
        return indice;
    }

    public static void main(String[] args) {
        boolean[][] grafo = new boolean[][]{
                {false,true,true,false,false,false,false,false,false},
                {true,false,false,false,false,true,false,false,false},
                {true,false,false,true,true,false,false,false,false},
                {false,false,true,false,false,false,true,true,false},
                {false,false,true,false,false,false,false,false,false},
                {false,true,false,false,false,false,false,false,false},
                {false,false,false,true,false,false,false,true,true},
                {false,false,false,true,false,false,true,false,true},
                {false,false,false,false,false,false,true,true,false},
        };
        ArrayList<Integer> sol = estacionesMinimo(grafo);
        System.out.println(Arrays.toString(new ArrayList[]{sol}));
    }
}
