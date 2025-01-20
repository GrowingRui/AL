import java.util.Arrays;

public class Octubre2024 {
    public static boolean hayEnsamblaje (int[] longitud, int[] cantidad, int Ltotal){
        Booleano exito = new Booleano(false);
        int[] sol = new int[longitud.length];
        aux(longitud,cantidad,Ltotal,0,0,exito,sol);
        System.out.println(Arrays.toString(sol));
        return exito.getValor();
    }

    public static void aux (int[] longitud, int[] cantidad, int Ltotal,
                            int nivel, int suma, Booleano exito,int[] sol){
        if (nivel == longitud.length){
            if (suma == Ltotal) exito.setValor(true);
        }else {
            int c = 0;
            while (!exito.getValor() && c <= cantidad[nivel]){
                if (c == 0 || suma + longitud[nivel] <= Ltotal){
                    sol[nivel] = c;
                    suma = suma + longitud[nivel]*c;
                    nivel++;
                    aux(longitud,cantidad,Ltotal,nivel,suma,exito,sol);
                    if (!exito.getValor()){
                        nivel--;
                        suma = suma - longitud[nivel]*c;
                        sol[nivel] = 0;
                    }
                }
                c++;
            }
        }
    }

    public static void main(String[] args) {
        int[] longitud = new int[]{1,7,3,4};
        int[] cantidad = new int[]{1,4,2,1};
        System.out.println(hayEnsamblaje(longitud,cantidad,21));
    }
}
