import java.util.Arrays;

public class Sesion3 {
    public static int maximoBeneficio1(int[] litros, int[] precioLitro,
                                      int[] gasto, int T){ // sin optimizar
        int[][] maxB = new int[litros.length][T+1];
        for (int i = 0; i<= T; i++){
            if (litros[0] > i) maxB[0][i] = 0;
            else maxB[0][i] = litros[0]*precioLitro[0]-gasto[0];
        }
        for (int i = 1; i < litros.length; i++){
            for (int j = 0; j <= T; j++){
                if (litros[i] > j) maxB[i][j] = maxB[i-1][j];
                else maxB[i][j] = Math.max(maxB[i-1][j],
                        (litros[i]*precioLitro[i]-gasto[i])+maxB[i-1][j-litros[i]]);
            }
        }
        for (int i = 0; i < maxB.length; i++){
            for (int j = 0; j < maxB[0].length; j++){
                System.out.print(maxB[i][j] + "("+j+")\t");
            }
            System.out.println();
        }
        return maxB[litros.length-1][T];
    }

    public static int maximoBeneficio2(int[] litros, int[] precioLitro,
                                      int[] gasto, int T){ // Optimizado
        int[][] maxB = new int[2][T+1];
        for (int i = 0; i<= T; i++){
            if (litros[0] > i) maxB[0][i] = 0;
            else maxB[0][i] = litros[0]*precioLitro[0]-gasto[0];
        }
        for (int i = 1; i < litros.length; i++){
            for (int j = 0; j <= T; j++){
                if (litros[i] > j) maxB[i%2][j] = maxB[(i-1)%2][j];
                else maxB[i%2][j] = Math.max(maxB[(i-1)%2][j],
                        (litros[i]*precioLitro[i]-gasto[i])+maxB[(i-1)%2][j-litros[i]]);
            }
        }
        return maxB[(litros.length-1)%2][T];
    }

    public static boolean[] maximoBeneficio3(int[] litros, int[] precioLitro,
                                       int[] gasto, int T){ // Optimizado y devolver [true,false,true,true,false]
        int[][] maxB = new int[2][T+1];
        boolean[][] x = new boolean[litros.length][T+1];
        for (int i = 0; i<= T; i++){
            if (litros[0] > i){
                maxB[0][i] = 0;
                x[0][i] = false;
            } else {
                maxB[0][i] = litros[0]*precioLitro[0]-gasto[0];
                x[0][i] = true;
            }
        }
        for (int i = 1; i < litros.length; i++){
            for (int j = 0; j <= T; j++){
                if (litros[i] > j){
                    maxB[i%2][j] = maxB[(i-1)%2][j];
                    x[i][j] = false;
                } else {
                    maxB[i%2][j] = Math.max(maxB[(i-1)%2][j],
                            (litros[i]*precioLitro[i]-gasto[i])+maxB[(i-1)%2][j-litros[i]]);
                    x[i][j] = !(maxB[i%2][j] == maxB[(i-1)%2][j]);
                }
            }
        }
        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < x[0].length; j++){
                System.out.print(x[i][j] + "("+j+")\t");
            }
            System.out.println();
        }
        return aux(x,litros);
    }

    public static boolean[] aux(boolean[][] x, int[] litros){
        boolean[] sol = new boolean[litros.length];
        int l = x[0].length-1;
        for (int i = litros.length; i > 0; i--){
            sol[i-1] = x[i-1][l];
            if (x[i-1][l]) l = l - litros[i-1];
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] litros = new int[]{30,128,110,5,22};
        int[] precioLitro = new int[]{5,9,10,3,5};
        int[] gasto = new int[]{6,50,5,12,15};
        System.out.println(Arrays.toString( maximoBeneficio3(litros,precioLitro,gasto,155)));
    }
}
