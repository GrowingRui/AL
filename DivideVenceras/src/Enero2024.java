import java.util.Arrays;

public class Enero2024 {
    public static void pares(int[] array){
        aux(array,0,array.length-1);
    }

    public static void aux(int[] array, int i0, int iN){
        if (i0 == iN) return;
        else {
            int k = (i0+iN)/2;
            aux(array,i0,k);
            aux(array,k+1,iN);
            cambia2(array,i0,iN,k);
        }
    }

    // mi implementacion without k
    public static void cambia1(int[] array, int i0, int iN){
        int i = i0, j = iN;
        while (i < j){
            if (array[i] % 2 != 0 && array[j] % 2 == 0){
                int x = array[i];
                array[i] = array[j];
                array[j] = x;
            }
            if (array[i] % 2 == 0) i++;
            if (array[j] % 2 != 0) j--;
        }
    }

    // implementacion solucion
    public static void cambia2(int[] array, int i0, int iN, int k){
        int i = i0, j = iN;
        while (i <= k && array[i] % 2 == 0) i++;
        while (j > k && array[j] % 2 != 0) j--;
        while (i <= k && j > k){
            int aux = array[i];
            array[i] = array[j];
            array[j] = aux;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{-12,5,8,9,0};
        System.out.println(Arrays.toString(v1));
        pares(v1);
        System.out.println(Arrays.toString(v1));
    }
}
