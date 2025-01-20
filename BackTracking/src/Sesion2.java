import java.util.Arrays;

public class Sesion2 {
    public static boolean dosSubconjuntos(int[] v, int vObjetivo){
        int[] sol = new int[v.length];
        Booleano exito = new Booleano(false);
        aux(v,vObjetivo,0,sol,0,0,exito);
        System.out.println(Arrays.toString(sol));
        return exito.getValor();
    }

    public static void aux(int[] v, int vObjetivo, int nivel, int[] sol,
                           int sumaA, int sumaB, Booleano exito){
        if (nivel == v.length){
            if (sumaA == vObjetivo && sumaB == vObjetivo) exito.setValor(true);
        }else {
            int c = 0;
            while (c < 3 && !exito.getValor()){
                if (c == 0 || ((c == 1 && (sumaA + v[nivel] <= vObjetivo)) ||
                        (c == 2 && (sumaB + v[nivel] <= vObjetivo))) && aceptable(v,sol,v[nivel],c)){
                    sol[nivel] = c;
                    if (c == 1) sumaA = sumaA + v[nivel];
                    else if (c == 2) sumaB = sumaB + v[nivel];
                    nivel++;
                    aux(v,vObjetivo,nivel,sol,sumaA,sumaB,exito);
                    if (!exito.getValor()){
                        nivel--;
                        if (c == 1) sumaA = sumaA - v[nivel];
                        else if (c == 2) sumaB = sumaB - v[nivel];
                        sol[nivel] = 0;
                    }
                }
                c++;
            }
        }
    }

    public static boolean aceptable(int[] v, int[] sol, int valor, int c){
        for (int i = 0; i < sol.length; i++){
            if (sol[i] == c && v[i] == valor) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] v1 = new int[]{4,2,5,5,1,8};
        System.out.println(dosSubconjuntos(v1,10));
    }
}
