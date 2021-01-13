package mk.finki.ukim.bp.service;

import mk.finki.ukim.bp.model.Mileniche;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface MilenicheService {
    List<Mileniche> listAll();

    Optional<Mileniche> findById(int id_mileniche);

    Optional<Mileniche> addMileniche(int id_mileniche,
                                     String ime,
                                     String vid,
                                     String rasa,
                                     String pol,
                                     String boja,
                                     int id_centar_vdomuvanje,
                                     Date datum_smestuvanje,
                                     int id_opstina,
                                     Date datum_naogjanje,
                                     String opis_lokacija);

    Optional<Mileniche> updateVdomenoMileniche (Integer id_mileniche,  String embg_klient);

    Optional<Mileniche> updatePregledanoMileniche (Integer id_mileniche, Integer id_veterinaren_centar, String zdravstvena_sostojba);
}