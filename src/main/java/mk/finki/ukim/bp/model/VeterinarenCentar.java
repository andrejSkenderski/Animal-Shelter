package mk.finki.ukim.bp.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table (name = "veterinaren_centar")
public class VeterinarenCentar {
    @Id
    private Integer id_veterinaren_centar;

    private String adresa;

    private Integer id_opstina;

    public VeterinarenCentar() {
    }
}
