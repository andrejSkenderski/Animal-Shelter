package mk.finki.ukim.bp.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class opstina {

    @Id
    private Integer id_opstina;

    private String ime;


    public opstina() {
    }

}
