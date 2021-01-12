package mk.finki.ukim.bp.service.impl;

import mk.finki.ukim.bp.model.centar_vdomuvanje;
import mk.finki.ukim.bp.model.exceptions.CentarNotFoundException;
import mk.finki.ukim.bp.model.exceptions.KlientAlreadyExists;
import mk.finki.ukim.bp.model.exceptions.MilenicheAlreadyExists;
import mk.finki.ukim.bp.model.exceptions.OpstinaNotFoundException;
import mk.finki.ukim.bp.model.klient;
import mk.finki.ukim.bp.model.mileniche;
import mk.finki.ukim.bp.model.opstina;
import mk.finki.ukim.bp.repository.CentarVdomuvanjeRepository;
import mk.finki.ukim.bp.repository.MilenicheRepository;
import mk.finki.ukim.bp.repository.OpstinaRepository;
import mk.finki.ukim.bp.service.MilenicheService;
import mk.finki.ukim.bp.service.OpstinaService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MilenicheServiceImpl implements MilenicheService {
    private final MilenicheRepository milenicheRepository;
    private final OpstinaRepository opstinaRepository;
    private final CentarVdomuvanjeRepository centarVdomuvanjeRepository;

    public MilenicheServiceImpl(MilenicheRepository milenicheRepository, OpstinaRepository opstinaRepository, CentarVdomuvanjeRepository centarVdomuvanjeRepository) {
        this.milenicheRepository = milenicheRepository;
        this.opstinaRepository = opstinaRepository;
        this.centarVdomuvanjeRepository = centarVdomuvanjeRepository;
    }

    @Override
    public List<mileniche> listAll() {
        return this.milenicheRepository.findAll();
    }

    @Override
    public Optional<mileniche> findById(int id_mileniche) {
        return this.milenicheRepository.findById(id_mileniche);
    }

    @Override
    public Optional<mileniche> addMileniche(int id_mileniche, String ime, String vid, String rasa, String pol, String boja, int id_centar_vdomuvanje, Date datum_smestuvanje, int id_opstina, Date datum_naogjanje, String opis_lokacija) {
        opstina opstina = this.opstinaRepository.findById(id_opstina).orElseThrow(() -> new OpstinaNotFoundException(id_opstina));

        centar_vdomuvanje centar_vdomuvanje = this.centarVdomuvanjeRepository.findById(id_centar_vdomuvanje).orElseThrow(() -> new CentarNotFoundException(id_centar_vdomuvanje));

        Optional<mileniche> newMileniche = this.milenicheRepository.findById(id_mileniche);
        if (newMileniche.equals(Optional.empty())) {
            return Optional.of(this.milenicheRepository.save(new mileniche(id_mileniche, ime, vid, rasa, pol, boja, id_centar_vdomuvanje, datum_smestuvanje, id_opstina, datum_naogjanje, opis_lokacija)));
        } else {
            throw new MilenicheAlreadyExists(id_mileniche);
        }
    }
}
