public class Producto {
    private int nombre;
    private int peso;

    public Producto (int nombre, int peso){
        this.nombre = nombre;
        this.peso = peso;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public int getNombre() {
        return nombre;
    }
}