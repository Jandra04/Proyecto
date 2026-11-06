package cr.ac.ucenfotec.bl.entidades;

public class Genero {

    // Atributos
    private String nombre;

    // Constructor
    public Genero(String nombre) {
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

    // Muestra la información del género
    @Override
    public String toString() {
        return "Género: " + nombre;
    }
}