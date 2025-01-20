import java.util.Arrays;

public class CambioMoneda {
    public static int monetario(int[] valores, int cantidad){
        Entero valorM = new Entero(0);
        boolean[] solA = new boolean[valores.length];
        boolean[] solM = new boolean[valores.length];
        aux(valores,cantidad,0,0,valorM,solA,solM,0);
        System.out.println(Arrays.toString(solM));
        return valorM.getValor();
    }

    public static void aux(int[] valores, int cantidad, int nivel, int valorA,
                           Entero valorM, boolean[] solA, boolean[] solM, int cantA){
        if (nivel == valores.length){
            if (valorA < valorM.getValor()){
                valorM.setValor(valorA);
                for (int i = 0; i < solA.length; i++) solM[i] = solA[i];
            }
        }else {
            for (int i = 0; i <= cantidad/valores[nivel]; i++){
                if (i == 0 || cantA + valores[nivel] <= cantidad){
                    solA[nivel] = i != 0;
                    valorA = valorA + i;
                    cantA = cantA + valores[nivel]*i;
                    nivel++;
                    aux(valores,cantidad,nivel,valorA,valorM,solA,solM,cantA);
                    nivel--;
                    cantA = cantA - valores[nivel]*i;
                    valorA = valorA - i;
                    solA[nivel] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] monedas = new int[]{1,10,5};
        System.out.println(monetario(monedas,12));
    }
}
