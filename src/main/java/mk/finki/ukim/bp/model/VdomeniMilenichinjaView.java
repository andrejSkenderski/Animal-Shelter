package mk.finki.ukim.bp.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Table(name = "vdomeni_milenichinja")
public class VdomeniMilenichinjaView {
    private String klient_ime;
    private String klient_prezime;
    private String klient_adresa;
    private String opstina_klient;
    private Date datum_vdomuvanje;
    private String ime_mileniche;
    private String vid_mileniche;
    private String rasa_mileniche;
    private String pol_mileniche;
    private String zdravstvena_sostojba;
}
