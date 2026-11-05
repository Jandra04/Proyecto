import java.time.LocalDate;

public class Compra {

    private String nombreUsuario;
    private Cancion cancion;
    private double precio;
    private LocalDate fecha;

    public Compra(String nombreUsuario, Cancion cancion, double precio) {
        this.nombreUsuario = nombreUsuario;
        this.cancion = cancion;
        this.precio = precio;
        this.fecha = LocalDate.now();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return nombreUsuario + " compró la canción "
                + cancion.getNombre()
                + " por $" + precio
                + " el " + fecha + ".";
    }
}