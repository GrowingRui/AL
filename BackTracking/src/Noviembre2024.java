import java.util.Arrays;

public class Noviembre2024 {
    public static boolean[] teleferico(int[] pesos, int numP, int pMax){
        Booleano exito = new Booleano(false);
        boolean[] sol = new boolean[pesos.length];
        aux(pesos,numP,pMax,0,sol,0,0,exito);
        if (exito.getValor()) return sol;
        else return null;
    }

    public static void aux(int[] pesos, int numP, int pMax, int nivel, boolean[] sol,
                           int sumPesos, int sumaPersona, Booleano exito){
        if (nivel == pesos.length){
            if (sumaPersona == numP && sumPesos == pMax) exito.setValor(true);
        }else {
            int c = 0;
            while (!exito.getValor() && c < 2){
                if (c == 0 || sumPesos + pesos[nivel] <= pMax &&
                        sumaPersona < numP){
                    sol[nivel] = c != 0;
                    sumPesos = sumPesos + pesos[nivel]*c;
                    sumaPersona = sumaPersona + c;
                    nivel++;
                    aux(pesos,numP,pMax,nivel,sol,sumPesos,sumaPersona,exito);
                    if (!exito.getValor()){
                        nivel--;
                        sumaPersona = sumaPersona - c;
                        sumPesos = sumPesos - pesos[nivel]*c;
                        sol[nivel] = false;
                    }
                }
                c++;
            }
        }
    }

    public static void main(String[] args) {
        int[] pesos = new int[]{45,80,52,90,67,60,90,84,33,28};
        System.out.println(Arrays.toString(teleferico(pesos,4,320)));
    }
}
