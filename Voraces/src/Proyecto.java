public class Proyecto {
    private String nombre;
    private float coste;
    private float retorno;
    public Proyecto(String nombre, float coste,
                    float retorno){
        this.nombre = nombre;
        this.coste = coste;
        this.retorno = retorno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    public float getRetorno() {
        return retorno;
    }

    public void setRetorno(float retorno) {
        this.retorno = retorno;
    }
}
