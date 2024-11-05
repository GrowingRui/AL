public class Actividad {
    private int id;
    private int inicio;
    private int fin;

    public Actividad(int id, int inicio, int fin) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public int getId() {
        return id;
    }

    public int getInicio() {
        return inicio;
    }
}
