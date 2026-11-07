package cr.ac.ucenfotec.bl.entidades;

import cr.ac.ucenfotec.bl.excepciones.SaldoInsuficienteException;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Usuario extends Cuenta {

    // Atributos
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String cedula;
    private String avatar;
    private Coleccion coleccionUsuario;
    private HistorialMovimientos historial;
    private ArrayList<ListaReproduccion> listasReproduccion;
    private ColaReproduccion colaReproduccion;

    // Constructor
    public Usuario(String correoElectronico,
                   String nombreUsuario,
                   String contrasenia,
                   String nombreCompleto,
                   LocalDate fechaNacimiento,
                   String nacionalidad,
                   String cedula,
                   String avatar) {

        super(correoElectronico, nombreUsuario, contrasenia);

        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.cedula = cedula;
        this.avatar = avatar;
        this.coleccionUsuario = new Coleccion();
        this.historial = new HistorialMovimientos();
        this.listasReproduccion = new ArrayList<>();
        this.colaReproduccion = new ColaReproduccion();
    }

    // Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getAvatar() {
        return avatar;
    }

    public Coleccion getColeccionUsuario() {
        return coleccionUsuario;
    }

    public HistorialMovimientos getHistorial() {
        return historial;
    }

    public ArrayList<ListaReproduccion> getListasReproduccion() {
        return listasReproduccion;
    }

    public ColaReproduccion getColaReproduccion() {
        return colaReproduccion;
    }

    public double getSaldo() {
        return historial.getSaldo();
    }

    // Setters
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    // Verifica si el usuario es mayor de edad
    public boolean esMayorDeEdad() {

        if (fechaNacimiento == null) {
            return false;
        }

        int edad = Period.between(
                fechaNacimiento,
                LocalDate.now()
        ).getYears();

        return edad >= 18;
    }

    // Realiza una recarga de saldo
    public void recargarSaldo(double monto) {
        historial.registrarRecarga(monto);
    }

    // Verifica si el usuario tiene una canción
    public boolean tieneCancion(Cancion cancion) {
        return coleccionUsuario.contieneCancion(cancion);
    }

    // Compra una canción
    // Compra una canción
    public boolean comprarCancion(Cancion cancion)
            throws SaldoInsuficienteException {

        if (cancion == null) {
            return false;
        }

        if (tieneCancion(cancion)) {
            return false;
        }

        historial.registrarCompra(
                this,
                cancion,
                cancion.getPrecio()
        );

        coleccionUsuario.agregarCancion(cancion);

        cancion.registrarCompra();

        return true;
    }

    // Califica una canción de la colección
    public boolean calificarCancion(Cancion cancion,
                                    double calificacion) {

        if (!tieneCancion(cancion)) {
            return false;
        }

        return cancion.calificar(calificacion);
    }

    // Crea una lista de reproducción
    public boolean crearLista(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            return false;
        }

        if (buscarListaPorNombre(nombre) != null) {
            return false;
        }

        ListaReproduccion lista =
                new ListaReproduccion(nombre);

        listasReproduccion.add(lista);

        return true;
    }

    // Agrega una canción a una lista
    public boolean agregarCancionALista(String nombreLista,
                                        Cancion cancion) {

        ListaReproduccion lista =
                buscarListaPorNombre(nombreLista);

        if (lista == null || cancion == null) {
            return false;
        }

        if (!tieneCancion(cancion)) {
            return false;
        }

        return lista.agregarCancion(cancion);
    }

    // Busca una lista por nombre
    public ListaReproduccion buscarListaPorNombre(String nombre) {

        for (ListaReproduccion lista : listasReproduccion) {

            if (lista.getNombre().equalsIgnoreCase(nombre)) {
                return lista;
            }
        }

        return null;
    }

    // Busca listas que contengan el texto indicado
    public ArrayList<ListaReproduccion> buscarListasPorNombre(
            String nombre) {

        ArrayList<ListaReproduccion> resultados =
                new ArrayList<>();

        for (ListaReproduccion lista : listasReproduccion) {

            if (lista.getNombre()
                    .toLowerCase()
                    .contains(nombre.toLowerCase())) {

                resultados.add(lista);
            }
        }

        return resultados;
    }

    // Muestra las listas del usuario
    public void mostrarListas() {

        if (listasReproduccion.isEmpty()) {
            System.out.println(
                    "No hay listas de reproducción."
            );
            return;
        }

        for (ListaReproduccion lista : listasReproduccion) {
            System.out.println(lista);
        }
    }

    // Busca canciones por nombre en la colección
    public ArrayList<Cancion> buscarEnColeccionPorNombre(
            String nombre) {

        return coleccionUsuario.buscarPorNombre(nombre);
    }

    // Busca canciones por género en la colección
    public ArrayList<Cancion> buscarEnColeccionPorGenero(
            String genero) {

        return coleccionUsuario.buscarPorGenero(genero);
    }

    // Busca canciones por artista en la colección
    public ArrayList<Cancion> buscarEnColeccionPorArtista(
            String artista) {

        return coleccionUsuario.buscarPorArtista(artista);
    }

    // Agrega una canción a la cola
    public boolean agregarACola(Cancion cancion) {

        if (cancion == null) {
            return false;
        }

        colaReproduccion.agregarCancion(cancion);

        return true;
    }

    // Reproduce las canciones de la cola
    public void reproducirCola() {

        if (colaReproduccion.estaVacia()) {
            System.out.println(
                    "La cola de reproducción está vacía."
            );
            return;
        }

        while (!colaReproduccion.estaVacia()) {

            Cancion cancion =
                    colaReproduccion.obtenerSiguiente();

            reproducirCancion(cancion);
        }
    }

    // Reproduce una canción
    @Override
    public void reproducirCancion(Cancion cancion) {

        if (cancion == null) {
            return;
        }

        if (tieneCancion(cancion)) {

            System.out.println(
                    "Reproduciendo "
                            + cancion.getNombre()
                            + " completa."
            );

        } else {

            System.out.println(
                    "Reproduciendo vista previa de 30 segundos de "
                            + cancion.getNombre()
                            + "."
            );
        }
    }

    // Reproduce una lista
    public void reproducirLista(
            ListaReproduccion lista) {

        if (lista == null) {
            return;
        }

        for (Cancion cancion : lista.getCanciones()) {
            reproducirCancion(cancion);
        }
    }

    // Muestra la información principal del usuario
    @Override
    public String toString() {

        return super.toString()
                + "\nNombre completo: "
                + nombreCompleto
                + "\nNacionalidad: "
                + nacionalidad
                + "\nCédula: "
                + cedula
                + "\nSaldo: $"
                + String.format("%.2f", getSaldo());
    }
}