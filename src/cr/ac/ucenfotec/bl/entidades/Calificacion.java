package cr.ac.ucenfotec.bl.entidades;

public class Calificacion {

    // atributos
    private double suma;
    private int cantidad;

    // Constructor
    public Calificacion() {
        this.suma = 0.0;
        this.cantidad = 0;
    }

    // Getters
    public double getSuma() {
        return suma;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPromedio() {

        if (cantidad == 0) {
            return 0.0;
        }

        return suma / cantidad;
    }

    // Agrega una calificación válida
    public boolean agregar(double valor) {

        double redondeado =
                Math.round(valor * 10) / 10.0;

        if (valor < 0.0
                || valor > 5.0
                || redondeado != valor) {

            System.out.println(
                    "La calificación debe estar entre 0.0 y 5.0 y tener máximo un decimal."
            );

            return false;
        }

        suma += valor;
        cantidad++;

        return true;
    }

    // Verifica si existen calificaciones
    public boolean hayCalificaciones() {
        return cantidad > 0;
    }

    // Muestra el promedio y la cantidad de calificaciones
    @Override
    public String toString() {

        if (!hayCalificaciones()) {
            return "La canción todavía no tiene calificaciones.";
        }

        return "La canción tiene una calificación promedio de "
                + String.format("%.1f", getPromedio())
                + " basada en "
                + cantidad
                + " calificaciones.";
    }
}