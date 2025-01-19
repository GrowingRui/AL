public class Sesion1 {

    public static int numMultiplos(int[] v, int x){
        return aux(v,x,0, v.length-1);
    }

    public static int aux(int[] v, int x, int i0, int iN){
        if (i0 == iN){
            if (v[i0] % x == 0) return 1;
            else return 0;
        }else {
            int k = (i0+iN)/2;
            int izq = 0;
            if (v[k] >= x){
                izq = aux(v,x,i0,k);
            }
            int der = aux(v,x,k+1,iN);
            return izq + der;
        }
    }

    public static void main(String[] args) {
        int[] v = new int[]{1,1,2,4,6,17,18};
        System.out.println(numMultiplos(v,3));
    }
}
