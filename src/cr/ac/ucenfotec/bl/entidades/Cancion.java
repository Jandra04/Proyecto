package cr.ac.ucenfotec.bl.entidades;

import java.time.LocalDate;

public class Cancion {

    // atributos
    private String nombre;
    private LocalDate fechaLanzamiento;
    private double precio;
    private String rutaAudio;

    // Datos relacionados con la canción
    private Genero genero;
    private Artista artista;
    private Compositor compositor;
    private Album album;
    private Calificacion registroCalificaciones;

    // Datos para los Top 3
    private int vecesComprada;
    private int vecesAgregadaAListas;

    // Constructor
    public Cancion(String nombre,
                   LocalDate fechaLanzamiento,
                   double precio,
                   String rutaAudio,
                   Genero genero,
                   Artista artista,
                   Compositor compositor,
                   Album album) {

        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.rutaAudio = rutaAudio;
        this.genero = genero;
        this.artista = artista;
        this.compositor = compositor;
        this.album = album;
        this.registroCalificaciones = new Calificacion();
        this.vecesComprada = 0;
        this.vecesAgregadaAListas = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public String getRutaAudio() {
        return rutaAudio;
    }

    public Genero getGenero() {
        return genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public Compositor getCompositor() {
        return compositor;
    }

    public Album getAlbum() {
        return album;
    }

    public Calificacion getRegistroCalificaciones() {
        return registroCalificaciones;
    }

    public double getCalificacion() {
        return registroCalificaciones.getPromedio();
    }

    public int getVecesComprada() {
        return vecesComprada;
    }

    public int getVecesAgregadaAListas() {
        return vecesAgregadaAListas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setRutaAudio(String rutaAudio) {
        this.rutaAudio = rutaAudio;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    // Agrega una calificación
    public boolean calificar(double valor) {
        return registroCalificaciones.agregar(valor);
    }

    // Registra una compra de la canción
    public void registrarCompra() {
        vecesComprada++;
    }

    // Registra que la canción fue agregada a una lista
    public void registrarAgregadaALista() {
        vecesAgregadaAListas++;
    }

    // Registra que la canción fue eliminada de una lista
    public void registrarEliminadaDeLista() {

        if (vecesAgregadaAListas > 0) {
            vecesAgregadaAListas--;
        }
    }

    // Muestra la información de la canción
    @Override
    public String toString() {

        return "Canción"
                + "\nNombre: " + nombre
                + "\nFecha de lanzamiento: " + fechaLanzamiento
                + "\nCalificación: "
                + String.format("%.1f", getCalificacion())
                + "\nPrecio: $"
                + String.format("%.2f", precio)
                + "\nGénero: " + genero.getNombre()
                + "\ncr.ac.ucenfotec.bl.entidades.Artista: " + artista.getNombre()
                + "\ncr.ac.ucenfotec.bl.entidades.Compositor: " + compositor.getNombre()
                + "\nÁlbum: "
                + (album != null
                ? album.getNombre()
                : "Sencillo");
    }
}