import java.util.ArrayList;

public class Coleccion {
    ArrayList<Cancion> coleccion;
    ArrayList<ArrayList<Cancion>> cacheTops;

    public Coleccion() {
        coleccion = new ArrayList<>();
        cacheTops = new ArrayList<>();
    }

    public void agregarCancion(Cancion c) {
        coleccion.addLast(c);
        System.out.println("Se ha añadido la canción: " + c + " a la colección del usuario. ");
    }

    // -1 si la cancion no esta en la coleccion
    public int indiceDe(Cancion c) {
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i) == c) {
                return i;
            }
        }
        return -1;
    }

    // null si el indice no existe
    public Cancion getCancion(int i) {
        if (i < 0 || i >= coleccion.size()) {
            System.out.println("Índice inválido: " + i);
            return null;
        }
        return coleccion.get(i);
    }

    // indice invalido: imprime y no hace nada
    public void calificar(int i, double valor) {
        Cancion c = getCancion(i);
        if (c == null) {
            return;
        }
        // TODO: descomentar cuando Cancion.calificar esté implementada
        // c.calificar(valor);
    }

    // true si el valor contiene la busqueda (sin distinguir mayusculas); false si busqueda es null
    private boolean coincide(String valor, String busqueda) {
        if (busqueda == null || valor == null) {
            return false;
        }
        return valor.toLowerCase().contains(busqueda.toLowerCase());
    }

    // busquedas sobre la coleccion propia del usuario
    public ArrayList<Cancion> buscarPorNombre(String nombre) {
        ArrayList<Cancion> resultado = new ArrayList<>();
        for (int i = 0; i < coleccion.size(); i++) {
            // TODO: descomentar cuando Cancion.getNombre esté implementada
            // if (coincide(coleccion.get(i).getNombre(), nombre)) {
            //     resultado.addLast(coleccion.get(i));
            // }
        }
        return resultado;
    }

    public ArrayList<Cancion> buscarPorGenero(String genero) {
        ArrayList<Cancion> resultado = new ArrayList<>();
        for (int i = 0; i < coleccion.size(); i++) {
            // TODO: descomentar cuando Cancion.getGenero esté implementada
            // if (coincide(coleccion.get(i).getGenero(), genero)) {
            //     resultado.addLast(coleccion.get(i));
            // }
        }
        return resultado;
    }

    public ArrayList<Cancion> buscarPorArtista(String artista) {
        ArrayList<Cancion> resultado = new ArrayList<>();
        for (int i = 0; i < coleccion.size(); i++) {
            // TODO: descomentar cuando Cancion.getArtista esté implementada
            // if (coincide(coleccion.get(i).getArtista(), artista)) {
            //     resultado.addLast(coleccion.get(i));
            // }
        }
        return resultado;
    }

    // promedio de las calificadas, 0.0 si ninguna tiene calificacion (null no suma)
    public double getCalificacionPromedio() {
        double suma = 0;
        int cont = 0;
        for (int i = 0; i < coleccion.size(); i++) {
            // TODO: descomentar cuando Cancion.getCalificacion esté implementada
            // Calificacion cal = coleccion.get(i).getCalificacion();
            // if (cal.hayCalificacion()) {
            //     suma = suma + cal.getPromedio();
            //     cont = cont + 1;
            // }
        }
        if (cont == 0) {
            return 0.0;
        }
        return suma / cont;
    }

    // sin calificar cuenta como 0.0, queda al final
    private double valorDe(Cancion c) {
        // TODO: descomentar cuando Cancion.getCalificacion esté implementada
        // if (!c.getCalificacion().hayCalificacion()) {
        //     return 0.0;
        // }
        // return c.getCalificacion().getPromedio();
        return 0.0;
    }

    public ArrayList<Cancion> getTop3MejoresCalificaciones() {
        if (coleccion.isEmpty()) {
            System.out.println("La coleccion está vacía. Llenela con al menos un elemento para utilizar este método");
            return new ArrayList<>();
        }
        ArrayList<Cancion> cs = new ArrayList<>(coleccion);
        cs.sort((a, b) -> Double.compare(valorDe(b), valorDe(a))); // descendente
        while (cs.size() > 3) {
            cs.removeLast();
        }
        return cs;
    }

    public ArrayList<Cancion> getTop3MasCompradas() {
        // todo: cuando Cancion tenga contador de compras
        return new ArrayList<>();
    }

    public ArrayList<Cancion> getTop3MasIncluidas() {
        // todo: cuando Cancion tenga contador de inclusiones en listas
        return new ArrayList<>();
    }

    public void actualizarTop3() {
        cacheTops.clear();
        cacheTops.addLast(getTop3MejoresCalificaciones());
        cacheTops.addLast(getTop3MasCompradas());
        cacheTops.addLast(getTop3MasIncluidas());
    }
}
