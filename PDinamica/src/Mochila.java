public class Mochila {
    // Basico
    public int maxValor(int[] pesos, int[] valores, int maxPeso){
        int[][] cant = new int[pesos.length][maxPeso+1];
        for (int c = 0; c <= maxPeso; c++){
            if (c < pesos[0]) cant[0][c] = 0;
            else cant[0][c] = valores[0];
        }
        for (int i = 1; i < valores.length; i++){
            for (int c = 1; c <= maxPeso; c++){
                if (c < pesos[i]) cant[i][c] = cant[i-1][c];
                else cant[i][c] = Math.max(cant[i-1][c],valores[i]+cant[i-1][c-valores[i]]);
            }
        }
        return cant[pesos.length-1][maxPeso];
    }

    // Optimizado
    public int maxValor2(int[] pesos, int[] valores, int maxPeso){
        int[][] cant = new int[2][maxPeso+1];
        for (int c = 0; c <= maxPeso; c++){
            if (c < pesos[0]) cant[0][c] = 0;
            else cant[0][c] = valores[0];
        }
        for (int i = 1; i < valores.length; i++){
            for (int c = 1; c <= maxPeso; c++){
                if (c < pesos[i]) cant[i%2][c] = cant[(i-1)%2][c];
                else cant[i%2][c] = Math.max(cant[(i-1)%2][c],valores[i]+cant[(i-1)%2][c-valores[i]]);
            }
        }
        return cant[(pesos.length-1)%2][maxPeso];
    }

    // Optimizado avanzado: que elementos?
    public boolean[] maxValor3(int[] pesos, int[] valores, int maxPeso){
        int[][] cant = new int[2][maxPeso+1];
        boolean[][] aux = new boolean[pesos.length][maxPeso+1];
        for (int c = 0; c <= maxPeso; c++){
            if (c < pesos[0]){
                cant[0][c] = 0;
                aux[0][c] = false;
            } else {
                cant[0][c] = valores[0];
                aux[0][c] = true;
            }
        }
        for (int i = 1; i < valores.length; i++){
            for (int c = 1; c <= maxPeso; c++){
                if (c < pesos[i]){
                    cant[i%2][c] = cant[(i-1)%2][c];
                    aux[i][c] = false;
                } else {
                    cant[i%2][c] = Math.max(cant[(i-1)%2][c],valores[i]+cant[(i-1)%2][c-valores[i]]);
                    aux[i][c] = cant[i%2][c] == valores[i]+cant[(i-1)%2][c-valores[i]];
                }
            }
        }
        return elementosIntroducidos(aux,pesos);
    }

    public boolean[] elementosIntroducidos(boolean[][] aux, int[] pesos){
        int c = aux[0].length-1;
        boolean[] sol = new boolean[pesos.length];
        for (int i = pesos.length-1; i >= 0; i--){
            sol[i] = aux[i][c];
            if (aux[i][c]) c = c - pesos[i];
        }
        return sol;
    }
}
