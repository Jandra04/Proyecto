package cr.ac.ucenfotec.bl.entidades;
import cr.ac.ucenfotec.bl.excepciones.SaldoInsuficienteException;
import java.util.ArrayList;

public class HistorialMovimientos {

    // Atributos
    private ArrayList<Recarga> recargas;
    private ArrayList<Compra> compras;
    private double saldo;

    // Constructor
    public HistorialMovimientos() {
        this.recargas = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.saldo = 0.0;
    }

    // Getters
    public ArrayList<Recarga> getRecargas() {
        return recargas;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public double getSaldo() {
        return saldo;
    }

    // Registra una recarga
    public void registrarRecarga(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto de la recarga debe ser mayor que cero."
            );
        }

        Recarga recarga = new Recarga(monto);

        recargas.add(recarga);
        saldo += monto;
    }

    // Registra una compra
    public void registrarCompra(Usuario usuario,
                                Cancion cancion,
                                double monto)
            throws SaldoInsuficienteException {
        if (saldo < monto) {
            throw new SaldoInsuficienteException(
                    "El usuario no tiene saldo suficiente."
            );
        }

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto de la compra debe ser mayor que cero."
            );
        }

        if (saldo < monto) {
            throw new IllegalStateException(
                    "El usuario no tiene saldo suficiente."
            );
        }

        Compra compra =
                new Compra(
                        usuario,
                        cancion,
                        monto
                );

        compras.add(compra);
        saldo -= monto;
    }

    // Muestra las recargas y compras realizadas
    public void mostrarHistorial() {

        System.out.println("Recargas:");

        if (recargas.isEmpty()) {
            System.out.println("No hay recargas registradas.");
        } else {

            for (Recarga recarga : recargas) {
                System.out.println(recarga);
            }
        }

        System.out.println("Compras:");

        if (compras.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {

            for (Compra compra : compras) {
                System.out.println(compra);
            }
        }

        System.out.println(
                "Saldo actual: $"
                        + String.format("%.2f", saldo)
        );
    }

    // Muestra la información principal del historial
    @Override
    public String toString() {

        return "Historial con "
                + recargas.size()
                + " recargas y "
                + compras.size()
                + " compras. Saldo actual: $"
                + String.format("%.2f", saldo);
    }
}