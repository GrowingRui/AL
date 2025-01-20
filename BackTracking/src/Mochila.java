public class Mochila {

    public static void main(String[] args) {
        int[] pesos = {3, 7, 2};
        int[] valores = {21, 37, 35};
        int maxPeso = 10;

        int[] solucion = new int[pesos.length];
        int valorActual = 0;
        int pesoActual = 0;

        int[] mejorSolucion = new int[pesos.length];
        Entero valorMejor = new Entero(0);
        mochilaOptima(pesos, valores, maxPeso, 0, solucion,
                valorActual, pesoActual, mejorSolucion, valorMejor);
    }

    public static void mochilaOptima(int[] pesos, int[] valores, int maxPeso, int nivel, int[] solucion,
                                     int valorActual, int pesoActual, int[] mejorSolucion, Entero valorMejor){
        if (nivel == pesos.length){
            if (valorActual > valorMejor.getValor()){
                valorMejor.setValor(valorActual);
                for (int i = 0; i < solucion.length; i++) mejorSolucion[i] = solucion[i];
            }
        }else {
            for (int c = 0; c < 2; c++){
                if (c == 0 || pesoActual + pesos[nivel] <= maxPeso){
                    solucion[nivel] = c;
                    pesoActual = pesoActual + pesos[nivel]*c;
                    valorActual = valorActual + valores[nivel]*c;
                    nivel++;
                    mochilaOptima(pesos,valores,maxPeso,nivel,solucion,valorActual,pesoActual,mejorSolucion,valorMejor);
                    nivel--;
                    pesoActual = pesoActual - pesos[nivel]*c;
                    valorActual = valorActual - valores[nivel]*c;
                    solucion[nivel] = 0;
                }
            }
        }
    }
}
