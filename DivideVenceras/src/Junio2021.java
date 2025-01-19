public class Junio2021 {
    public static int posDiferente (int[] vector1, int[] vector2){
        return aux(vector1,vector2,0,Math.min(vector1.length,vector2.length));
    }

    public static int aux (int[] vector1, int[] vector2, int i0, int iN){
        if (i0 == iN){
            if (vector1[i0] == vector2[i0]) return -1;
            else return i0;
        }else {
            int k = (i0+iN)/2;
            if (vector1[k] != vector2[k]) return aux(vector1,vector2,i0,k);
            else return aux(vector1,vector2,k+1,iN);
        }
    }

}
