public class Sesion2 {
    public static int positivoMenor(int[] vector){
        return aux(vector,0,vector.length-1);
    }

    public static int aux(int[] vector, int i0, int iN){
        if (i0 == iN){
            if (vector[i0] > 0) return vector[i0];
            else return -1;
        }else {
            int k = (i0+iN)/2;
            if (vector[k] > 0) return aux(vector,i0,k);
            else return aux(vector,k+1,iN);
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{-5,-5,-1,3,7};
        int[] v2 = new int[]{-4,-2, 0, 1, 5 ,7, 11, 13};
        int[] v3 = new int[]{-1, 4, 8, 10};
        int[] v4 = new int[]{-8, -7, -4, 2, 10, 11, 12, 17};
        int[] v5 = new int[]{-20, -4, 0, 0, 1, 1, 3};

        System.out.println(positivoMenor(v5));
    }
}
