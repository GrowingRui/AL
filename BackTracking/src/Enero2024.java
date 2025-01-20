import java.util.Arrays;

public class Enero2024 {
    public static int[] equipos(int[] habilidad, int k){
        Entero valorM = new Entero(Integer.MAX_VALUE);
        int[] solA = new int[habilidad.length];
        int[] solM = new int[habilidad.length];
        int[] suma = new int[k];
        aux(habilidad,k,0,0,valorM,solA,solM,suma);
        return solM;
    }

    public static void aux(int[] habilidad, int k, int nivel, int valorA, Entero valorM,
                           int[] solA, int[] solM, int[] suma){
        if (nivel == habilidad.length){
            valorA = diferencia(suma);
            if (valorA < valorM.getValor()){
                valorM.setValor(valorA);
                for (int i = 0; i < solA.length; i++) solM[i] = solA[i];
            }
        }else {
            for (int i = 0; i < k; i++){
                suma[i] = suma[i] + habilidad[nivel];
                solA[nivel] = i;
                nivel++;
                aux(habilidad,k,nivel,valorA,valorM,solA,solM,suma);
                nivel--;
                suma[i] = suma[i] - habilidad[nivel];
                solA[nivel] = 0;
            }
        }
    }

    public static int diferencia(int[] suma){
        int min = suma[0];
        int max = suma[0];
        for (int i = 1; i < suma.length; i++){
            if (min > suma[i]) min = suma[i];
        }
        for (int i = 1; i < suma.length; i++){
            if (max < suma[i]) max = suma[i];
        }
        return max-min;
    }

    public static void main(String[] args) {
        int[] habilidades = new int[]{12,5,8,9,3,10,15,4,20,7};
        System.out.println(Arrays.toString(equipos(habilidades,4)));
    }
}
