public class Album {

    private String nombre;

    public Album(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Album" +
                "\nNombre: " + nombre;
    }
}
