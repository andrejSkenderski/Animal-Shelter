package mk.finki.ukim.bp.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table (name= "klient")
public class Klient {
    @Id
    private String embg;
    private String ime;
    private String prezime;
    private String adresa_ziveenje;

//    @ManyToOne
//    private opstina opstina;

    private Integer id_opstina;




    public Klient(String embg, String ime, String prezime, String adresa_ziveenje, Integer id_opstina) {
        this.embg = embg;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa_ziveenje = adresa_ziveenje;
        this.id_opstina = id_opstina;
    }

    public Klient() {
    }
}
