public class Diciembre2020 {
    public static int maxArrayColina(int[] vector){
        return aux(vector,0,vector.length-1);
    }

    public static int aux(int[] vector, int i0, int iN){
        if (i0 == iN) return vector[i0];
        else if (iN == i0 +1) {
            return Math.max(vector[i0],vector[iN]);
        } else {
            int k = (i0+iN)/2;
            if (vector[k] > vector[k+1] && vector[k] > vector[k-1]) return vector[k];
            else if (vector[k] > vector[k+1]) return aux(vector,i0,k);
            else return aux(vector,k+1,iN);
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{5,7,8,9,3,2,1,0,-7};
        System.out.println(maxArrayColina(v1));
    }
}
