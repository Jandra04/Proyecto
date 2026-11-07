package cr.ac.ucenfotec.bl.entidades;

public abstract class Cuenta {

    // atributos
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasenia;

    // Constructor
    public Cuenta(String correoElectronico,
                  String nombreUsuario,
                  String contrasenia) {

        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    // Getters
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    // Setters
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // Verifica si la contraseña ingresada es correcta
    public boolean verificarContrasenia(String intento) {
        return intento != null && intento.equals(contrasenia);
    }

    // Valida los requisitos de la contraseña
    public boolean contraseniaEsValida(String contrasenia) {

        return contrasenia != null
                && contrasenia.length() >= 8
                && contrasenia.length() <= 12
                && contrasenia.matches(".*[A-Z].*")
                && contrasenia.matches(".*[a-z].*")
                && contrasenia.matches(".*[0-9].*")
                && contrasenia.matches(".*[^a-zA-Z0-9 ].*");
    }

    // Cambia la contraseña
    public boolean cambiarContrasenia(String actual,
                                      String nueva1,
                                      String nueva2) {

        if (!verificarContrasenia(actual)) {
            System.out.println("La contraseña actual es incorrecta.");
            return false;
        }

        if (nueva1 == null || !nueva1.equals(nueva2)) {
            System.out.println("Las contraseñas nuevas no coinciden.");
            return false;
        }

        if (!contraseniaEsValida(nueva1)) {
            System.out.println("La contraseña nueva no cumple los requisitos.");
            return false;
        }

        if (nueva1.equals(contrasenia)) {
            System.out.println("La contraseña nueva debe ser distinta a la actual.");
            return false;
        }

        contrasenia = nueva1;

        System.out.println("La contraseña se ha cambiado exitosamente.");
        return true;
    }

    // Permite que cada tipo de cuenta defina cómo reproduce una canción
    public abstract void reproducirCancion(Cancion cancion);

    // Muestra la información principal de la cuenta
    @Override
    public String toString() {

        return "Nombre de usuario: "
                + nombreUsuario
                + "\nCorreo electrónico: "
                + correoElectronico;
    }
}