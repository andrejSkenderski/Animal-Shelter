package mk.finki.ukim.bp.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class veterinaren_centar {
    @Id
    private int id_veterinaren_centar;

    private String adresa;

    private int id_opstina;

    public veterinaren_centar() {
    }
}
