import java.util.ArrayList;

// Libro mayor: recargas suman, compras restan. El saldo se mantiene aqui, no en Usuario.
// Sin herencia ni enums: cada tipo de movimiento vive en su propia lista.
public class HistorialMovimientos {
    private final ArrayList<Recarga> recargas;
    private final ArrayList<Compra> compras;
    private double saldo;

    public HistorialMovimientos() {
        recargas = new ArrayList<>();
        compras = new ArrayList<>();
        saldo = 0;
    }

    public void registrarRecarga(double monto) {
        recargas.addLast(new Recarga(monto));
        saldo += monto;
    }

    // TODO: quita monto luego
    public void registrarCompra(String nombreUsuario, Cancion cancion, double monto) {
        compras.addLast(new Compra(nombreUsuario, cancion, monto));
        saldo -= monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void recalcularSaldo() {
        saldo = 0;
        for (int i = 0; i < recargas.size(); i++) {
            saldo = saldo + recargas.get(i).getMonto();
        }
        for (int i = 0; i < compras.size(); i++) {
            saldo = saldo - compras.get(i).getPrecio();
        }
    }

    public ArrayList<Recarga> getRecargas() {
        return new ArrayList<>(recargas);
    }

    public ArrayList<Compra> getCompras() {
        return new ArrayList<>(compras);
    }

    public void mostrarHistorial() {
        if (recargas.isEmpty() && compras.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }
        for (int i = 0; i < recargas.size(); i++) {
            System.out.println(recargas.get(i));
        }
        for (int i = 0; i < compras.size(); i++) {
            System.out.println(compras.get(i));
        }
        System.out.println("Saldo actual: $" + saldo);
    }
}
