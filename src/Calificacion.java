public class Calificacion {

    private double suma;
    private int cantidad;

    public Calificacion() {
        this.suma = 0.0;
        this.cantidad = 0;

    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean agregar(double valor) {

        double redondeado =
                Math.round(valor * 10) / 10.0;

        if (valor < 0.0
                || valor > 5.0
                || redondeado != valor) {

            System.out.println(
                    "Valor no válido: debe estar entre 0.0 y 5.0 con un máximo de un decimal."
            );

            return false;
        }

        suma = suma + valor;
        cantidad++;

        return true;
    }

    public double getPromedio() {

        if (cantidad == 0) {
            return 0.0;
        }

        return suma / cantidad;
    }

    public boolean hayCalificacion() {
        return cantidad > 0;
    }

    @Override
    public String toString() {

        return "La canción tiene una calificación promedio de "
                + String.format("%.1f", getPromedio())
                + " basada en "
                + cantidad
                + " calificaciones.";
    }
}