import java.time.LocalDate;
import java.util.ArrayList;
public class ListaReproduccion {


    private String nombre;
    private LocalDate fechaCreacion;
    private ArrayList<Cancion> canciones;
    private double calificacion;

    public ListaReproduccion(String nombre, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.canciones = new ArrayList<>();
        this.calificacion = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        canciones.remove(cancion);
    }

    public void mostrarCanciones() {
        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

    @Override
    public String toString() {
        return "ListaReproduccion{" +
                "nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", canciones=" + canciones +
                ", calificacion=" + calificacion +
                '}';
    }
}
