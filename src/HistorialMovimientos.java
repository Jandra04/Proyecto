import java.util.ArrayList;

public class HistorialMovimientos {

    private ArrayList<Recarga> recargas;
    private ArrayList<Compra> compras;
    private double saldo;

    public HistorialMovimientos() {
        this.recargas = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.saldo = 0.0;
    }

    public ArrayList<Recarga> getRecargas() {
        return recargas;
    }

    public void setRecargas(ArrayList<Recarga> recargas) {
        this.recargas = recargas;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void registrarRecarga(double monto) {

        if (monto <= 0) {
            System.out.println("El monto de la recarga debe ser mayor a cero.");
            return;
        }

        Recarga recarga = new Recarga(monto);
        recargas.add(recarga);

        saldo = saldo + monto;
    }

    public void registrarCompra(String nombreUsuario, Cancion cancion, double monto) {

        if (cancion == null || monto <= 0) {
            System.out.println("No se pudo registrar la compra.");
            return;
        }

        Compra compra = new Compra(
                nombreUsuario,
                cancion,
                monto
        );

        compras.add(compra);

        saldo = saldo - monto;
    }

    public void recalcularSaldo() {

        saldo = 0.0;

        for (int i = 0; i < recargas.size(); i++) {
            saldo = saldo + recargas.get(i).getMonto();
        }

        for (int i = 0; i < compras.size(); i++) {
            saldo = saldo - compras.get(i).getPrecio();
        }
    }

    public void mostrarHistorial() {

        if (recargas.isEmpty() && compras.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        System.out.println("===== RECARGAS =====");

        for (Recarga recarga : recargas) {
            System.out.println(recarga);
        }

        System.out.println("\n===== COMPRAS =====");

        for (Compra compra : compras) {
            System.out.println(compra);
        }

        System.out.println("\nSaldo actual: $" + saldo);
    }

    @Override
    public String toString() {
        return "El historial contiene "
                + recargas.size()
                + " recargas y "
                + compras.size()
                + " compras. El saldo actual es de $"
                + saldo + ".";
    }
}