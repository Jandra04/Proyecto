import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        // ARTISTAS


        Artista artista1 = new Artista("Coldplay");
        Artista artista2 = new Artista("Adele");



        // COMPOSITORES


        Compositor compositor1 = new Compositor("Chris Martin");
        Compositor compositor2 = new Compositor("Adele Adkins");


        // GENEROS


        Genero genero1 = new Genero("Rock");
        Genero genero2 = new Genero("Pop");



        // ALBUMES

        Album album1 = new Album("Parachutes");
        Album album2 = new Album("25");



        // CANCIONES

        Cancion cancion1 = new Cancion(
                "Yellow",
                LocalDate.of(2000, 6, 26),
                4.8,
                1.99,
                genero1,
                artista1,
                compositor1,
                album1
        );

        Cancion cancion2 = new Cancion(
                "Fix You",
                LocalDate.of(2005, 9, 5),
                4.9,
                2.50,
                genero1,
                artista1,
                compositor1,
                null
        );

        Cancion cancion3 = new Cancion(
                "Hello",
                LocalDate.of(2015, 10, 23),
                4.7,
                1.75,
                genero2,
                artista2,
                compositor2,
                album2
        );



        // CALIFICACIONES

        cancion1.calificar(4.5);
        cancion1.calificar(5.0);
        cancion1.calificar(4.8);

        cancion2.calificar(4.7);
        cancion2.calificar(5.0);

        cancion3.calificar(4.3);
        cancion3.calificar(4.8);



        // USUARIO


        Usuario usuario1 = new Usuario(
                "Alejandra Carrillo",
                LocalDate.of(2000, 5, 15),
                "Costa Rica",
                "123456789",
                "avatar1.jpg",
                "alejandra@email.com",
                "alejandra",
                "Alejandra#1"
        );



        // ADMINISTRADOR


        Administrador administrador1 = new Administrador(
                "admin@musica.com",
                "admin",
                "Admin123#"
        );



        // LISTAS DE REPRODUCCION


        ListaReproduccion lista1 = new ListaReproduccion(
                "Mis favoritas",
                LocalDate.now()
        );

        lista1.agregarCancion(cancion1);
        lista1.agregarCancion(cancion2);


        ListaReproduccion lista2 = new ListaReproduccion(
                "Para estudiar",
                LocalDate.now()
        );

        lista2.agregarCancion(cancion2);
        lista2.agregarCancion(cancion3);



        // COLA DE REPRODUCCION

        ColaReproduccion cola1 = new ColaReproduccion();

        cola1.agregarCancion(cancion1);
        cola1.agregarCancion(cancion2);
        cola1.agregarCancion(cancion3);



        // RECARGA


        Recarga recarga1 = new Recarga(20.00);


        // COMPRA


        Compra compra1 = new Compra(
                usuario1.getNombreUsuario(),
                cancion1,
                cancion1.getPrecio()
        );

        Compra compra2 = new Compra(
                usuario1.getNombreUsuario(),
                cancion2,
                cancion2.getPrecio()
        );



        // HISTORIAL DE MOVIMIENTOS


        HistorialMovimientos historial1 =
                new HistorialMovimientos();

        historial1.registrarRecarga(20.00);

        historial1.registrarCompra(
                usuario1.getNombreUsuario(),
                cancion1,
                cancion1.getPrecio()
        );

        historial1.registrarCompra(
                usuario1.getNombreUsuario(),
                cancion2,
                cancion2.getPrecio()
        );



        // COLECCION


        Coleccion coleccion1 = new Coleccion();

        coleccion1.agregarCancion(cancion1);
        coleccion1.agregarCancion(cancion2);
        coleccion1.agregarCancion(cancion3);



        // ARRAYLIST DE CADA CLASE


        ArrayList<Artista> artistas =
                new ArrayList<>();

        ArrayList<Compositor> compositores =
                new ArrayList<>();

        ArrayList<Genero> generos =
                new ArrayList<>();

        ArrayList<Album> albumes =
                new ArrayList<>();

        ArrayList<Cancion> canciones =
                new ArrayList<>();

        ArrayList<Usuario> usuarios =
                new ArrayList<>();

        ArrayList<Administrador> administradores =
                new ArrayList<>();

        ArrayList<ListaReproduccion> listasReproduccion =
                new ArrayList<>();

        ArrayList<ColaReproduccion> colasReproduccion =
                new ArrayList<>();

        ArrayList<Recarga> recargas =
                new ArrayList<>();

        ArrayList<Compra> compras =
                new ArrayList<>();

        ArrayList<HistorialMovimientos> historiales =
                new ArrayList<>();

        ArrayList<Coleccion> colecciones =
                new ArrayList<>();

        ArrayList<Calificacion> calificaciones =
                new ArrayList<>();



        // REGISTRAR OBJETOS EN LAS LISTAS


        artistas.add(artista1);
        artistas.add(artista2);

        compositores.add(compositor1);
        compositores.add(compositor2);

        generos.add(genero1);
        generos.add(genero2);

        albumes.add(album1);
        albumes.add(album2);

        canciones.add(cancion1);
        canciones.add(cancion2);
        canciones.add(cancion3);

        usuarios.add(usuario1);

        administradores.add(administrador1);

        listasReproduccion.add(lista1);
        listasReproduccion.add(lista2);

        colasReproduccion.add(cola1);

        recargas.add(recarga1);

        compras.add(compra1);
        compras.add(compra2);

        historiales.add(historial1);

        colecciones.add(coleccion1);

        calificaciones.add(
                cancion1.getRegistroCalificaciones()
        );

        calificaciones.add(
                cancion2.getRegistroCalificaciones()
        );

        calificaciones.add(
                cancion3.getRegistroCalificaciones()
        );



        // MOSTRAR ARTISTAS


        System.out.println("\n===== ARTISTAS =====");

        for (Artista artista : artistas) {
            System.out.println(artista);
            System.out.println();
        }



        // MOSTRAR COMPOSITORES


        System.out.println("\n===== COMPOSITORES =====");

        for (Compositor compositor : compositores) {
            System.out.println(compositor);
            System.out.println();
        }



        // MOSTRAR GENEROS


        System.out.println("\n===== GENEROS =====");

        for (Genero genero : generos) {
            System.out.println(genero);
            System.out.println();
        }



        // MOSTRAR ALBUMES


        System.out.println("\n===== ALBUMES =====");

        for (Album album : albumes) {
            System.out.println(album);
            System.out.println();
        }



        // MOSTRAR CANCIONES


        System.out.println("\n===== CANCIONES =====");

        for (Cancion cancion : canciones) {
            System.out.println(cancion);
            System.out.println();
        }



        // MOSTRAR CALIFICACIONES


        System.out.println("\n===== CALIFICACIONES =====");

        for (Calificacion calificacion : calificaciones) {
            System.out.println(calificacion);
            System.out.println();
        }



        // MOSTRAR USUARIOS

        System.out.println("\n===== USUARIOS =====");

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
            System.out.println();
        }



        // MOSTRAR ADMINISTRADORES

        System.out.println("\n===== ADMINISTRADORES =====");

        for (Administrador administrador : administradores) {
            System.out.println(administrador);
            System.out.println();
        }



        // MOSTRAR LISTAS DE REPRODUCCION

        System.out.println(
                "\n===== LISTAS DE REPRODUCCION ====="
        );

        for (ListaReproduccion lista : listasReproduccion) {
            System.out.println(lista);
            System.out.println();
        }



        // MOSTRAR COLAS DE REPRODUCCION


        System.out.println(
                "\n===== COLAS DE REPRODUCCION ====="
        );

        for (ColaReproduccion cola : colasReproduccion) {
            System.out.println(cola);
            System.out.println();
        }



        // MOSTRAR RECARGAS


        System.out.println("\n===== RECARGAS =====");

        for (Recarga recarga : recargas) {
            System.out.println(recarga);
            System.out.println();
        }



        // MOSTRAR COMPRAS


        System.out.println("\n===== COMPRAS =====");

        for (Compra compra : compras) {
            System.out.println(compra);
            System.out.println();
        }


        // MOSTRAR HISTORIALES


        System.out.println("\n===== HISTORIALES =====");

        for (HistorialMovimientos historial : historiales) {
            System.out.println(historial);
            System.out.println();
        }



        // MOSTRAR COLECCIONES


        System.out.println("\n===== COLECCIONES =====");

        for (Coleccion coleccion : colecciones) {
            System.out.println(coleccion);
            System.out.println();
        }



        // MOSTRAR CANCIONES DE LA PLAYLIST


        System.out.println(
                "\n===== CANCIONES DE MIS FAVORITAS ====="
        );

        lista1.mostrarCanciones();



        // MOSTRAR COLA

        System.out.println(
                "\n===== COLA DE REPRODUCCION ====="
        );

        cola1.mostrarCola();



        // MOSTRAR HISTORIAL DETALLADO

        System.out.println(
                "\n===== HISTORIAL DETALLADO ====="
        );

        historial1.mostrarHistorial();


        // TOP 3


        System.out.println(
                "\n===== TOP 3 MEJOR CALIFICADAS ====="
        );

        ArrayList<Cancion> top3 =
                coleccion1.getTop3MejoresCalificaciones();

        for (Cancion cancion : top3) {

            System.out.println(
                    cancion.getNombre()
                            + " - Calificacion: "
                            + cancion.getCalificacion()
            );
        }



        // BUSCAR CANCION


        System.out.println(
                "\n===== BUSQUEDA POR NOMBRE ====="
        );

        ArrayList<Cancion> resultado =
                coleccion1.buscarPorNombre("Yellow");

        for (Cancion cancion : resultado) {
            System.out.println(cancion);
        }
    }
}