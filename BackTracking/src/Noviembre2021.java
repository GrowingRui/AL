import java.util.Arrays;

public class Noviembre2021 {
    public static boolean[] subcSuma0MaxElem (int[] v){
        boolean[] solA = new boolean[v.length];
        boolean[] solM = new boolean[v.length];
        Entero valorM = new Entero(Integer.MAX_VALUE);
        int resta = 0;
        for (int i = 0; i < v.length; i++) resta = resta + v[i];
        subcSuma0MaxElem(v,0,solA,solM,0,valorM,resta,0);
        for (int i = 0; i < solM.length; i++) solM[i] = !solM[i];
        return solM;
    }
    public static void subcSuma0MaxElem (int[] v, int nivel, boolean[] solA, boolean[] solM,
                                         int valorA, Entero valorM, int resta, int suma){
        if (nivel == v.length){
            if (suma == resta && valorA < valorM.getValor()){
                valorM.setValor(valorA);
                for (int i = 0; i < solA.length; i++) solM[i] = solA[i];
            }
        }else {
            for (int i = 0; i < 2; i++){
                if (i == 0 || suma + v[nivel] <= resta){
                    solA[nivel] = i != 0;
                    valorA = valorA + i;
                    suma = suma + v[nivel]*i;
                    nivel++;
                    subcSuma0MaxElem(v,nivel,solA,solM,valorA,valorM,resta,suma);
                    nivel--;
                    suma = suma - v[nivel]*i;
                    valorA = valorA - i;
                    solA[nivel] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{-4,3,5,-5,0,1,8,10,-21};
        System.out.println(Arrays.toString(subcSuma0MaxElem(v1)));
    }

}
