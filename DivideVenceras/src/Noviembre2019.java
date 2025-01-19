public class Noviembre2019 {
    public static int elementoEspecial(int[] vector){
        if (vector[0] == vector[vector.length-1]) return aux(vector,1,vector.length-2);
        else return aux(vector,0,vector.length-1);
    }

    public static int elementoEspecialAux(int[] vector, int i0, int iN){
        if (i0==iN) return vector[i0];
        else {
            int k=(i0+iN)/2;
            if (vector[k]==vector[k+1]) {
                if ((k-1-i0+1) % 2 == 1) return elementoEspecialAux(vector, i0, k-1);
                else return elementoEspecialAux(vector, k+2, iN);
            }
            else if (vector[k-1]==vector[k]) {
                if ((k-2-i0+1) % 2 == 1) return elementoEspecialAux(vector, i0, k-2);
                else return elementoEspecialAux(vector, k+1, iN);
            }
            else return vector[k];
        }
    }
    public static int aux(int[] vector, int i0, int iN){
        if (i0 == iN) return vector[i0];
        else{
            int k = (i0+iN)/2;
            if (vector[k] == vector[k+1]){
                if ((k-i0) % 2 == 0) return aux(vector,k+2,iN);
                else return aux(vector,i0,k-1);
            }else {
                if ((i0+k+1) % 2 == 0) return aux(vector,k+1,iN);
                else return aux(vector,i0,k-2);
            }
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{1,1,2,2,3,3,4,0,0};
        int[] v2 = new int[]{1,1,2,3,3,4,4,5,5};
        System.out.println(elementoEspecial(v1));
    }
}
