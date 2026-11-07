package cr.ac.ucenfotec.bl.entidades;

import cr.ac.ucenfotec.bl.interfaces.Buscable;

import java.util.ArrayList;

public class Coleccion implements Buscable {

    // Atributos
    private ArrayList<Cancion> canciones;

    // Constructor
    public Coleccion() {
        this.canciones = new ArrayList<>();
    }

    // Getter
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    // Agrega una canción a la colección
    public boolean agregarCancion(Cancion cancion) {

        if (cancion == null || contieneCancion(cancion)) {
            return false;
        }

        canciones.add(cancion);

        return true;
    }

    // Verifica si una canción está en la colección
    public boolean contieneCancion(Cancion cancion) {
        return canciones.contains(cancion);
    }

    // Busca la posición de una canción
    public int indiceDe(Cancion cancion) {
        return canciones.indexOf(cancion);
    }

    // Obtiene una canción según su posición
    public Cancion getCancion(int indice) {

        if (indice < 0 || indice >= canciones.size()) {
            return null;
        }

        return canciones.get(indice);
    }

    // Busca canciones por nombre
    @Override
    public ArrayList<Cancion> buscarPorNombre(String nombre) {

        ArrayList<Cancion> resultados = new ArrayList<>();

        if (nombre == null) {
            return resultados;
        }

        for (Cancion cancion : canciones) {

            if (cancion.getNombre()
                    .toLowerCase()
                    .contains(nombre.toLowerCase())) {

                resultados.add(cancion);
            }
        }

        return resultados;
    }

    // Busca canciones por género
    @Override
    public ArrayList<Cancion> buscarPorGenero(String genero) {

        ArrayList<Cancion> resultados = new ArrayList<>();

        if (genero == null) {
            return resultados;
        }

        for (Cancion cancion : canciones) {

            if (cancion.getGenero()
                    .getNombre()
                    .toLowerCase()
                    .contains(genero.toLowerCase())) {

                resultados.add(cancion);
            }
        }

        return resultados;
    }

    // Busca canciones por artista
    @Override
    public ArrayList<Cancion> buscarPorArtista(String artista) {

        ArrayList<Cancion> resultados = new ArrayList<>();

        if (artista == null) {
            return resultados;
        }

        for (Cancion cancion : canciones) {

            if (cancion.getArtista()
                    .getNombre()
                    .toLowerCase()
                    .contains(artista.toLowerCase())) {

                resultados.add(cancion);
            }
        }

        return resultados;
    }

    // Muestra las canciones de la colección
    public void mostrarColeccion() {

        if (canciones.isEmpty()) {

            System.out.println(
                    "La colección está vacía."
            );

            return;
        }

        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

    // Muestra la información principal de la colección
    @Override
    public String toString() {

        return "Colección con "
                + canciones.size()
                + " canciones.";
    }
}