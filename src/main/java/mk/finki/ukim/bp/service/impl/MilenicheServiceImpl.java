package mk.finki.ukim.bp.service.impl;

import mk.finki.ukim.bp.model.*;
import mk.finki.ukim.bp.model.exceptions.*;
import mk.finki.ukim.bp.repository.*;
import mk.finki.ukim.bp.service.MilenicheService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class MilenicheServiceImpl implements MilenicheService {
    private final KlientRepository klientRepository;
    private final MilenicheRepository milenicheRepository;
    private final OpstinaRepository opstinaRepository;
    private final CentarVdomuvanjeRepository centarVdomuvanjeRepository;
    private final VeterinarenCentarRepository veterinarenCentarRepository;

    public MilenicheServiceImpl(KlientRepository klientRepository, MilenicheRepository milenicheRepository, OpstinaRepository opstinaRepository,
                                CentarVdomuvanjeRepository centarVdomuvanjeRepository, VeterinarenCentarRepository veterinarenCentarRepository) {
        this.klientRepository = klientRepository;
        this.milenicheRepository = milenicheRepository;
        this.opstinaRepository = opstinaRepository;
        this.centarVdomuvanjeRepository = centarVdomuvanjeRepository;
        this.veterinarenCentarRepository = veterinarenCentarRepository;
    }

    @Override
    public List<Mileniche> listAll() {
        return this.milenicheRepository.findAll();
    }

    @Override
    public Optional<Mileniche> findById(int id_mileniche) {
        return this.milenicheRepository.findById(id_mileniche);
    }

    @Override
    public Optional<Mileniche> addMileniche(int id_mileniche, String ime, String vid, String rasa, String pol, String boja, int id_centar_vdomuvanje, Date datum_smestuvanje, int id_opstina, Date datum_naogjanje, String opis_lokacija) {
        Opstina opstina = this.opstinaRepository.findById(id_opstina).orElseThrow(() -> new OpstinaNotFoundException(id_opstina));

        CentarVdomuvanje CentarVdomuvanje = this.centarVdomuvanjeRepository.findById(id_centar_vdomuvanje).orElseThrow(() -> new CentarNotFoundException(id_centar_vdomuvanje));

        Optional<Mileniche> newMileniche = this.milenicheRepository.findById(id_mileniche);
        if (newMileniche.equals(Optional.empty())) {
            return Optional.of(this.milenicheRepository.save(new Mileniche(id_mileniche, ime, vid, rasa, pol, boja, id_centar_vdomuvanje, datum_smestuvanje, id_opstina, datum_naogjanje, opis_lokacija)));
        } else {
            throw new MilenicheAlreadyExists(id_mileniche);
        }
    }

    @Override
    public Optional<Mileniche> updateVdomenoMileniche(Integer id_mileniche, String embg_klient) {
        Klient klient = this.klientRepository.findByEmbg(embg_klient).orElseThrow(() -> new KlientNotFoundException(embg_klient));
        Mileniche mileniche = this.milenicheRepository.findById(id_mileniche).orElseThrow(() -> new MilenicheNotFoundException(id_mileniche));

        Date today = new Date(System.currentTimeMillis());
        mileniche.setDatum_vdomuvanje(today);

        mileniche.setEmbg_klient(embg_klient);

        return Optional.of(this.milenicheRepository.save(mileniche));
    }

    @Override
    public Optional<Mileniche> updatePregledanoMileniche(Integer id_mileniche, Integer id_veterinaren_centar, String zdravstvena_sostojba) {
        VeterinarenCentar veterinarenCentar = this.veterinarenCentarRepository.findById(id_veterinaren_centar).orElseThrow(() -> new VeterinarenCentarNotFound(id_veterinaren_centar));
        Mileniche mileniche = this.milenicheRepository.findById(id_mileniche).orElseThrow(() -> new MilenicheNotFoundException(id_mileniche));

        Date today = new Date(System.currentTimeMillis());
        mileniche.setDatum_vdomuvanje(today);

        mileniche.setZdravstvena_sostojba(zdravstvena_sostojba);

        return Optional.of(this.milenicheRepository.save(mileniche));

    }
}
