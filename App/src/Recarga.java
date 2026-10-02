import java.time.LocalDate;

// Recarga de saldo: monto positivo + fecha del movimiento.
public class Recarga {
    private final double monto;
    private final LocalDate fecha;

    public Recarga(double monto) {
        this.monto = monto;
        this.fecha = LocalDate.now();
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String toString() {
        return fecha + " RECARGA $" + monto;
    }
}
