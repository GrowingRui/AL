public class Noviembre2021 {
    public static int longMaxSubArrayOrdenado(int[] vector){
        return aux(vector,0,vector.length-1);
    }

    public static int aux(int[] vector, int i0, int iN){
        if (i0 == iN) return 1;
        else {
            int k = (i0+iN)/2;
            int izq = aux(vector,i0,k);
            int der = aux(vector,k+1,iN);
            int medio = longMaxSubArrayOrdenadoCruzada(vector,i0,k,iN);
            return Math.max(izq,Math.max(der,medio));
        }
    }

    public static int media(int[] vector, int i0, int iN, int k){
        int i = k;
        while (i > i0 && vector[i-1] <= vector[i]){
            i--;
        }
        int j = k;
        while (j < iN && vector[j+1] >= vector[j]){
            j++;
        }
        return j-i+1;
    }

    public static int longMaxSubArrayOrdenadoCruzada(int[] vector, int i0, int k, int iN){
        int i=k;
        while (i>i0 && vector[i-1]<=vector[i]) {
            i--;
        }
        int j=k;
        while (j<iN && vector[j+1]>=vector[j]) {
            j++;
        }
        return j-i+1;
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{2,1,1,4,3,2,6,7,15};
        System.out.println(longMaxSubArrayOrdenadoCruzada(v1,0,4,v1.length-1));
    }
}
