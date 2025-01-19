public class Octubre2024 {
    public static int primerIndex(int[] v, int num){
        if (v[0] > num) return -1;
        else return aux(v,num,0,v.length-1);
    }

    public static int aux(int[] v, int num, int i0, int iN){
        if (i0 == iN){
            if (v[i0] == num) return i0;
            else return -1;
        }else {
            int k = (i0+iN)/2;
            if (v[k] < num) return aux(v,num,k+1,iN);
            else return aux(v,num,i0,k);
        }
    }
}
