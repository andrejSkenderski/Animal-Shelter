package mk.finki.ukim.bp.model;

import lombok.Data;

import java.sql.Date;

@Data
public class zdravi_milenichinja {

    private int id_mileniche;
    private String ime;
    private String vid;
    private String rasa;
    private String pol;
    private String boja;
    private int id_centar_vdomuvanje;
    private Date datum_smestuvanje;
    private int id_opstina;
    private Date datum_naogjanje;
    private String opis_lokacija;
    private int id_veterinaren_centar;
    private Date datum_pregled;
    private String zdravstvena_sostojba;
    private Date datum_vdomuvanje;
    private String embg_klient;



}
