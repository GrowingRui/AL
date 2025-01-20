public class Enero2023 {
    public static int maxSubArrayPositivos(int[] vector){
        return aux(vector,0,vector.length-1);
    }

    public static int aux(int[] vector, int i0, int iN){
        if (i0 == iN){
            if (vector[i0] >= 0) return 0;
            else return vector[i0];
        }else {
            int k = (i0+iN)/2;
            int izq = aux(vector,i0,k);
            int der = aux(vector,k+1,iN);
            int media = media(vector,i0,iN,k);
            return Math.max(izq,Math.max(der,media));
        }
    }

    // mi implementacion
    public static int media(int[] vector, int i0, int iN, int k){
        int suma = 0;
        int i = k, j = k+1;
        while (i >= i0 && vector[i] > 0){
            suma = suma + vector[i];
            i--;
        }
        while (j <= iN && vector[j] > 0){
            suma = suma + vector[j];
            j++;
        }
        return suma;
    }

    // implementacion solucion
    int maxSubArrayCentral(int[] v, int i0, int k, int iN){
        // Este método tiene complejidad O(N)
        int m = 0;
        if (v[k]<0) return 0;
        else{
            int i=k;
            while ((i>=i0) && (v[i]>0)){
                m = m + v[i];
                i--;
            }
            i=k+1;
            while ((i<=iN) && v[i]>0){
                m=m+v[i];
                i++;
            }
            return m;
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{-2,5,1,-3,-2,4,7,-1,9};
        System.out.println(maxSubArrayPositivos(v1));
    }
}
