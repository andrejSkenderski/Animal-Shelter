package mk.finki.ukim.bp.model;


import java.io.Serializable;
import java.util.Objects;

public class TelefonskiBrojId implements Serializable {

    private String telefonski_broj;
    private String embg;

    public TelefonskiBrojId() {
    }

    public TelefonskiBrojId(String telefonski_broj, String embg) {
        this.telefonski_broj = telefonski_broj;
        this.embg = embg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonskiBrojId that = (TelefonskiBrojId) o;
        return Objects.equals(telefonski_broj, that.telefonski_broj) &&
                Objects.equals(embg, that.embg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefonski_broj, embg);
    }
}
