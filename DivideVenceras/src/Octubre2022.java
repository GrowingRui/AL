public class Octubre2022 {
    public static int primerPositivoEnPolarizado (int[] vector){
        if (vector[0] > 0) return 0;
        else if (vector[vector.length-1] < 0) {
            return -1;
        } else return aux(vector,0,vector.length-1);
    }

    public static int aux (int[] vector, int i0, int iN){
        if (i0 == iN) return i0;
        else {
            int k = (i0+iN)/2;
            if (vector[k] < 0) return aux(vector,k+1,iN);
            else return aux(vector,i0,k);
        }
    }

}
