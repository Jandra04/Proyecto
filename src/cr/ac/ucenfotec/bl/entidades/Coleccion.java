import java.util.ArrayList;

public class Coleccion {

    private ArrayList<Cancion> coleccion;
    private ArrayList<ArrayList<Cancion>> cacheTops;

    public Coleccion() {
        this.coleccion = new ArrayList<>();
        this.cacheTops = new ArrayList<>();
    }

    public ArrayList<Cancion> getColeccion() {
        return coleccion;
    }

    public void setColeccion(ArrayList<Cancion> coleccion) {
        this.coleccion = coleccion;
    }

    public ArrayList<ArrayList<Cancion>> getCacheTops() {
        return cacheTops;
    }

    public void setCacheTops(ArrayList<ArrayList<Cancion>> cacheTops) {
        this.cacheTops = cacheTops;
    }

    public void agregarCancion(Cancion c) {
        coleccion.add(c);

        System.out.println(
                "Se ha añadido la canción "
                        + c.getNombre()
                        + " a la colección del usuario."
        );
    }

    public int indiceDe(Cancion c) {

        for (int i = 0; i < coleccion.size(); i++) {

            if (coleccion.get(i) == c) {
                return i;
            }
        }

        return -1;
    }

    public Cancion getCancion(int i) {

        if (i < 0 || i >= coleccion.size()) {
            System.out.println("Índice inválido: " + i);
            return null;
        }

        return coleccion.get(i);
    }

    public void calificar(int i, double valor) {

        Cancion c = getCancion(i);

        if (c == null) {
            return;
        }

        // Se activará cuando Cancion tenga el método calificar
        // c.calificar(valor);
    }

    private boolean coincide(String valor, String busqueda) {

        if (busqueda == null || valor == null) {
            return false;
        }

        return valor.toLowerCase()
                .contains(busqueda.toLowerCase());
    }

    public ArrayList<Cancion> buscarPorNombre(String nombre) {

        ArrayList<Cancion> resultado = new ArrayList<>();

        for (int i = 0; i < coleccion.size(); i++) {

            if (coincide(
                    coleccion.get(i).getNombre(),
                    nombre)) {

                resultado.add(coleccion.get(i));
            }
        }

        return resultado;
    }

    public ArrayList<Cancion> buscarPorGenero(String genero) {

        ArrayList<Cancion> resultado = new ArrayList<>();

        for (int i = 0; i < coleccion.size(); i++) {

            if (coincide(
                    coleccion.get(i).getGenero().getNombre(),
                    genero)) {

                resultado.add(coleccion.get(i));
            }
        }

        return resultado;
    }

    public ArrayList<Cancion> buscarPorArtista(String artista) {

        ArrayList<Cancion> resultado = new ArrayList<>();

        for (int i = 0; i < coleccion.size(); i++) {

            if (coincide(
                    coleccion.get(i).getArtista().getNombre(),
                    artista)) {

                resultado.add(coleccion.get(i));
            }
        }

        return resultado;
    }

    public double getCalificacionPromedio() {

        if (coleccion.isEmpty()) {
            return 0.0;
        }

        double suma = 0;

        for (int i = 0; i < coleccion.size(); i++) {
            suma += coleccion.get(i).getCalificacion();
        }

        return suma / coleccion.size();
    }

    private double valorDe(Cancion c) {
        return c.getCalificacion();
    }

    public ArrayList<Cancion> getTop3MejoresCalificaciones() {

        if (coleccion.isEmpty()) {

            System.out.println(
                    "La colección está vacía."
            );

            return new ArrayList<>();
        }

        ArrayList<Cancion> cs =
                new ArrayList<>(coleccion);

        cs.sort(
                (a, b) ->
                        Double.compare(
                                valorDe(b),
                                valorDe(a)
                        )
        );

        while (cs.size() > 3) {
            cs.remove(cs.size() - 1);
        }

        return cs;
    }

    public ArrayList<Cancion> getTop3MasCompradas() {

        // Se completará cuando Cancion tenga contador
        // de compras.

        return new ArrayList<>();
    }

    public ArrayList<Cancion> getTop3MasIncluidas() {

        // Se completará cuando Cancion tenga contador
        // de inclusiones en listas.

        return new ArrayList<>();
    }

    public void actualizarTop3() {

        cacheTops.clear();

        cacheTops.add(
                getTop3MejoresCalificaciones()
        );

        cacheTops.add(
                getTop3MasCompradas()
        );

        cacheTops.add(
                getTop3MasIncluidas()
        );
    }

    @Override
    public String toString() {

        return "La colección contiene "
                + coleccion.size()
                + " canciones y tiene una calificación promedio de "
                + getCalificacionPromedio()
                + ".";
    }
}