import java.util.Arrays;

public class Sesion3 {
    public static int maxUsoRecurso(int[] comienzo, int[] fin){
        boolean[] solA = new boolean[comienzo.length];
        boolean[] solM = new boolean[comienzo.length];
        Entero valorM = new Entero(0);
        aux(comienzo,fin,0,solA,solM,0,valorM);
        System.out.println(Arrays.toString(solM));
        return valorM.getValor();
    }

    public static void aux(int[] comienzo, int[] fin, int nivel, boolean[] solA,
                           boolean[] solM, int valorA, Entero valorM){
        if (nivel == comienzo.length){
            if (valorA > valorM.getValor()){
                valorM.setValor(valorA);
                for (int i = 0; i < solA.length; i++) solM[i] = solA[i];
            }
        }else {
            for (int i = 0; i < 2; i++){
                if (i == 0 || aceptable(solA,comienzo,fin,nivel)){
                    solA[nivel] = i != 0;
                    valorA = valorA + (fin[nivel]-comienzo[nivel])*i;
                    nivel++;
                    aux(comienzo,fin,nivel,solA,solM,valorA,valorM);
                    nivel--;
                    valorA = valorA - (fin[nivel]-comienzo[nivel])*i;
                    solA[nivel] = false;
                }
            }
        }
    }

    public static boolean aceptable(boolean[] sol,int[] comienzo, int[] fin,
                                    int nivel){
        boolean x = true;
        for (int i = 0; i < sol.length && x; i++){
            if (sol[i]){
                x = fin[nivel] <= comienzo[i] || comienzo[nivel] >= fin[i];
            }
        }
        return x;
    }


    public static void main(String[] args) {
         int[] comienzo = new int[]{5,2,4,2,6,0,6,2};
        int[] fin = new int[]{9,4,5,5,7,3,8,5};

        System.out.println(maxUsoRecurso(comienzo,fin));
    }
}
