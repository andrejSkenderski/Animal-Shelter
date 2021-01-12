package mk.finki.ukim.bp.model;


import java.io.Serializable;
import java.util.Objects;

public class telefonski_brojId implements Serializable {

    private String telefonski_broj;
    private String embg;

    public telefonski_brojId() {
    }

    public telefonski_brojId(String telefonski_broj, String embg) {
        this.telefonski_broj = telefonski_broj;
        this.embg = embg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        telefonski_brojId that = (telefonski_brojId) o;
        return Objects.equals(telefonski_broj, that.telefonski_broj) &&
                Objects.equals(embg, that.embg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefonski_broj, embg);
    }
}
