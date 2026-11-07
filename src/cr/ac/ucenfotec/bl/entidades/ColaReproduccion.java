package cr.ac.ucenfotec.bl.entidades;

import java.util.ArrayList;

public class ColaReproduccion {

    // Canciones pendientes de reproducir
    private ArrayList<Cancion> canciones;

    // Constructor
    public ColaReproduccion() {
        this.canciones = new ArrayList<>();
    }

    // Getter
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    // Agrega una canción al final de la cola
    public boolean agregarCancion(Cancion cancion) {

        if (cancion == null) {
            return false;
        }

        canciones.add(cancion);

        System.out.println(
                cancion.getNombre()
                        + " se agregó a la cola."
        );

        return true;
    }

    // Obtiene y elimina la siguiente canción
    public Cancion obtenerSiguiente() {

        if (canciones.isEmpty()) {
            return null;
        }

        return canciones.remove(0);
    }

    // Elimina una canción de la cola
    public boolean eliminarCancion(Cancion cancion) {

        if (cancion == null) {
            return false;
        }

        if (!canciones.remove(cancion)) {

            System.out.println(
                    "La canción no está en la cola."
            );

            return false;
        }

        System.out.println(
                cancion.getNombre()
                        + " se eliminó de la cola."
        );

        return true;
    }

    // Verifica si la cola está vacía
    public boolean estaVacia() {
        return canciones.isEmpty();
    }

    // Vacía la cola
    public void vaciarCola() {
        canciones.clear();
    }

    // Muestra las canciones de la cola
    public void mostrarCola() {

        if (canciones.isEmpty()) {
            System.out.println("La cola de reproducción está vacía.");
            return;
        }

        for (Cancion cancion : canciones) {
            System.out.println(cancion.getNombre());
        }
    }

    // Muestra la cantidad de canciones en la cola
    @Override
    public String toString() {

        return "La cola tiene "
                + canciones.size()
                + " canciones.";
    }
}