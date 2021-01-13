package mk.finki.ukim.bp.model;

import lombok.Data;

import javax.persistence.Table;
import java.sql.Date;

@Data
@Table (name = "zdravi_milenichinja")
public class ZdraviMilenichinjaView {

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



}
