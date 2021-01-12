package mk.finki.ukim.bp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class centar_vdomuvanje {
    @Id
    private int id_centar_vdomuvanje;

    private String adresa;

    private int id_opstina;


//    @ManyToOne
//    private opstina opstina;

    public centar_vdomuvanje() {
    }

}
