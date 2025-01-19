public class Sesion4 {
    public static int oneSubArray (int[] v){
        return aux(v,0,v.length-1);
    }

    public static int aux (int[] v, int i0, int iN){
        if (i0 == iN) return v[i0];
        else {
            int k = (i0+iN)/2;
            int izq = aux(v,i0,k);
            int der = aux(v,k+1,iN);
            int med = medio(v,i0,iN,k);
            return Math.max(izq,Math.max(der,med));
        }
    }

    public static int medio(int[] v, int i0, int iN, int k){
        int suma = 0;
        int i = k, j = k+1;
        while (i >= i0 && v[i] != 0){
            suma++;
            i--;
        }
        while (j <= iN && v[j] != 0){
            suma++;
            j++;
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{1,1,1,1,1,0,1};  //5
        int[] v2 = new int[]{0,0,0,0,1,1,1};  //3
        int[] v3 = new int[]{1,1,1,1,0,1,1,1,1,1,0}; //5
        int[] v4 = new int[]{0,0,0,0,0};  //0
        int[] v5 = new int[]{1,0,1,0,1,0,1,0,1};  //1

        System.out.println(oneSubArray(v5));
    }
}
