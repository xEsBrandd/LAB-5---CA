import java.util.Objects;

public abstract class Carta implements Comparable<Carta> {

    private int id;
    private String nombre;
    private int costoEnergia;
    private String descripcion;

    public Carta(
            int id,
            String nombre,
            int costoEnergia,
            String descripcion
    ) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.descripcion = descripcion;
    }

    public abstract void jugarCarta(Tablero tablero);

    @Override
    public int compareTo(Carta otraCarta) {
        return Integer.compare(
                this.costoEnergia,
                otraCarta.costoEnergia
        );
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", costoEnergia=" + costoEnergia +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }

        Carta otraCarta = (Carta) objeto;
        return id == otraCarta.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}