import java.util.Arrays;

public class Sesion4 {
    public static int distribucionCarga2 (int[] pesos, int pMax){
        Entero valorM = new Entero(Integer.MAX_VALUE);
        int[] solA = new int[pesos.length];
        int[] solM = new int[pesos.length];
        aux(pesos,pMax,0,0,valorM,solA,solM,0,0);
        System.out.println(Arrays.toString(solM));
        return valorM.getValor();
    }

    public static void aux (int[] pesos, int pMax, int nivel, int valorA, Entero valorM,
                            int[] solA, int[] solM, int suma1, int suma2){
        if (nivel == pesos.length){
            valorA = Math.abs(suma1-suma2);
            if (valorA < valorM.getValor()){
                valorM.setValor(valorA);
                for (int i = 0; i < solA.length; i++) solM[i] = solA[i];
            }
        }else {
            for (int i = 0; i < 2; i++){
                if ((i == 0 && suma1 + pesos[nivel] <= pMax) ||
                        (i == 1 && suma2 + pesos[nivel] <= pMax)){
                    solA[nivel] = i+1;
                    if (i == 0) suma1 = suma1 + pesos[nivel];
                    if (i == 1) suma2 = suma2 + pesos[nivel];
                    nivel++;
                    aux(pesos,pMax,nivel,valorA,valorM,solA,solM,suma1,suma2);
                    nivel--;
                    if (i == 0) suma1 = suma1 - pesos[nivel];
                    if (i == 1) suma2 = suma2 - pesos[nivel];
                    solA[nivel] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] pesos = new int[]{1,3,2,5,1,4,2,1};
        System.out.println(distribucionCarga2(pesos,10));
    }
}
