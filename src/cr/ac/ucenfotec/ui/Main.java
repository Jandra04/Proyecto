package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.entidades.*;
import cr.ac.ucenfotec.bl.excepciones.SaldoInsuficienteException;
import cr.ac.ucenfotec.bl.logica.Aplicacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Administrador principal
        Administrador administrador = new Administrador(
                "admin@musica.com",
                "admin",
                "Admin1!x"
        );

        // Aplicación
        Aplicacion aplicacion = new Aplicacion(administrador);

        boolean salir = false;

        while (!salir) {

            System.out.println("\nAplicación de música");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {

                case "1":
                    iniciarSesion(aplicacion);
                    break;

                case "2":
                    registrarUsuario(aplicacion);
                    break;

                case "0":
                    salir = true;
                    System.out.println("Aplicación cerrada.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Registro de usuario
    private static void registrarUsuario(Aplicacion aplicacion) {

        try {

            System.out.println("\nRegistro de usuario");

            System.out.print("Correo electrónico: ");
            String correo = scanner.nextLine();

            System.out.print("Nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contrasenia = scanner.nextLine();

            System.out.print("Nombre completo: ");
            String nombreCompleto = scanner.nextLine();

            System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
            LocalDate fechaNacimiento =
                    LocalDate.parse(scanner.nextLine());

            System.out.print("Nacionalidad: ");
            String nacionalidad = scanner.nextLine();

            System.out.print("Cédula: ");
            String cedula = scanner.nextLine();

            System.out.print("Avatar: ");
            String avatar = scanner.nextLine();

            boolean registrado =
                    aplicacion.registrarUsuario(
                            correo,
                            nombreUsuario,
                            contrasenia,
                            nombreCompleto,
                            fechaNacimiento,
                            nacionalidad,
                            cedula,
                            avatar
                    );

            if (registrado) {
                System.out.println(
                        "Usuario registrado correctamente."
                );
            } else {
                System.out.println(
                        "No se pudo registrar el usuario. Revise los datos."
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "No se pudo completar el registro. Revise los datos."
            );
        }
    }

    // Inicio de sesión
    private static void iniciarSesion(Aplicacion aplicacion) {

        System.out.println("\nInicio de sesión");

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasenia = scanner.nextLine();

        Cuenta cuenta =
                aplicacion.iniciarSesion(
                        nombreUsuario,
                        contrasenia
                );

        if (cuenta == null) {

            System.out.println(
                    "Usuario o contraseña incorrectos."
            );

            return;
        }

        if (cuenta instanceof Administrador) {

            menuAdministrador(
                    aplicacion,
                    (Administrador) cuenta
            );

        } else if (cuenta instanceof Usuario) {

            menuUsuario(
                    aplicacion,
                    (Usuario) cuenta
            );
        }
    }

    // Menú del administrador
    private static void menuAdministrador(
            Aplicacion aplicacion,
            Administrador administrador) {

        boolean cerrarSesion = false;

        while (!cerrarSesion) {

            System.out.println("\nMenú administrador");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar canción");
            System.out.println("3. Eliminar canción");
            System.out.println("4. Ver usuarios registrados");
            System.out.println("5. Reproducir canción");
            System.out.println("6. Ver listas de un usuario");
            System.out.println("7. Ver Top 3");
            System.out.println("0. Cerrar sesión");

            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {

                case "1":
                    aplicacion.mostrarCatalogo();
                    break;

                case "2":
                    agregarCancion(
                            aplicacion,
                            administrador
                    );
                    break;

                case "3":
                    eliminarCancion(
                            aplicacion,
                            administrador
                    );
                    break;

                case "4":
                    aplicacion.mostrarUsuarios(
                            administrador
                    );
                    break;

                case "5":
                    reproducirCancionAdministrador(
                            aplicacion,
                            administrador
                    );
                    break;

                case "6":
                    verListasUsuario(
                            aplicacion,
                            administrador
                    );
                    break;

                case "7":
                    mostrarTop3(aplicacion);
                    break;

                case "0":
                    cerrarSesion = true;
                    break;

                default:
                    System.out.println(
                            "Opción inválida."
                    );
            }
        }
    }

    // Menú del usuario
    private static void menuUsuario(
            Aplicacion aplicacion,
            Usuario usuario) {

        boolean cerrarSesion = false;

        while (!cerrarSesion) {

            System.out.println("\nMenú usuario");

            System.out.println(
                    "Saldo: $"
                            + String.format(
                            "%.2f",
                            usuario.getSaldo()
                    )
            );

            System.out.println("1. Ver catálogo");
            System.out.println("2. Buscar canciones");
            System.out.println("3. Recargar saldo");
            System.out.println("4. Comprar canción");
            System.out.println("5. Ver colección");
            System.out.println("6. Reproducir canción");
            System.out.println("7. Calificar canción");
            System.out.println("8. Listas de reproducción");
            System.out.println("9. Cola de reproducción");
            System.out.println("10. Ver historial");
            System.out.println("11. Cambiar contraseña");
            System.out.println("12. Ver Top 3");
            System.out.println("0. Cerrar sesión");

            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {

                case "1":
                    aplicacion.mostrarCatalogo();
                    break;

                case "2":
                    menuBusqueda(aplicacion);
                    break;

                case "3":
                    recargarSaldo(usuario);
                    break;

                case "4":
                    comprarCancion(
                            aplicacion,
                            usuario
                    );
                    break;

                case "5":
                    usuario
                            .getColeccionUsuario()
                            .mostrarColeccion();
                    break;

                case "6":
                    reproducirCancionUsuario(
                            aplicacion,
                            usuario
                    );
                    break;

                case "7":
                    calificarCancion(usuario);
                    break;

                case "8":
                    menuListas(usuario);
                    break;

                case "9":
                    menuCola(
                            aplicacion,
                            usuario
                    );
                    break;

                case "10":
                    usuario
                            .getHistorial()
                            .mostrarHistorial();
                    break;

                case "11":
                    cambiarContrasenia(usuario);
                    break;

                case "12":
                    mostrarTop3(aplicacion);
                    break;

                case "0":
                    cerrarSesion = true;
                    break;

                default:
                    System.out.println(
                            "Opción inválida."
                    );
            }
        }
    }

    // Agrega una canción al catálogo
    private static void agregarCancion(
            Aplicacion aplicacion,
            Administrador administrador) {

        try {

            System.out.println("\nAgregar canción");

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print(
                    "Fecha de lanzamiento (AAAA-MM-DD): "
            );

            LocalDate fecha =
                    LocalDate.parse(
                            scanner.nextLine()
                    );

            System.out.print("Precio: ");

            double precio =
                    Double.parseDouble(
                            scanner.nextLine()
                    );

            System.out.print("Ruta del audio: ");
            String rutaAudio = scanner.nextLine();

            System.out.print("Género: ");

            Genero genero =
                    new Genero(
                            scanner.nextLine()
                    );

            System.out.print("Artista: ");

            Artista artista =
                    new Artista(
                            scanner.nextLine()
                    );

            System.out.print("Compositor: ");

            Compositor compositor =
                    new Compositor(
                            scanner.nextLine()
                    );

            System.out.print(
                    "Álbum, deje vacío si es sencillo: "
            );

            String nombreAlbum =
                    scanner.nextLine();

            Album album = null;

            if (!nombreAlbum.isBlank()) {

                album =
                        new Album(
                                nombreAlbum
                        );
            }

            Cancion cancion =
                    new Cancion(
                            nombre,
                            fecha,
                            precio,
                            rutaAudio,
                            genero,
                            artista,
                            compositor,
                            album
                    );

            if (aplicacion.agregarCancion(
                    administrador,
                    cancion)) {

                System.out.println(
                        "Canción agregada al catálogo."
                );

            } else {

                System.out.println(
                        "No se pudo agregar la canción."
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "No se pudo agregar la canción. Revise los datos."
            );
        }
    }

    // Elimina una canción
    private static void eliminarCancion(
            Aplicacion aplicacion,
            Administrador administrador) {

        Cancion cancion =
                seleccionarCancion(
                        aplicacion.getCatalogo(),
                        "Seleccione la canción que desea eliminar"
                );

        if (cancion == null) {
            return;
        }

        if (aplicacion.eliminarCancion(
                administrador,
                cancion)) {

            System.out.println(
                    "Canción eliminada del catálogo."
            );

        } else {

            System.out.println(
                    "No se pudo eliminar la canción."
            );
        }
    }

    // Reproduce una canción como administrador
    private static void reproducirCancionAdministrador(
            Aplicacion aplicacion,
            Administrador administrador) {

        Cancion cancion =
                seleccionarCancion(
                        aplicacion.getCatalogo(),
                        "Seleccione una canción"
                );

        if (cancion != null) {

            administrador.reproducirCancion(
                    cancion
            );
        }
    }

    // Permite al administrador ver listas de usuarios
    private static void verListasUsuario(
            Aplicacion aplicacion,
            Administrador administrador) {

        System.out.print(
                "Nombre del usuario: "
        );

        String nombreUsuario =
                scanner.nextLine();

        Usuario usuario =
                aplicacion.buscarUsuario(
                        nombreUsuario
                );

        if (usuario == null) {

            System.out.println(
                    "Usuario no encontrado."
            );

            return;
        }

        administrador.mostrarListasUsuario(
                usuario
        );
    }

    // Menú de búsquedas
    private static void menuBusqueda(
            Aplicacion aplicacion) {

        System.out.println("\nBuscar canciones");
        System.out.println("1. Por nombre");
        System.out.println("2. Por género");
        System.out.println("3. Por artista");

        System.out.print(
                "Seleccione una opción: "
        );

        String opcion =
                scanner.nextLine();

        System.out.print(
                "Texto de búsqueda: "
        );

        String texto =
                scanner.nextLine();

        ArrayList<Cancion> resultados;

        switch (opcion) {

            case "1":
                resultados =
                        aplicacion.buscarPorNombre(
                                texto
                        );
                break;

            case "2":
                resultados =
                        aplicacion.buscarPorGenero(
                                texto
                        );
                break;

            case "3":
                resultados =
                        aplicacion.buscarPorArtista(
                                texto
                        );
                break;

            default:
                System.out.println(
                        "Opción inválida."
                );
                return;
        }

        mostrarCancionesNumeradas(
                resultados
        );
    }

    // Recarga de saldo
    private static void recargarSaldo(
            Usuario usuario) {

        try {

            System.out.print(
                    "Monto de la recarga: "
            );

            double monto =
                    Double.parseDouble(
                            scanner.nextLine()
                    );

            usuario.recargarSaldo(
                    monto
            );

            System.out.println(
                    "Recarga realizada. Saldo actual: $"
                            + String.format(
                            "%.2f",
                            usuario.getSaldo()
                    )
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // Compra de canción
    private static void comprarCancion(
            Aplicacion aplicacion,
            Usuario usuario) {

        Cancion cancion =
                seleccionarCancion(
                        aplicacion.getCatalogo(),
                        "Seleccione la canción que desea comprar"
                );

        if (cancion == null) {
            return;
        }

        try {

            if (usuario.comprarCancion(
                    cancion)) {

                System.out.println(
                        "Compra realizada correctamente."
                );

            } else {

                System.out.println(
                        "No se pudo realizar la compra."
                );
            }

        } catch (SaldoInsuficienteException e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // Reproducción del usuario
    private static void reproducirCancionUsuario(
            Aplicacion aplicacion,
            Usuario usuario) {

        Cancion cancion =
                seleccionarCancion(
                        aplicacion.getCatalogo(),
                        "Seleccione una canción"
                );

        if (cancion != null) {

            usuario.reproducirCancion(
                    cancion
            );
        }
    }

    // Califica una canción
    private static void calificarCancion(
            Usuario usuario) {

        Cancion cancion =
                seleccionarCancion(
                        usuario
                                .getColeccionUsuario()
                                .getCanciones(),
                        "Seleccione una canción de su colección"
                );

        if (cancion == null) {
            return;
        }

        try {

            System.out.print(
                    "Calificación de 0.0 a 5.0: "
            );

            double valor =
                    Double.parseDouble(
                            scanner.nextLine()
                    );

            if (usuario.calificarCancion(
                    cancion,
                    valor)) {

                System.out.println(
                        "Calificación registrada."
                );

            } else {

                System.out.println(
                        "No se pudo registrar la calificación."
                );
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "Calificación inválida."
            );
        }
    }

    // Menú de listas de reproducción
    private static void menuListas(
            Usuario usuario) {

        boolean volver = false;

        while (!volver) {

            System.out.println(
                    "\nListas de reproducción"
            );

            System.out.println("1. Crear lista");
            System.out.println("2. Ver listas");
            System.out.println("3. Agregar canción a una lista");
            System.out.println("4. Reproducir lista");
            System.out.println("0. Volver");

            System.out.print(
                    "Seleccione una opción: "
            );

            String opcion =
                    scanner.nextLine();

            switch (opcion) {

                case "1":

                    System.out.print(
                            "Nombre de la lista: "
                    );

                    String nombre =
                            scanner.nextLine();

                    if (usuario.crearLista(
                            nombre)) {

                        System.out.println(
                                "Lista creada."
                        );

                    } else {

                        System.out.println(
                                "No se pudo crear la lista."
                        );
                    }

                    break;

                case "2":
                    usuario.mostrarListas();
                    break;

                case "3":
                    agregarCancionALista(
                            usuario
                    );
                    break;

                case "4":
                    reproducirLista(
                            usuario
                    );
                    break;

                case "0":
                    volver = true;
                    break;

                default:
                    System.out.println(
                            "Opción inválida."
                    );
            }
        }
    }

    // Agrega canción a una lista
    private static void agregarCancionALista(
            Usuario usuario) {

        System.out.print(
                "Nombre de la lista: "
        );

        String nombreLista =
                scanner.nextLine();

        Cancion cancion =
                seleccionarCancion(
                        usuario
                                .getColeccionUsuario()
                                .getCanciones(),
                        "Seleccione una canción de su colección"
                );

        if (cancion == null) {
            return;
        }

        if (usuario.agregarCancionALista(
                nombreLista,
                cancion)) {

            System.out.println(
                    "Canción agregada a la lista."
            );

        } else {

            System.out.println(
                    "No se pudo agregar la canción."
            );
        }
    }

    // Reproduce una lista
    private static void reproducirLista(
            Usuario usuario) {

        if (usuario
                .getListasReproduccion()
                .isEmpty()) {

            System.out.println(
                    "No hay listas de reproducción."
            );

            return;
        }

        for (int i = 0;
             i < usuario
                     .getListasReproduccion()
                     .size();
             i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + usuario
                            .getListasReproduccion()
                            .get(i)
                            .getNombre()
            );
        }

        try {

            System.out.print(
                    "Seleccione una lista: "
            );

            int indice =
                    Integer.parseInt(
                            scanner.nextLine()
                    ) - 1;

            if (indice < 0
                    || indice >= usuario
                    .getListasReproduccion()
                    .size()) {

                System.out.println(
                        "Selección inválida."
                );

                return;
            }

            usuario.reproducirLista(
                    usuario
                            .getListasReproduccion()
                            .get(indice)
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Selección inválida."
            );
        }
    }

    // Menú de cola
    private static void menuCola(
            Aplicacion aplicacion,
            Usuario usuario) {

        boolean volver = false;

        while (!volver) {

            System.out.println(
                    "\nCola de reproducción"
            );

            System.out.println(
                    "1. Agregar canción a la cola"
            );

            System.out.println(
                    "2. Ver cola"
            );

            System.out.println(
                    "3. Reproducir cola"
            );

            System.out.println(
                    "0. Volver"
            );

            System.out.print(
                    "Seleccione una opción: "
            );

            String opcion =
                    scanner.nextLine();

            switch (opcion) {

                case "1":

                    Cancion cancion =
                            seleccionarCancion(
                                    aplicacion.getCatalogo(),
                                    "Seleccione una canción"
                            );

                    if (cancion != null) {

                        if (usuario.agregarACola(
                                cancion)) {

                            System.out.println(
                                    "Canción agregada a la cola."
                            );

                        } else {

                            System.out.println(
                                    "No se pudo agregar la canción."
                            );
                        }
                    }

                    break;

                case "2":

                    usuario
                            .getColaReproduccion()
                            .mostrarCola();

                    break;

                case "3":

                    usuario.reproducirCola();
                    break;

                case "0":

                    volver = true;
                    break;

                default:

                    System.out.println(
                            "Opción inválida."
                    );
            }
        }
    }

    // Cambio de contraseña
    private static void cambiarContrasenia(
            Usuario usuario) {

        System.out.print(
                "Contraseña actual: "
        );

        String actual =
                scanner.nextLine();

        System.out.print(
                "Nueva contraseña: "
        );

        String nueva1 =
                scanner.nextLine();

        System.out.print(
                "Repita la nueva contraseña: "
        );

        String nueva2 =
                scanner.nextLine();

        if (usuario.cambiarContrasenia(
                actual,
                nueva1,
                nueva2)) {

            System.out.println(
                    "Contraseña actualizada."
            );

        } else {

            System.out.println(
                    "No se pudo cambiar la contraseña."
            );
        }
    }

    // Top 3
    private static void mostrarTop3(
            Aplicacion aplicacion) {

        System.out.println(
                "\nTop 3 mejor calificadas"
        );

        mostrarCancionesNumeradas(
                aplicacion
                        .obtenerTop3MejorCalificadas()
        );

        System.out.println(
                "\nTop 3 más compradas"
        );

        mostrarCancionesNumeradas(
                aplicacion
                        .obtenerTop3MasCompradas()
        );

        System.out.println(
                "\nTop 3 más agregadas a listas"
        );

        mostrarCancionesNumeradas(
                aplicacion
                        .obtenerTop3MasAgregadasAListas()
        );
    }

    // Permite seleccionar una canción
    private static Cancion seleccionarCancion(
            ArrayList<Cancion> canciones,
            String mensaje) {

        if (canciones == null
                || canciones.isEmpty()) {

            System.out.println(
                    "No hay canciones disponibles."
            );

            return null;
        }

        System.out.println(
                "\n" + mensaje
        );

        mostrarCancionesNumeradas(
                canciones
        );

        try {

            System.out.print(
                    "Número de canción: "
            );

            int indice =
                    Integer.parseInt(
                            scanner.nextLine()
                    ) - 1;

            if (indice < 0
                    || indice >= canciones.size()) {

                System.out.println(
                        "Selección inválida."
                );

                return null;
            }

            return canciones.get(
                    indice
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Selección inválida."
            );

            return null;
        }
    }

    // Muestra canciones numeradas
    private static void mostrarCancionesNumeradas(
            ArrayList<Cancion> canciones) {

        if (canciones == null
                || canciones.isEmpty()) {

            System.out.println(
                    "No se encontraron canciones."
            );

            return;
        }

        for (int i = 0;
             i < canciones.size();
             i++) {

            Cancion cancion =
                    canciones.get(i);

            System.out.println(
                    (i + 1)
                            + ". "
                            + cancion.getNombre()
                            + " - "
                            + cancion
                            .getArtista()
                            .getNombre()
                            + " - $"
                            + String.format(
                            "%.2f",
                            cancion.getPrecio()
                    )
            );
        }
    }
}