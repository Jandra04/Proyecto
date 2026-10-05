// Acumulador de la calificacion de UNA cancion: promedio global de todos los votos.
// Una sola instancia por cancion (vive en Cancion).
public class Calificacion {
    private double suma;
    private int cantidad;

    public Calificacion() {
        suma = 0;
        cantidad = 0;
    }

    // true si se guardo; false si no era valido (fuera de rango o mas de un decimal)
    public boolean agregar(double v) {
        double redondeado = Math.round(v * 10) / 10.0;
        if (v < 0 || v > 5 || redondeado != v) {
            System.out.println("Valor no válido: debe estar entre 0.0 y 5.0 con un máximo de un decimal.");
            return false;
        }
        suma += v;
        cantidad++;
        return true;
    }

    // 0.0 si nadie ha calificado
    public double getPromedio() {
        if (cantidad == 0) {
            return 0.0;
        }
        return suma / cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean hayCalificacion() {
        return cantidad > 0;
    }

    public String toString() {
        return String.format("%.1f", getPromedio());
    }
}
