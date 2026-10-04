import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Usuario {

    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String cedula;
    private String avatar;
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;

    private Coleccion coleccionUsuario;
    private HistorialMovimientos historial;
    private ArrayList<ListaReproduccion> listasReproduccion;
    private ColaReproduccion colaReproduccion;

    public Usuario(
            String nombreCompleto,
            LocalDate fechaNacimiento,
            String nacionalidad,
            String cedula,
            String avatar,
            String correoElectronico,
            String nombreUsuario,
            String contrasenia) {

        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.cedula = cedula;
        this.avatar = avatar;
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;

        this.coleccionUsuario = new Coleccion();
        this.historial = new HistorialMovimientos();
        this.listasReproduccion = new ArrayList<>();
        this.colaReproduccion = new ColaReproduccion();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Coleccion getColeccionUsuario() {
        return coleccionUsuario;
    }

    public void setColeccionUsuario(
            Coleccion coleccionUsuario) {

        this.coleccionUsuario = coleccionUsuario;
    }

    public HistorialMovimientos getHistorial() {
        return historial;
    }

    public void setHistorial(
            HistorialMovimientos historial) {

        this.historial = historial;
    }

    public ArrayList<ListaReproduccion>
    getListasReproduccion() {

        return listasReproduccion;
    }

    public void setListasReproduccion(
            ArrayList<ListaReproduccion>
                    listasReproduccion) {

        this.listasReproduccion =
                listasReproduccion;
    }

    public ColaReproduccion getColaReproduccion() {
        return colaReproduccion;
    }

    public void setColaReproduccion(
            ColaReproduccion colaReproduccion) {

        this.colaReproduccion =
                colaReproduccion;
    }

    public double getSaldo() {
        return historial.getSaldo();
    }

    public boolean esMayorDeEdad() {

        return ChronoUnit.YEARS.between(
                fechaNacimiento,
                LocalDate.now()
        ) >= 18;
    }

    public boolean verificarContrasenia(
            String intento) {

        return intento != null
                && intento.equals(contrasenia);
    }

    public boolean contraseniaEsValida(
            String contrasenia) {

        return contrasenia != null
                && contrasenia.length() >= 8
                && contrasenia.length() <= 12
                && contrasenia.matches(".*[A-Z].*")
                && contrasenia.matches(".*[a-z].*")
                && contrasenia.matches(".*[0-9].*")
                && contrasenia.matches(
                ".*[^a-zA-Z0-9 ].*"
        );
    }

    public boolean cambiarContrasenia(
            String actual,
            String nueva1,
            String nueva2) {

        if (!verificarContrasenia(actual)) {

            System.out.println(
                    "La contraseña actual es incorrecta."
            );

            return false;
        }

        if (!nueva1.equals(nueva2)) {

            System.out.println(
                    "Las contraseñas nuevas no coinciden."
            );

            return false;
        }

        if (!contraseniaEsValida(nueva1)) {

            System.out.println(
                    "La contraseña nueva no cumple los requisitos."
            );

            return false;
        }

        if (nueva1.equals(contrasenia)) {

            System.out.println(
                    "La contraseña nueva debe ser distinta a la actual."
            );

            return false;
        }

        contrasenia = nueva1;

        System.out.println(
                "La contraseña se ha cambiado exitosamente."
        );

        return true;
    }

    public void recargarSaldo(double monto) {

        if (monto <= 0) {

            System.out.println(
                    "El monto debe ser positivo."
            );

            return;
        }

        historial.registrarRecarga(monto);

        System.out.println(
                "Se realizó una recarga de $"
                        + monto
                        + ". Saldo actual: $"
                        + getSaldo()
        );
    }

    public boolean tieneCancion(Cancion cancion) {

        return cancion != null
                && coleccionUsuario.indiceDe(cancion)
                != -1;
    }

    public boolean comprarCancion(
            Cancion cancion) {

        if (cancion == null) {
            return false;
        }

        if (tieneCancion(cancion)) {

            System.out.println(
                    "Ya tienes esa canción en tu colección."
            );

            return false;
        }

        if (getSaldo() < cancion.getPrecio()) {

            System.out.println(
                    "Saldo insuficiente. Tiene $"
                            + getSaldo()
                            + " y la canción cuesta $"
                            + cancion.getPrecio()
            );

            return false;
        }

        historial.registrarCompra(
                nombreUsuario,
                cancion,
                cancion.getPrecio()
        );

        coleccionUsuario.agregarCancion(
                cancion
        );

        System.out.println(
                nombreUsuario
                        + " compró "
                        + cancion.getNombre()
                        + ". Saldo restante: $"
                        + getSaldo()
        );

        return true;
    }

    public ListaReproduccion crearLista(
            String nombre) {

        ListaReproduccion lista =
                new ListaReproduccion(
                        nombre,
                        LocalDate.now()
                );

        listasReproduccion.add(lista);

        System.out.println(
                "La lista \"" + nombre
                        + "\" fue creada."
        );

        return lista;
    }

    public boolean agregarCancionALista(
            ListaReproduccion lista,
            Cancion cancion) {

        if (lista == null || cancion == null) {
            return false;
        }

        if (!tieneCancion(cancion)) {

            System.out.println(
                    "Solo puedes agregar a una lista canciones que hayas comprado."
            );

            return false;
        }

        lista.agregarCancion(cancion);

        return true;
    }

    public void mostrarListas() {

        System.out.println(
                "Listas de reproducción de "
                        + nombreUsuario
        );

        for (ListaReproduccion lista :
                listasReproduccion) {

            System.out.println(lista);
        }
    }

    public ArrayList<Cancion>
    buscarEnColeccionPorNombre(
            String nombre) {

        return coleccionUsuario
                .buscarPorNombre(nombre);
    }

    public ArrayList<Cancion>
    buscarEnColeccionPorGenero(
            String genero) {

        return coleccionUsuario
                .buscarPorGenero(genero);
    }

    public ArrayList<Cancion>
    buscarEnColeccionPorArtista(
            String artista) {

        return coleccionUsuario
                .buscarPorArtista(artista);
    }

    public ArrayList<ListaReproduccion>
    buscarListasPorNombre(
            String nombre) {

        ArrayList<ListaReproduccion>
                resultado = new ArrayList<>();

        if (nombre == null) {
            return resultado;
        }

        for (ListaReproduccion lista :
                listasReproduccion) {

            if (lista.getNombre() != null
                    && lista.getNombre()
                    .toLowerCase()
                    .contains(
                            nombre.toLowerCase()
                    )) {

                resultado.add(lista);
            }
        }

        return resultado;
    }

    public ListaReproduccion
    buscarListaPorNombre(
            String nombre) {

        ArrayList<ListaReproduccion>
                resultado =
                buscarListasPorNombre(nombre);

        if (resultado.isEmpty()) {
            return null;
        }

        return resultado.get(0);
    }

    public void agregarACola(
            Cancion cancion) {

        if (!tieneCancion(cancion)) {

            System.out.println(
                    "La canción no está en tu colección. Cómprala primero."
            );

            return;
        }

        colaReproduccion
                .agregarCancion(cancion);
    }

    public void reproducirCola() {

        if (colaReproduccion
                .getCanciones()
                .isEmpty()) {

            System.out.println(
                    "La cola de reproducción está vacía."
            );

            return;
        }

        for (Cancion cancion :
                colaReproduccion
                        .getCanciones()) {

            reproducirCancion(cancion);
        }
    }

    public void reproducirCancion(
            Cancion cancion) {

        if (cancion == null) {

            System.out.println(
                    "La canción no existe."
            );

            return;
        }

        if (tieneCancion(cancion)) {

            System.out.println(
                    "Reproduciendo completa: "
                            + cancion.getNombre()
            );

        } else {

            System.out.println(
                    "Reproduciendo 30 segundos de prueba: "
                            + cancion.getNombre()
            );
        }
    }

    public void reproducirLista(
            ListaReproduccion lista) {

        if (lista == null) {

            System.out.println(
                    "La lista no existe."
            );

            return;
        }

        System.out.println(
                nombreUsuario
                        + " reproduce la lista "
                        + lista.getNombre()
        );
    }

    @Override
    public String toString() {

        return "El usuario "
                + nombreUsuario
                + " pertenece a "
                + nombreCompleto
                + ", su nacionalidad es "
                + nacionalidad
                + " y actualmente tiene un saldo de $"
                + getSaldo() + ".";
    }
}