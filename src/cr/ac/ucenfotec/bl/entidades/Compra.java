package cr.ac.ucenfotec.bl.entidades;

import java.time.LocalDate;

public class Compra {

    // Atributos
    private Usuario usuario;
    private Cancion cancion;
    private double precio;
    private LocalDate fecha;

    // Constructor
    public Compra(Usuario usuario,
                  Cancion cancion,
                  double precio) {

        this.usuario = usuario;
        this.cancion = cancion;
        this.precio = precio;
        this.fecha = LocalDate.now();
    }

    // Getters
    public Usuario getUsuario() {
        return usuario;
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

    // Muestra la información de la compra
    @Override
    public String toString() {

        return usuario.getNombreUsuario()
                + " compró la canción "
                + cancion.getNombre()
                + " por $"
                + String.format("%.2f", precio)
                + " el "
                + fecha
                + ".";
    }
}