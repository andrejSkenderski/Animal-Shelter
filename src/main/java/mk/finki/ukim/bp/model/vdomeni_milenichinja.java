package mk.finki.ukim.bp.model;


import lombok.Data;

import javax.persistence.Entity;
import java.sql.Date;

@Data
public class vdomeni_milenichinja {
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
