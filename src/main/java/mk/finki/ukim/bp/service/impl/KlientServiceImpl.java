package mk.finki.ukim.bp.service.impl;

import mk.finki.ukim.bp.model.exceptions.KlientAlreadyExists;
import mk.finki.ukim.bp.model.exceptions.OpstinaNotFoundException;
import mk.finki.ukim.bp.model.klient;
import mk.finki.ukim.bp.model.opstina;
import mk.finki.ukim.bp.repository.KlientRepository;
import mk.finki.ukim.bp.repository.OpstinaRepository;
import mk.finki.ukim.bp.service.KlientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class KlientServiceImpl implements KlientService {

    private final KlientRepository klientRepository;
    private final OpstinaRepository opstinaRepository;

    public KlientServiceImpl(KlientRepository klientRepository, OpstinaRepository opstinaRepository) {
        this.klientRepository = klientRepository;
        this.opstinaRepository = opstinaRepository;
    }

    @Override
    public List<klient> listAll() {
        return this.klientRepository.findAll();
    }

    @Override
    public Optional<klient> findByEmbg(String embg) {
        return this.klientRepository.findByEmbg(embg);
    }

    @Override
    public Optional<klient> addKlient(String embg, String ime, String prezime, String adresa, Integer id_opstina) {
        opstina newOpstina = this.opstinaRepository.findById(id_opstina).orElseThrow(() -> new OpstinaNotFoundException(id_opstina));
        Optional<klient> newKlient = this.klientRepository.findByEmbg(embg);

        if (newKlient.equals(Optional.empty())) {
            return Optional.of (this.klientRepository.save(new klient (embg,ime,prezime,adresa,id_opstina)));
        }else {
            throw new KlientAlreadyExists(embg);
        }
    }

    @Override
    public void deleteByEmbg(String embg) {
        this.klientRepository.deleteByEmbg(embg);
    }

}
