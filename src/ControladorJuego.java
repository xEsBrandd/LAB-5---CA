import java.util.List;

public class ControladorJuego {

    private Mazo mazo;
    private Tablero tablero;
    private VistaConsola vista;

    public ControladorJuego(Mazo mazo, Tablero tablero, VistaConsola vista) {
        this.mazo = mazo;
        this.tablero = tablero;
        this.vista = vista;
    }

    public void iniciar() {
        mazo.cargarCartasIniciales();
        vista.mostrarMensaje("¡Bienvenido a UVG Card Battle! Se han cargado 10 cartas iniciales.");
        
        boolean continuar = true;
        while (continuar) {
            vista.mostrarMenu();
            int opcion = vista.leerEntero("Seleccione una opción");
            
            if (opcion == 7) {
                continuar = false;
                vista.mostrarMensaje("Saliendo del juego...");
            } else {
                procesarOpcion(opcion);
            }
        }
    }

    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                listarCartas();
                break;
            case 2:
                buscarPorId();
                break;
            case 3:
                buscarPorNombre();
                break;
            case 4:
                ordenarCartas();
                break;
            case 5:
                jugarCarta();
                break;
            case 6:
                vista.mostrarTablero(tablero);
                break;
            default:
                vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
        }
    }

    public void listarCartas() {
        vista.mostrarMensaje("\n--- Catálogo de Cartas ---");
        List<Carta> cartas = mazo.listarCartas();
        vista.mostrarCartas(cartas);
    }

    public void buscarPorId() {
        int id = vista.leerEntero("Ingrese el ID de la carta a buscar");
        Carta carta = mazo.buscarCarta(id);
        vista.mostrarCarta(carta);
    }

    public void buscarPorNombre() {
        String nombre = vista.leerTexto("Ingrese el nombre (o parte) de la carta a buscar");
        Carta carta = mazo.buscarCarta(nombre);
        vista.mostrarCarta(carta);
    }

    public void ordenarCartas() {
        mazo.ordenarPorEnergia();
        vista.mostrarMensaje("Mazo ordenado exitosamente por costo de energía (ascendente).");
        listarCartas();
    }

    public void jugarCarta() {
        int id = vista.leerEntero("Ingrese el ID de la carta que desea jugar");
        Carta carta = mazo.buscarCarta(id);
        
        if (carta != null) {
            int energiaPrevia = tablero.getEnergiaDisponible();
            vista.mostrarMensaje("Intentando jugar: " + carta.getNombre() + " (Costo: " + carta.getCostoEnergia() + ")");
            
            carta.jugarCarta(tablero);
            
            // Si la energía cambió o disminuyó, significa que se ejecutó correctamente (para costos > 0)
            if (tablero.getEnergiaDisponible() < energiaPrevia || carta.getCostoEnergia() == 0) {
                vista.mostrarMensaje("¡Carta jugada con éxito! Revisa el tablero para ver los cambios.");
            } else {
                vista.mostrarMensaje("No tienes energía suficiente para jugar esta carta.");
            }
        } else {
            vista.mostrarMensaje("No se encontró ninguna carta con ese ID.");
        }
    }
}