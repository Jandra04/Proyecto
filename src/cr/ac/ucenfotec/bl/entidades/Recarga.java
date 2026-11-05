import java.time.LocalDate;

public class Recarga {

    private double monto;
    private LocalDate fecha;

    public Recarga(double monto) {
        this.monto = monto;
        this.fecha = LocalDate.now();
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Se realizó una recarga de $" + monto
                + " el " + fecha + ".";
    }
}