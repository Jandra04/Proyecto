import java.util.ArrayList;
public class ColaReproduccion {


    private ArrayList<Cancion> canciones;

    public ColaReproduccion() {
        this.canciones = new ArrayList<>();
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public Cancion obtenerSiguiente() {
        if (!canciones.isEmpty()) {
            return canciones.remove(0);
        }

        return null;
    }

    public void mostrarCola() {
        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }

    @Override
    public String toString() {
        return "ColaReproduccion{" +
                "canciones=" + canciones +
                '}';
    }
}
