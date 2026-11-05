public class Compositor {

    private String nombre;

    public Compositor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setnombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Compositor" +
                "\nNombre: " + nombre;
    }
}
