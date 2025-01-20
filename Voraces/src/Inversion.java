public class Inversion {
    private String nombreProyecto;
    private float invertido;
    public Inversion(String nombreProyecto,
                     float invertido){
        this.nombreProyecto = nombreProyecto;
        this.invertido = invertido;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public float getInvertido() {
        return invertido;
    }

    public void setInvertido(float invertido) {
        this.invertido = invertido;
    }
}
