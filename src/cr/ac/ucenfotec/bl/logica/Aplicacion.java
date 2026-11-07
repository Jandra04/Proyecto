package cr.ac.ucenfotec.bl.logica;

import cr.ac.ucenfotec.bl.interfaces.Buscable;
import cr.ac.ucenfotec.bl.entidades.Administrador;
import cr.ac.ucenfotec.bl.entidades.Cancion;
import cr.ac.ucenfotec.bl.entidades.Cuenta;
import cr.ac.ucenfotec.bl.entidades.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
public class Aplicacion implements Buscable {

    // Atributos
    private Administrador administrador;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Cancion> catalogo;

    // Constructor
    public Aplicacion(Administrador administrador) {
        this.administrador = administrador;
        this.usuarios = new ArrayList<>();
        this.catalogo = new ArrayList<>();
    }

    // Getters
    public Administrador getAdministrador() {
        return administrador;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Cancion> getCatalogo() {
        return catalogo;
    }

    // Registra un nuevo usuario
    public boolean registrarUsuario(String correoElectronico,
                                    String nombreUsuario,
                                    String contrasenia,
                                    String nombreCompleto,
                                    LocalDate fechaNacimiento,
                                    String nacionalidad,
                                    String cedula,
                                    String avatar) {

        if (correoElectronico == null
                || correoElectronico.isBlank()
                || nombreUsuario == null
                || nombreUsuario.isBlank()
                || contrasenia == null
                || contrasenia.isBlank()
                || nombreCompleto == null
                || nombreCompleto.isBlank()) {

            return false;
        }

        if (administrador.getNombreUsuario()
                .equalsIgnoreCase(nombreUsuario)) {

            return false;
        }

        if (buscarUsuario(nombreUsuario) != null) {
            return false;
        }

        Usuario nuevoUsuario =
                new Usuario(
                        correoElectronico,
                        nombreUsuario,
                        contrasenia,
                        nombreCompleto,
                        fechaNacimiento,
                        nacionalidad,
                        cedula,
                        avatar
                );

        if (!nuevoUsuario.esMayorDeEdad()) {
            return false;
        }

        if (!nuevoUsuario.contraseniaEsValida(contrasenia)) {
            return false;
        }

        usuarios.add(nuevoUsuario);

        return true;
    }

    // Busca un usuario por nombre de usuario
    public Usuario buscarUsuario(String nombreUsuario) {

        if (nombreUsuario == null) {
            return null;
        }

        for (Usuario usuario : usuarios) {

            if (usuario.getNombreUsuario()
                    .equalsIgnoreCase(nombreUsuario)) {

                return usuario;
            }
        }

        return null;
    }

    // Inicia sesión
    public Cuenta iniciarSesion(String nombreUsuario,
                                String contrasenia) {

        if (nombreUsuario == null || contrasenia == null) {
            return null;
        }

        if (administrador.getNombreUsuario()
                .equalsIgnoreCase(nombreUsuario)
                && administrador.verificarContrasenia(contrasenia)) {

            return administrador;
        }

        Usuario usuario =
                buscarUsuario(nombreUsuario);

        if (usuario != null
                && usuario.verificarContrasenia(contrasenia)) {

            return usuario;
        }

        return null;
    }

    // Verifica si es el administrador de la aplicación
    private boolean esAdministrador(Administrador administrador) {

        return administrador != null
                && administrador == this.administrador;
    }

    // Agrega una canción al catálogo
    public boolean agregarCancion(Administrador administrador,
                                  Cancion cancion) {

        if (!esAdministrador(administrador)
                || cancion == null) {

            return false;
        }

        if (catalogo.contains(cancion)) {
            return false;
        }

        catalogo.add(cancion);

        return true;
    }

    // Elimina una canción del catálogo
    public boolean eliminarCancion(Administrador administrador,
                                   Cancion cancion) {

        if (!esAdministrador(administrador)
                || cancion == null) {

            return false;
        }

        return catalogo.remove(cancion);
    }

    // Busca canciones por nombre
    @Override
    public ArrayList<Cancion> buscarPorNombre(String nombre) {

        ArrayList<Cancion> resultados =
                new ArrayList<>();

        if (nombre == null) {
            return resultados;
        }

        for (Cancion cancion : catalogo) {

            if (cancion.getNombre()
                    .toLowerCase()
                    .contains(nombre.toLowerCase())) {

                resultados.add(cancion);
            }
        }

        return resultados;
    }

    // Busca canciones por género
    @Override
    public ArrayList<Cancion> buscarPorGenero(String genero) {

        ArrayList<Cancion> resultados =
                new ArrayList<>();

        if (genero == null) {
            return resultados;
        }

        for (Cancion cancion : catalogo) {

            if (cancion.getGenero()
                    .getNombre()
                    .toLowerCase()
                    .contains(genero.toLowerCase())) {

                resultados.add(cancion);
            }
        }

        return resultados;
    }

    // Busca canciones por artista
    @Override
    public ArrayList<Cancion> buscarPorArtista(String artista) {

        ArrayList<Cancion> resultados =
                new ArrayList<>();

        if (artista == null) {
            return resultados;
        }

        for (Cancion cancion : catalogo) {

            if (cancion.getArtista()
                    .getNombre()
                    .toLowerCase()
                    .contains(artista.toLowerCase())) {

                resultados.add(cancion);
            }
        }

        return resultados;
    }

    // Obtiene las 3 canciones mejor calificadas
    public ArrayList<Cancion> obtenerTop3MejorCalificadas() {

        ArrayList<Cancion> copia =
                new ArrayList<>(catalogo);

        for (int i = 0; i < copia.size() - 1; i++) {

            for (int j = i + 1; j < copia.size(); j++) {

                if (copia.get(j).getCalificacion()
                        > copia.get(i).getCalificacion()) {

                    Cancion temporal = copia.get(i);

                    copia.set(i, copia.get(j));
                    copia.set(j, temporal);
                }
            }
        }

        return limitarTop3(copia);
    }

    // Obtiene las 3 canciones más compradas
    public ArrayList<Cancion> obtenerTop3MasCompradas() {

        ArrayList<Cancion> copia =
                new ArrayList<>(catalogo);

        for (int i = 0; i < copia.size() - 1; i++) {

            for (int j = i + 1; j < copia.size(); j++) {

                if (copia.get(j).getVecesComprada()
                        > copia.get(i).getVecesComprada()) {

                    Cancion temporal = copia.get(i);

                    copia.set(i, copia.get(j));
                    copia.set(j, temporal);
                }
            }
        }

        return limitarTop3(copia);
    }

    // Obtiene las 3 canciones más agregadas a listas
    public ArrayList<Cancion> obtenerTop3MasAgregadasAListas() {

        ArrayList<Cancion> copia =
                new ArrayList<>(catalogo);

        for (int i = 0; i < copia.size() - 1; i++) {

            for (int j = i + 1; j < copia.size(); j++) {

                if (copia.get(j).getVecesAgregadaAListas()
                        > copia.get(i).getVecesAgregadaAListas()) {

                    Cancion temporal = copia.get(i);

                    copia.set(i, copia.get(j));
                    copia.set(j, temporal);
                }
            }
        }

        return limitarTop3(copia);
    }

    // Limita una lista a las primeras 3 canciones
    private ArrayList<Cancion> limitarTop3(
            ArrayList<Cancion> canciones) {

        ArrayList<Cancion> top3 =
                new ArrayList<>();

        int cantidad =
                Math.min(3, canciones.size());

        for (int i = 0; i < cantidad; i++) {
            top3.add(canciones.get(i));
        }

        return top3;
    }

    // Muestra el catálogo
    public void mostrarCatalogo() {

        if (catalogo.isEmpty()) {

            System.out.println(
                    "El catálogo está vacío."
            );

            return;
        }

        for (Cancion cancion : catalogo) {
            System.out.println(cancion);
        }
    }

    // Muestra los usuarios registrados
    public void mostrarUsuarios(
            Administrador administrador) {

        if (!esAdministrador(administrador)) {
            return;
        }

        if (usuarios.isEmpty()) {

            System.out.println(
                    "No hay usuarios registrados."
            );

            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    // Muestra información general de la aplicación
    @Override
    public String toString() {

        return "Aplicación con "
                + usuarios.size()
                + " usuarios y "
                + catalogo.size()
                + " canciones.";
    }
}