package mk.finki.ukim.bp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@IdClass (telefonski_brojId.class)
public class telefonski_broj implements Serializable {

    @Id
    private String telefonski_broj;
    @Id
    private String embg;

    public telefonski_broj() {
    }
}
