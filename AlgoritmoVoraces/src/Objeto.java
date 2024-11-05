public class Objeto {
    private String nombre;
    private int peso;
    private int valor;

    public Objeto(String nombre, int peso, int valor){
        this.nombre = nombre;
        this.peso = peso;
        this.valor = valor;
    }

    public float getBeneficio(){
        return valor * 1.0f/peso;   // value per kilogram (value/kilo)
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public int getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }
}
