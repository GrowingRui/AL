public class Moneda {
    private int valor;
    private int cantidad;

    public Moneda(int valor, int cantidad){
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public int getCantidad() {
        return cantidad;
    }
}
