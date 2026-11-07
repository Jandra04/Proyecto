package cr.ac.ucenfotec.bl.entidades;

public class Compositor {

    // Atributos
    private String nombre;

    // Constructor
    public Compositor(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Muestra la información del compositor
    @Override
    public String toString() {
        return "Compositor: " + nombre;
    }
}
