public class Sesion3 {
    public static int elementoSolitario(int[] vector){
        return aux(vector,0,vector.length-1);
    }

    public static int aux(int[] vector, int i0, int iN){
        if (i0 == iN) return vector[i0];
        else {
            int k = (i0+iN)/2;
            if (vector[k] == vector[k+1]){
                if ((i0+k) % 2 == 0) return aux(vector,k+2,iN);
                else return aux(vector,i0,k-1);
            }else if (vector[k-1] == vector[k]){
                if ((i0+k+1) % 2 == 0) return aux(vector,k+1,iN);
                else return aux(vector,i0,k-2);
            }else return vector[k];
        }
    }

    public static int elementoSolitarioAux(int[] vector, int i0, int iN){
        if (i0 == iN)
            return vector[i0];
        else {
            int k = (i0 + iN) / 2;
            if (vector[k-1] == vector[k])
                //Se encuentra en [i0...k-2] o bien en [k+1...iN]
                if ((k-2-i0+1)%2==0)
                    return elementoSolitarioAux(vector, k + 1, iN);
                else
                    return elementoSolitarioAux(vector, i0, k-2);
            else if (vector[k] == vector[k+1])
                //Se encuentra en [i0...k-1] o bien en [k+2...iN]
                if ((k-1-i0+1)%2==0)
                    return elementoSolitarioAux(vector, k + 2, iN);
                else
                    return elementoSolitarioAux(vector, i0, k-1);
            else
                return vector[k];
        }
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{1,1,2,4,4};
        int[] v2 = new int[]{1,1,2};
        int[] v3 = new int[]{1,1,5,5,6,7,7,8,8,9,9};
        int[] v4 = new int[]{3,4,4,6,6};
        int[] v5 = new int[]{3,4,4};
        System.out.println(elementoSolitario(v1));
    }
}
