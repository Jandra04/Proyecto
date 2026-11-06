package cr.ac.ucenfotec.bl.entidades;

public class Administrador extends Cuenta {

    // Constructor
    public Administrador(String correoElectronico,
                         String nombreUsuario,
                         String contrasenia) {

        super(correoElectronico, nombreUsuario, contrasenia);
    }

    // Muestra las listas de reproducción de un usuario
    public void mostrarListasUsuario(Usuario usuario) {

        if (usuario == null) {
            return;
        }

        usuario.mostrarListas();
    }

    // Reproduce una canción completa
    @Override
    public void reproducirCancion(Cancion cancion) {

        if (cancion == null) {
            return;
        }

        System.out.println(
                "Reproduciendo "
                        + cancion.getNombre()
                        + " completa."
        );
    }

    // Reproduce una lista completa
    public void reproducirLista(ListaReproduccion lista) {

        if (lista == null) {
            return;
        }

        for (Cancion cancion : lista.getCanciones()) {
            reproducirCancion(cancion);
        }
    }

    // Muestra la información principal del administrador
    @Override
    public String toString() {

        return super.toString()
                + "\nTipo de cuenta: Administrador";
    }
}