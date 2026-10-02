import java.time.LocalDate;

public class Cancion {

    private String nombre;
    private LocalDate fechaLanzamiento;
    private double calificacion;
    private double precio;
    private Genero genero;
    private Artista artista;
    private Compositor compositor;
    private Album album;

    public Cancion(String nombre,  LocalDate fechaLanzamiento,
                   double calificacion, double precio,
                   Genero genero, Artista artista,
                   Compositor compositor,  Album album){

    this.nombre = nombre;
    this.fechaLanzamiento = fechaLanzamiento;
    this.calificacion = calificacion;
    this.precio = precio;
    this.genero = genero;
    this.artista = artista;
    this.compositor = compositor;
    this.album = album;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public LocalDate getFechaLanzamiento(){
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento){
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getCalificacion(){
        return calificacion;
    }

    public void setCalificacion(double calificacion){
        this.calificacion = calificacion;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public Genero getGenero(){
        return genero;
    }

    public void setGenero(Genero genero){
        this.genero = genero;
    }

    public Artista getArtista(){
        return artista;
    }

    public void setArtista(Artista artista){
        this.artista = artista;
    }

    public Compositor getCompositor(){
        return compositor;
    }

    public void setCompositor(Compositor compositor){
        this.compositor = compositor;
    }

    public Album getAlbum(){
        return album;
    }

    public void setAlbum(Album album){
        this.album = album;
    }

    @Override
    public String toString(){
        return "Cancion"
                + "\nNombre: " + nombre +
                "\nFecha de lanzamiento: " + fechaLanzamiento +
                "\nCalificacion: " + calificacion +
                "\nPrecio: $ " + precio +
                "\nGenero: " + genero.getNombre() +
                "\nArtista: " + artista.getNombre() +
                "\nCompositor: " + compositor.getNombre() +
                "\nAlbum: " + (album != null ? album.getNombre() : "Sencillo");
    }
    }