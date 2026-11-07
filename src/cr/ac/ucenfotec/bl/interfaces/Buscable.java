package cr.ac.ucenfotec.bl.interfaces;

import cr.ac.ucenfotec.bl.entidades.Cancion;

import java.util.ArrayList;

public interface Buscable {

    ArrayList<Cancion> buscarPorNombre(String nombre);

    ArrayList<Cancion> buscarPorGenero(String genero);

    ArrayList<Cancion> buscarPorArtista(String artista);
}