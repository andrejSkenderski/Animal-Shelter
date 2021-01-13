package mk.finki.ukim.bp.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table (name = "opstina")
public class Opstina {

    @Id
    private Integer id_opstina;

    private String ime;


    public Opstina() {
    }

}
