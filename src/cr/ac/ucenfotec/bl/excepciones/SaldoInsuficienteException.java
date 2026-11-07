package cr.ac.ucenfotec.bl.excepciones;

public class SaldoInsuficienteException extends Exception {

    // Constructor vacío
    public SaldoInsuficienteException() {
        super();
    }

    // Constructor con mensaje
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }

    // Constructor con mensaje y causa
    public SaldoInsuficienteException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}