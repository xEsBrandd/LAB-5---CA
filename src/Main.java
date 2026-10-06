public class Main {

    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        Tablero tablero = new Tablero(10);
        VistaConsola vista = new VistaConsola();

        ControladorJuego controlador =
                new ControladorJuego(mazo, tablero, vista);

        controlador.iniciar();
    }
}