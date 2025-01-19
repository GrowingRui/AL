public class Noviembre2018 {
    public static int minArrayRotado(int[] vector){
        return aux(vector,0,vector.length-1);
    }

    public static int aux(int[] vector, int i0, int iN){
        if (i0 == iN) return vector[i0];
        else {
            int k = (i0+iN)/2;
            if (vector[i0] <= vector[k] && vector[k] <= vector[iN]) return vector[i0];
            else if (vector[k] > vector[iN]) return aux(vector,k+1, iN);
            else return aux(vector,i0,k);
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{10,15,23,32,1,2,3,4,7};
        int[] v2= new int[]{3,4,5,6,7,1,2};
        int[] v3 = new int[]{6,7,0,2,3,4,5};
        System.out.println(minArrayRotado(v3));
    }
}
