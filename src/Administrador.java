public class Administrador {
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;
    private ColaReproduccion colaReproduccion = new ColaReproduccion();

    public Administrador(String correoElectronico, String nombreUsuario, String contrasenia) {
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    private String getContrasenia() {
        return contrasenia;
    }

    private void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean verificarContrasenia(String intento) {
        return intento != null && intento.equals(getContrasenia());
    }
    
    public boolean contraseniaEsValida(String contrasenia) {
        return contrasenia != null
                && 8 <= contrasenia.length() && contrasenia.length() <= 12
                && contrasenia.matches(".*[A-Z].*")
                && contrasenia.matches(".*[a-z].*")
                && contrasenia.matches(".*[0-9].*")
                && contrasenia.matches(".*[^a-zA-Z0-9 ].*");
    }

    public boolean cambiarContrasenia(String actual, String nueva1, String nueva2) {
        if (!verificarContrasenia(actual)) {
            System.out.println("La contraseña actual es incorrecta.");
            return false;
        }
        if (!nueva1.equals(nueva2)) {
            System.out.println("Las contraseñas nuevas no coinciden.");
            return false;
        }
        if (!contraseniaEsValida(nueva1)) {
            System.out.println("La contraseña nueva no cumple los requisitos.");
            return false;
        }
        if (nueva1.equals(getContrasenia())) {
            System.out.println("La contraseña nueva debe ser distinta a la actual.");
            return false;
        }
        setContrasenia(nueva1);
        System.out.println("La contraseña se ha cambiado exitosamente.");
        return true;
    }


    // TODO: descomentar cuando Aplicacion, Cancion y ListaReproduccion estén listas.

    // public void subirCancion(Aplicacion app, Cancion c) {
    //     if (app == null || c == null) {
    //         System.out.println("No se pudo subir la canción.");
    //         return;
    //     }
    //     app.agregarCancionAlCatalogo(c);
    //     System.out.println("Canción subida al catálogo: " + c);
    // }

    // public void reproducirCancion(Cancion c) {
    //     if (c == null) {
    //         System.out.println("La canción no existe.");
    //         return;
    //     }
    //     System.out.println("Reproduciendo completa: " + c);
    // }


    // public void reproducirLista(ListaReproduccion l) {
    //     if (l == null) {
    //         System.out.println("La lista no existe.");
    //         return;
    //     }
    //     System.out.println("Reproduciendo lista: " + l);
    // }


    // public void agregarACola(Cancion c) {
    //     if (c != null) {
    //         colaReproduccion.agregarCancion(c);
    //     }
    // }

    // public void reproducirCola() {
    //     if (colaReproduccion.getCanciones().isEmpty()) {
    //         System.out.println("La cola de reproducción está vacía.");
    //         return;
    //     }
    //     for (int i = 0; i < colaReproduccion.getCanciones().size(); i++) {
    //         reproducirCancion(colaReproduccion.getCanciones().get(i));
    //     }
    // }


    // public ArrayList<Cancion> buscarCancionPorNombre(Aplicacion app, String nombre) {
    //     return app.buscarCancionPorNombre(nombre);
    // }

    // public ArrayList<Cancion> buscarCancionPorGenero(Aplicacion app, String genero) {
    //     return app.buscarCancionPorGenero(genero);
    // }

    // public ArrayList<Cancion> buscarCancionPorArtista(Aplicacion app, String artista) {
    //     return app.buscarCancionPorArtista(artista);
    // }

    // public ArrayList<ListaReproduccion> buscarListaPorNombre(Aplicacion app, String nombre) {
    //     return app.buscarListaPorNombre(nombre);
    // }

    @Override
    public String toString() {
        return "Administrador"
                + "\nUsuario: " + nombreUsuario
                + "\nCorreo: " + correoElectronico
                + "\nCanciones en cola: " + colaReproduccion.getCanciones().size();
    }
}
