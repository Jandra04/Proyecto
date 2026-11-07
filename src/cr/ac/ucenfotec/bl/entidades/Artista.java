package cr.ac.ucenfotec.bl.entidades;

public class Artista {

    // atributos
    private String nombre;

    // Constructor
    public Artista(String nombre) {
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

    // Muestra la información del artista
    @Override
    public String toString() {
        return "Artista: " + nombre;
    }
}