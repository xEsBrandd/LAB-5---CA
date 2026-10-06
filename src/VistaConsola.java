import java.util.List;
import java.util.Scanner;

public class VistaConsola {

    private Scanner entrada;

    public VistaConsola() {
        this.entrada = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n--- UVG CARD BATTLE ---");
        System.out.println("1. Listar todas las cartas");
        System.out.println("2. Buscar carta por ID");
        System.out.println("3. Buscar carta por Nombre");
        System.out.println("4. Ordenar mazo por costo de energía");
        System.out.println("5. Jugar una carta");
        System.out.println("6. Ver estado del tablero");
        System.out.println("7. Salir");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                int valor = Integer.parseInt(entrada.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje + ": ");
        return entrada.nextLine();
    }

    public void mostrarCartas(List<Carta> cartas) {
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas para mostrar.");
            return;
        }
        for (Carta carta : cartas) {
            mostrarCarta(carta);
        }
    }

    public void mostrarCarta(Carta carta) {
        if (carta != null) {
            System.out.println(carta.toString());
        } else {
            System.out.println("Carta no encontrada.");
        }
    }

    public void mostrarTablero(Tablero tablero) {
        System.out.println(tablero.toString());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}