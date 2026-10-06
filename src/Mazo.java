import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {

    private List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
    }

    public void cargarCartasIniciales() {
        agregarCarta(new CartaCatedratico(1, "Catedrático Estricto", 3, "Profesor que no perdona llegadas tarde", "Física", 2, 15));
        agregarCarta(new CartaCatedratico(2, "Catedrático Comprensivo", 1, "Siempre dispuesto a ayudar", "Programación", 0, 30));
        agregarCarta(new CartaCatedratico(3, "Coordinador Académico", 4, "Revisa tu progreso", "Administración", 1, 20));
        
        agregarCarta(new CartaMateria(4, "Matemática Discreta", 2, "Teoría de grafos y lógica", 4, 3));
        agregarCarta(new CartaMateria(5, "POO", 3, "Programación Orientada a Objetos", 5, 4));
        agregarCarta(new CartaMateria(6, "Física Básica", 2, "Leyes de Newton y cinemática", 4, 3));
        agregarCarta(new CartaMateria(7, "Deportes", 1, "Para relajarse un poco", 2, 1));
        
        agregarCarta(new CartaEventoCampus(8, "Semana de Parciales", 0, "Aumenta la tensión de todos", -2, 5));
        agregarCarta(new CartaEventoCampus(9, "Feria de Clubes", 1, "Descanso merecido", 3, -1));
        agregarCarta(new CartaEventoCampus(10, "Fallo en el WiFi", 2, "No puedes entregar la tarea a tiempo", -1, 2));
    }

    public void agregarCarta(Carta carta) {
        if (buscarCarta(carta.getId()) == null) {
            cartas.add(carta);
        }
    }

    public List<Carta> listarCartas() {
        return new ArrayList<>(cartas);
    }

    // Overloading: Buscar por ID
    public Carta buscarCarta(int id) {
        for (Carta c : cartas) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // Overloading: Buscar por Nombre
    public Carta buscarCarta(String nombre) {
        for (Carta c : cartas) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    public void ordenarPorEnergia() {
        Collections.sort(cartas);
    }
}