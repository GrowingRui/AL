import java.util.Arrays;

public class Sesion1 {
    public static boolean hayRepartoEquitativo(int[] bienes){
        int suma = 0;
        for (int i = 0; i < bienes.length; i++) suma = suma + bienes[i];
        Booleano exito = new Booleano(false);
        if (suma % 3 == 0){
            int[] parts = new int[]{suma/3,suma/3,suma/3};
            int[] sol = new int[bienes.length];
            aux(bienes,0,exito,parts,sol);
            System.out.println(Arrays.toString(sol));
        }
        return exito.getValor();
    }

    public static void aux(int[] bienes, int nivel, Booleano exito,
                                            int[] parts, int[] sol){
        if (nivel == bienes.length){
            if (parts[0] == parts[1] && parts[1] == parts[2]) exito.setValor(true);
        }else {
            int c = 0;
            while (!exito.getValor() && c < 3){
                if (parts[c] >= bienes[nivel]){
                    sol[nivel] = c+1;
                    parts[c] = parts[c] - bienes[nivel];
                    nivel++;
                    aux(bienes,nivel,exito,parts,sol);
                    if (!exito.getValor()){
                        nivel--;
                        parts[c] = parts[c] + bienes[nivel];
                        sol[nivel] = 0;
                    }
                }
                c++;
            }
        }
    }

    public static void main(String[] args) {
        int[] bienes2 = {1, 2, 3, 4, 5, 6};
        int[] bienes7 = {6, 2, 9, 5, 8, 3};
        System.out.println(hayRepartoEquitativo(bienes7));
    }
}
