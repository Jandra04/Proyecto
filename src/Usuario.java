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
    private Coleccion coleccionUsuario; // referencias a canciones compradas del catálogo
    private HistorialMovimientos historial; // saldo = historial.getSaldo()
    private ArrayList<ListaReproduccion> listasReproduccion; // listas del usuario
    private ColaReproduccion colaReproduccion; // cola de reproducción del usuario

    public Usuario(String nombreCompleto, LocalDate fechaNacimiento, String nacionalidad, String cedula, String avatar,
                   String correoElectronico, String nombreUsuario, String contrasenia) {
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

    public void mostrarListas() {
        System.out.println("Listas de reproducción de " + getNombreUsuario());
        for (int i = 0; i < listasReproduccion.size(); i++) {
            System.out.println(listasReproduccion.get(i));
        }
    }

    public void recargarSaldo(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
            return;
        }
        historial.registrarRecarga(monto);
        System.out.println("Recarga de $" + monto + " registrada. Saldo actual: $" + historial.getSaldo());
    }


    public boolean calificarCancion(Cancion c, double valor) {
        if (!tieneCancion(c)) {
            System.out.println("Solo puedes calificar canciones que hayas comprado.");
            return false;
        }
        return c.calificar(valor);
    }

    public void reproducirLista(ListaReproduccion l) {

        if (l == null) {
            System.out.println("La lista no existe.");
            return;
        }
        System.out.println(getNombreUsuario() + " reproduce la lista " + l);
    }

    public void reproducirCola() {
        if (colaReproduccion.getCanciones().isEmpty()) {
            System.out.println("La cola de reproducción está vacía.");
            return;
        }
        for (int i = 0; i < colaReproduccion.getCanciones().size(); i++) {
            Cancion c = colaReproduccion.getCanciones().get(i);
            if (c != null) {
                reproducirCancion(c);
            }
        }
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

    private String getContrasenia() {
        return contrasenia;
    }

    private void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean verificarContrasenia(String intento) {
        return intento != null && intento.equals(getContrasenia());
    }

    public Coleccion getColeccionUsuario() {
        return coleccionUsuario;
    }

    public void setColeccionUsuario(Coleccion coleccionUsuario) {
        this.coleccionUsuario = coleccionUsuario;
    }

    public HistorialMovimientos getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialMovimientos historial) {
        this.historial = historial;
    }

    public double getSaldo() {
        return historial.getSaldo();
    }

    public ArrayList<ListaReproduccion> getListasReproduccion() {
        return listasReproduccion;
    }

    public void setListasReproduccion(ArrayList<ListaReproduccion> listasReproduccion) {
        this.listasReproduccion = listasReproduccion;
    }

    public ColaReproduccion getColaReproduccion() {
        return colaReproduccion;
    }

    public void setColaReproduccion(ColaReproduccion colaReproduccion) {
        this.colaReproduccion = colaReproduccion;
    }

    public boolean esMayorDeEdad() {
        if (getFechaNacimiento() == null) {
            return false;
        }
        return 18 <= ChronoUnit.YEARS.between(getFechaNacimiento(), LocalDate.now());
    }

    public boolean contraseniaEsValida(String contrasenia) {
        return contrasenia != null
                && 8 <= contrasenia.length() && contrasenia.length() <= 12
                && contrasenia.matches(".*[A-Z].*") // al menos una mayuscula
                && contrasenia.matches(".*[a-z].*") // al menos una minuscula
                && contrasenia.matches(".*[0-9].*") // al menos un numero
                && contrasenia.matches(".*[^a-zA-Z0-9 ].*"); // al menos un caracter especial
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

    public void agregarACola(Cancion c) {
        if (c == null || !tieneCancion(c)) {
            System.out.println("La canción no está en tu colección. Cómprala primero.");
            return;
        }
        colaReproduccion.agregarCancion(c);
    }

    public boolean comprarCancion(Cancion c) {
        if (c == null) {
            return false;
        }
        if (tieneCancion(c)) {
            System.out.println("Ya tienes esa canción en tu colección.");
            return false;
        }
        double precio = c.getPrecio();
        if (getSaldo() < precio) {
            System.out.println("Saldo insuficiente. Tiene $" + getSaldo() + ", cuesta $" + precio);
            return false;
        }
        historial.registrarCompra(nombreUsuario, c);
        coleccionUsuario.agregarCancion(c);
        System.out.println(nombreUsuario + " ha comprado " + c + " exitosamente. Saldo restante: $" + getSaldo());
        return true;
    }

    public ListaReproduccion crearLista(String nombre) {
        ListaReproduccion l = new ListaReproduccion(nombre, LocalDate.now());
        listasReproduccion.addLast(l);
        System.out.println("Lista \"" + nombre + "\" creada.");
        return l;
    }

    public boolean agregarCancionALista(ListaReproduccion l, Cancion c) {
        if (l == null || c == null) {
            return false;
        }
        if (!tieneCancion(c)) {
            System.out.println("Solo puedes agregar a una lista canciones que hayas comprado.");
            return false;
        }
        l.agregarCancion(c);
        return true;
    }

    public ArrayList<Cancion> buscarEnColeccionPorNombre(String nombre) {
        return coleccionUsuario.buscarPorNombre(nombre);
    }

    public ArrayList<Cancion> buscarEnColeccionPorGenero(String genero) {
        return coleccionUsuario.buscarPorGenero(genero);
    }

    public ArrayList<Cancion> buscarEnColeccionPorArtista(String artista) {
        return coleccionUsuario.buscarPorArtista(artista);
    }

    public ArrayList<ListaReproduccion> buscarListasPorNombre(String nombre) {
        ArrayList<ListaReproduccion> resultado = new ArrayList<>();
        if (nombre == null) {
            return resultado;
        }
        for (int i = 0; i < listasReproduccion.size(); i++) {
            ListaReproduccion l = listasReproduccion.get(i);
            if (l.getNombre() != null && l.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.addLast(l);
            }
        }
        return resultado;
    }


    public ListaReproduccion buscarListaPorNombre(String nombre) {
        ArrayList<ListaReproduccion> resultado = buscarListasPorNombre(nombre);
        if (resultado.isEmpty()) {
            return null;
        }
        return resultado.get(0);
    }

    public boolean tieneCancion(Cancion c) {
        return c != null && coleccionUsuario.indiceDe(c) != -1;
    }

    public void reproducirCancion(Cancion c) {
        if (c == null) {
            System.out.println("La canción no existe.");
            return;
        }
        if (tieneCancion(c)) {
            System.out.println("Reproduciendo completa: " + c);
        } else {
            System.out.println("Reproduciendo 30 segundos de prueba: " + c);
        }
    }

    @Override
    public String toString() {
        return "Usuario"
                + "\nNombre completo: " + nombreCompleto
                + "\nUsuario: " + nombreUsuario
                + "\nCorreo: " + correoElectronico
                + "\nNacionalidad: " + nacionalidad
                + "\nCédula: " + cedula
                + "\nFecha de nacimiento: " + fechaNacimiento
                + "\nAvatar: " + avatar
                + "\nSaldo: $" + getSaldo()
                + "\nListas de reproducción: " + listasReproduccion.size()
                + "\nCanciones compradas: " + coleccionUsuario.getCantidad();
    }
}
