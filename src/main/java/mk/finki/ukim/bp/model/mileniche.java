package mk.finki.ukim.bp.model;


import lombok.Data;

import javax.persistence.*;

import java.sql.Date;

@Data
@Entity
public class mileniche {
    @Id
    private Integer id_mileniche;
    private String ime;
    private String vid;
    private String rasa;
    private String pol;
    private String boja;
    private Integer id_centar_vdomuvanje;
    private Date datum_smestuvanje;
    private Integer id_opstina;
    private Date datum_naogjanje;
    private String opis_lokacija;
    private Integer id_veterinaren_centar;
    private Date datum_pregled;
    private String zdravstvena_sostojba;
    private Date datum_vdomuvanje;
    private String embg_klient;

    public mileniche(int id_mileniche, String ime, String vid, String rasa, String pol, String boja, int id_centar_vdomuvanje,
                     Date datum_smestuvanje, int id_opstina, Date datum_naogjanje, String opis_lokacija) {

        this.id_mileniche = id_mileniche;
        this.ime = ime;
        this.vid = vid;
        this.rasa = rasa;
        this.pol = pol;
        this.boja = boja;
        this.id_centar_vdomuvanje = id_centar_vdomuvanje;
        this.datum_smestuvanje = datum_smestuvanje;
        this.id_opstina = id_opstina;
        this.datum_naogjanje = datum_naogjanje;
        this.opis_lokacija = opis_lokacija;
        this.id_veterinaren_centar = null;
        this.datum_pregled = null;
        this.zdravstvena_sostojba = null;
        this.datum_vdomuvanje = null;
        this.embg_klient = null;
    }

    public mileniche() {
    }
}
