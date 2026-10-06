public class CartaEventoCampus extends Carta {

    private int cambioEnergia;
    private int cambioDificultad;

    public CartaEventoCampus(
            int id,
            String nombre,
            int costoEnergia,
            String descripcion,
            int cambioEnergia,
            int cambioDificultad
    ) {
        super(id, nombre, costoEnergia, descripcion);
        this.cambioEnergia = cambioEnergia;
        this.cambioDificultad = cambioDificultad;
    }

    @Override
    public void jugarCarta(Tablero tablero) {
        if (tablero.consumirEnergia(getCostoEnergia())) {
            tablero.modificarEnergia(cambioEnergia);
            tablero.modificarDificultad(cambioDificultad);
        }
    }

    @Override
    public String toString() {
        return "CartaEventoCampus{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", costoEnergia=" + getCostoEnergia() +
                ", descripcion='" + getDescripcion() + '\'' +
                ", cambioEnergia=" + cambioEnergia +
                ", cambioDificultad=" + cambioDificultad +
                '}';
    }

    public int getCambioEnergia() {
        return cambioEnergia;
    }

    public void setCambioEnergia(int cambioEnergia) {
        this.cambioEnergia = cambioEnergia;
    }

    public int getCambioDificultad() {
        return cambioDificultad;
    }

    public void setCambioDificultad(int cambioDificultad) {
        this.cambioDificultad = cambioDificultad;
    }
}