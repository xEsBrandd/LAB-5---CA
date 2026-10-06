public class CartaMateria extends Carta {

    private int creditos;
    private int dificultad;

    public CartaMateria(
            int id,
            String nombre,
            int costoEnergia,
            String descripcion,
            int creditos,
            int dificultad
    ) {
        super(id, nombre, costoEnergia, descripcion);
        this.creditos = creditos;
        this.dificultad = dificultad;
    }

    @Override
    public void jugarCarta(Tablero tablero) {
        if (tablero.consumirEnergia(getCostoEnergia())) {
            tablero.agregarCreditos(creditos);
            tablero.modificarDificultad(dificultad);
        }
    }

    @Override
    public String toString() {
        return "CartaMateria{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", costoEnergia=" + getCostoEnergia() +
                ", descripcion='" + getDescripcion() + '\'' +
                ", creditos=" + creditos +
                ", dificultad=" + dificultad +
                '}';
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
}