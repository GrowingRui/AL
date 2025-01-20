import java.util.Arrays;

public class EjercicioPPT1 {
    public static int suma (int[] solucion, int[] vector, int nivel){
        int suma=0;
        for (int i=0; i<nivel; i++)
            if (solucion[i]==1) suma = suma+vector[i];
        return suma;
    }

    public static void main(String[] args) {
        int[] vector = {13, 11, 7};
        int num = 20;
        Booleano exito = new Booleano(false);
        int[] solucion = new int[vector.length];
        for (int i=0; i<solucion.length; i++) solucion[i]=0;
        subconjuntoSumaBack(vector, num, solucion, 0, exito);
        System.out.println(Arrays.toString(solucion));
    }
    public static void subconjuntoSumaBack(int[] vector, int num, int[] sol, int nivel, Booleano exito){
        if (nivel == vector.length){
            if (suma(sol,vector,nivel) == num) exito.setValor(true);
        }else {
            int c = 0;
            while (!exito.getValor() && c < 2){
                if (c == 0 || suma(sol,vector,nivel) + vector[nivel] <= num){
                    sol[nivel] = c;
                    nivel = nivel + 1;
                    subconjuntoSumaBack(vector,num,sol,nivel,exito);
                    if (!exito.getValor()){
                        nivel = nivel -1;
                        sol[nivel] = 0;
                    }
                }
                c++;
            }
        }
    }

    public static void subconjuntoSumaBack(int[] vector, int num, int suma, int nivel, Booleano exito){
        if (nivel == vector.length){
            if (suma == num) exito.setValor(true);
        }else {
            int c = 0;
            while (!exito.getValor() && c < 2){
                if (c == 0 || (suma + vector[nivel]) <= num){
                    suma = suma + vector[nivel]*c;
                    nivel = nivel + 1;
                    subconjuntoSumaBack(vector,num,suma,nivel,exito);
                    if (!exito.getValor()){
                        nivel = nivel -1;
                        suma = suma - vector[nivel]*c;
                    }
                }
                c++;
            }
        }
    }

}
