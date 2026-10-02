import java.time.LocalDate;

public class Compra {
    private final String nombreUsuario;
    private final Cancion cancion;
    private final double precio; // snapshot del precio al momento de la compra
    private final LocalDate fecha;

    public Compra(String nombreUsuario, Cancion cancion) {
        this.nombreUsuario = nombreUsuario;
        this.cancion = cancion;
        this.precio = cancion.getPrecio();
        this.fecha = LocalDate.now();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return fecha + " " + nombreUsuario + " compró " + cancion + " por $" + precio;
    }
}
