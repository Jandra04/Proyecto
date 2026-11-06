package cr.ac.ucenfotec.bl.entidades;

import java.time.LocalDate;

public class Recarga {

    // Atributos
    private double monto;
    private LocalDate fecha;

    // Constructor
    public Recarga(double monto) {
        this.monto = monto;
        this.fecha = LocalDate.now();
    }

    // Getters
    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    // Muestra la información de la recarga
    @Override
    public String toString() {

        return "Se realizó una recarga de $"
                + String.format("%.2f", monto)
                + " el "
                + fecha
                + ".";
    }
}