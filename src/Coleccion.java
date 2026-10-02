import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Cancion> coleccion;
    private ArrayList<ArrayList<Cancion>> cacheTops;

    public Coleccion() {
        coleccion = new ArrayList<>();
        cacheTops = new ArrayList<>();
    }

    public void agregarCancion(Cancion c) {
        coleccion.addLast(c);
        System.out.println("Se ha añadido la canción: " + c + " a la colección del usuario. ");
    }

    public int indiceDe(Cancion c) {
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i).equals(c)) {
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
        c.calificar(valor);
    }

    private boolean coincide(String valor, String busqueda) {
        if (busqueda == null || valor == null) {
            return false;
        }
        return valor.toLowerCase().contains(busqueda.toLowerCase());
    }

    public ArrayList<Cancion> buscarPorNombre(String nombre) {
        ArrayList<Cancion> resultado = new ArrayList<>();
        for (int i = 0; i < coleccion.size(); i++) {

             if (coincide(coleccion.get(i).getNombre(), nombre)) {
                 resultado.addLast(coleccion.get(i));
             }
        }
        return resultado;
    }

    public ArrayList<Cancion> buscarPorGenero(String genero) {
        ArrayList<Cancion> resultado = new ArrayList<>();
        for (int i = 0; i < coleccion.size(); i++) {

             if (coincide(coleccion.get(i).getGenero().getNombre(), genero)) {
                 resultado.addLast(coleccion.get(i));
             }
        }
        return resultado;
    }

    public ArrayList<Cancion> buscarPorArtista(String artista) {
        ArrayList<Cancion> resultado = new ArrayList<>();
        for (int i = 0; i < coleccion.size(); i++) {

             if (coincide(coleccion.get(i).getArtista().getNombre(), artista)) {
                 resultado.addLast(coleccion.get(i));
             }
        }
        return resultado;
    }

    public double getCalificacionPromedio() {
        double suma = 0;
        int cont = 0;
        for (int i = 0; i < coleccion.size(); i++) {
            Calificacion cal = coleccion.get(i).getCalificacion();
            if (cal.hayCalificacion()) {
                suma = suma + cal.getPromedio();
                cont = cont + 1;
            }
        }
        if (cont == 0) {
            return 0.0;
        }
        return suma / cont;
    }

    private double valorDe(Cancion c) {
        if (!c.getCalificacion().hayCalificacion()) {
            return 0.0;
        }
        return c.getCalificacion().getPromedio();
    }

    public ArrayList<Cancion> getTop3MejoresCalificaciones() {
        if (coleccion.isEmpty()) {
            System.out.println("La coleccion está vacía. Llenela con al menos un elemento para utilizar este método");
            return new ArrayList<>();
        }
        ArrayList<Cancion> cs = new ArrayList<>(coleccion);
        cs.sort((a, b) -> Double.compare(valorDe(b), valorDe(a)));
        while (cs.size() > 3) {
            cs.removeLast();
        }
        return cs;
    }

    public ArrayList<Cancion> getTop3MasCompradas(HistorialMovimientos historial) {
        ArrayList<Cancion> cs = new ArrayList<>();
        if (historial == null) {
            return cs;
        }
        ArrayList<Compra> compras = historial.getCompras();
        for (int i = 0; i < compras.size(); i++) {
            Cancion c = compras.get(i).getCancion();
            if (c != null && !cs.contains(c)) {
                cs.add(c);
            }
        }
        cs.sort((a, b) -> Integer.compare(vecesComprada(b, compras), vecesComprada(a, compras)));
        recortarA3(cs);
        return cs;
    }

    private int vecesComprada(Cancion c, ArrayList<Compra> compras) {
        int n = 0;
        for (int i = 0; i < compras.size(); i++) {
            if (c.equals(compras.get(i).getCancion())) {
                n = n + 1;
            }
        }
        return n;
    }


    public ArrayList<Cancion> getTop3MasIncluidas(ArrayList<ListaReproduccion> listas) {
        ArrayList<Cancion> cs = new ArrayList<>();
        if (listas == null) {
            return cs;
        }
        for (int i = 0; i < listas.size(); i++) {
            ArrayList<Cancion> canciones = listas.get(i).getCanciones();
            for (int j = 0; j < canciones.size(); j++) {
                Cancion c = canciones.get(j);
                if (c != null && !cs.contains(c)) {
                    cs.add(c);
                }
            }
        }
        cs.sort((a, b) -> Integer.compare(vecesIncluida(b, listas), vecesIncluida(a, listas)));
        recortarA3(cs);
        return cs;
    }

    private int vecesIncluida(Cancion c, ArrayList<ListaReproduccion> listas) {
        int n = 0;
        for (int i = 0; i < listas.size(); i++) {
            ArrayList<Cancion> canciones = listas.get(i).getCanciones();
            for (int j = 0; j < canciones.size(); j++) {
                if (c.equals(canciones.get(j))) {
                    n = n + 1;
                }
            }
        }
        return n;
    }

    private void recortarA3(ArrayList<Cancion> cs) {
        while (cs.size() > 3) {
            cs.removeLast();
        }
    }

    public void actualizarTop3(HistorialMovimientos historial, ArrayList<ListaReproduccion> listas) {
        cacheTops.clear();
        cacheTops.addLast(getTop3MejoresCalificaciones());
        cacheTops.addLast(getTop3MasCompradas(historial));
        cacheTops.addLast(getTop3MasIncluidas(listas));
    }

    public ArrayList<ArrayList<Cancion>> getCacheTops() {
        return new ArrayList<>(cacheTops);
    }

    public int getCantidad() {
        return coleccion.size();
    }

    @Override
    public String toString() {
        return "Coleccion"
                + "\nCanciones: " + coleccion.size()
                + "\nTops en caché: " + cacheTops.size();
    }
}
