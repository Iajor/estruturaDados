import java.util.Objects;

public class Atomo {
    private String sigla;
    private String x;
    private String y;
    private String z;

    public Atomo(String sigla, String x, String y, String z) {
        this.sigla = sigla;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Atomo atomo = (Atomo) obj;
        return sigla.equals(atomo.sigla) &&
                x.equals(atomo.x) &&
                y.equals(atomo.y) &&
                z.equals(atomo.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sigla, x, y, z);
    }

    @Override
    public String toString() {
        return "Atomo{" +
                "sigla='" + sigla + '\'' +
                ", eixo x='" + x + '\'' +
                ", eixo y='" + y + '\'' +
                ", eixo z='" + z + '\'' +
                '}';
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }
}
