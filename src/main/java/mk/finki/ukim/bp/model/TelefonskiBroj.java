package mk.finki.ukim.bp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@IdClass (TelefonskiBrojId.class)
@Table (name = "telefonski_broj")
public class TelefonskiBroj implements Serializable {

    @Id
    private String telefonski_broj;
    @Id
    private String embg;

    public TelefonskiBroj() {
    }
}
