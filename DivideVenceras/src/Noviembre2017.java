public class Noviembre2017 {
    public static int elementoEspecial(int[] vector){
        return aux(vector,0,vector.length-1);
    }

    public static int aux(int[] vector, int i0, int iN){
        if (i0 == iN){
            if (vector[i0] == i0) return i0;
            else return -1;
        }else {
            int k = (i0+iN)/2;
            if (vector[k] > k) return aux(vector,i0,k);
            else if (vector[k] < k) return aux(vector,k+1,iN);
            else return k;
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{-10,-2,0,2,3,9,19,28,30,42,55};
        System.out.println(elementoEspecial(v1));
    }
}
