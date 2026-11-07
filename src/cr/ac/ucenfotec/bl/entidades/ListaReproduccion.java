package cr.ac.ucenfotec.bl.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaReproduccion {

    // Atributos
    private String nombre;
    private LocalDate fechaCreacion;
    private ArrayList<Cancion> canciones;

    // Constructor
    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDate.now();
        this.canciones = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public double getCalificacion() {

        if (canciones.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;

        for (Cancion cancion : canciones) {
            suma += cancion.getCalificacion();
        }

        return suma / canciones.size();
    }

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Agrega una canción a la lista
    public boolean agregarCancion(Cancion cancion) {

        if (cancion == null || contieneCancion(cancion)) {
            return false;
        }

        canciones.add(cancion);

        cancion.registrarAgregadaALista();

        return true;
    }

    // Elimina una canción de la lista
    public boolean eliminarCancion(Cancion cancion) {

        if (cancion == null) {
            return false;
        }

        if (canciones.remove(cancion)) {

            cancion.registrarEliminadaDeLista();

            return true;
        }

        return false;
    }

    // Verifica si una canción está en la lista
    public boolean contieneCancion(Cancion cancion) {
        return canciones.contains(cancion);
    }

    // Muestra las canciones de la lista
    public void mostrarCanciones() {

        if (canciones.isEmpty()) {

            System.out.println(
                    "La lista de reproducción está vacía."
            );

            return;
        }

        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

    // Muestra la información principal de la lista
    @Override
    public String toString() {

        return "Lista: "
                + nombre
                + "\nFecha de creación: "
                + fechaCreacion
                + "\nCantidad de canciones: "
                + canciones.size()
                + "\nCalificación promedio: "
                + String.format("%.1f", getCalificacion());
    }
}