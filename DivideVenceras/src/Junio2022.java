public class Junio2022 {
    public static int parImpar (int[] vector){
        return aux(vector,0,vector.length-1);
    }

    public static int aux (int[] vector, int i0, int iN){
        if (i0 == iN){
            if (vector[i0] % 2 == 0) return -1;
            else return i0;
        }else {
            int k = (i0+iN)/2;
            if ((k % 2 == 0 && vector[k] % 2 == 0) || (k % 2 != 0 && vector[k] % 2 != 0)){
                return aux(vector,k+1,iN);
            } else return aux(vector,i0,k);
        }
    }
}
