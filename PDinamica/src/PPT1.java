public class PPT1 {
    // Basico
    public static int numMonedas(int[] valores, int cantidad){
        int[][] cant = new int[valores.length+1][cantidad+1];
        for (int i = 0; i <= cantidad; i++) cant[0][i] = Integer.MAX_VALUE;
        for (int i = 0; i <= valores.length; i++) cant[i][0] = 0;
        for (int i = 1; i <= valores.length; i++){
            for (int j = 1; j <= cantidad; j++){
                if (j < valores[i-1]) cant[i][j] = cant[i-1][j];
                else cant[i][j] = Math.min(cant[i-1][j],1+cant[i][j-valores[i-1]]);
            }
        }
        return cant[valores.length][cantidad];
    }

    // Optimizado
    public static int numMonedas2(int[] valores, int cantidad){
        int[][] cant = new int[2][cantidad+1];
        for (int i = 0; i <= cantidad; i++) cant[0][i] = Integer.MAX_VALUE;
        for (int i = 0; i <= 1; i++) cant[i][0] = 0;
        for (int i = 1; i <= valores.length; i++){
            for (int j = 1; j <= cantidad; j++){
                if (j < valores[i-1]) cant[i%2][j] = cant[(i-1)%2][j];
                else cant[i%2][j] = Math.min(cant[(i-1)%2][j],1+cant[i%2][j-valores[i-1]]);
            }
        }
        return cant[valores.length%2][cantidad];
    }

    // Optimizado avanzado
    public static int[] numMonedas3(int[] valores, int cantidad){
        int[][] cant = new int[2][cantidad+1];
        boolean[][] aux = new boolean[valores.length+1][cantidad+1];
        for (int i = 0; i <= cantidad; i++){
            cant[0][i] = Integer.MAX_VALUE;
            aux[0][i] = false;
        }
        cant[0][0] = 0; cant[1][0] = 0;
        for (int i = 0; i <= valores.length; i++) aux[i][0] = false;
        for (int i = 1; i <= valores.length; i++){
            for (int j = 1; j <= cantidad; j++){
                if (j < valores[i-1]){
                    cant[i%2][j] = cant[(i-1)%2][j];
                    aux[i][j] = false;
                } else {
                    cant[i%2][j] = Math.min(cant[(i-1)%2][j],1+cant[i%2][j-valores[i-1]]);
                    aux[i][j] = cant[i%2][j] == 1+cant[i%2][j-valores[i-1]];
                }
            }
        }
        return entrega(aux,valores);
    }

    public static int[] entrega(boolean[][] aux, int[] valores){
        int i = valores.length;
        int c = aux[0].length-1;
        int[] decision = new int[valores.length];
        decision[i-1] = 0;
        while (c > 0 && i > 0){
            if (aux[i][c]){
                c = c - valores[i-1];
                decision[i-1]++;
            }else {
                i--;
                decision[i-1] = 0;
            }
        }
        return decision;
    }
}
