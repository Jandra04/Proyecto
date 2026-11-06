package cr.ac.ucenfotec.bl.entidades;

public class Album {

    // Atributos
    private String nombre;

    // Constructor
    public Album(String nombre) {
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

    // Muestra la información del álbum
    @Override
    public String toString() {
        return "Álbum: " + nombre;
    }
}