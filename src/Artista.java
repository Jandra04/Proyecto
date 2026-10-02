public class Artista {

    private String nombre;

    public Artista(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // Identidad de negocio: mismo nombre (sin distinguir mayusculas).
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Artista)) {
            return false;
        }
        Artista otra = (Artista) o;
        return nombre.equalsIgnoreCase(otra.nombre);
    }

    @Override
    public String toString(){
        return "Artista" +
                "\nNombre: " + nombre;
    }
}
