package mk.finki.ukim.bp.service.impl;

import mk.finki.ukim.bp.model.opstina;
import mk.finki.ukim.bp.repository.OpstinaRepository;
import mk.finki.ukim.bp.service.OpstinaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpstinaServiceImpl implements OpstinaService {
    private final OpstinaRepository opstinaRepository;

    public OpstinaServiceImpl(OpstinaRepository opstinaRepository) {
        this.opstinaRepository = opstinaRepository;
    }

    @Override
    public List<opstina> listAll() {
        return this.opstinaRepository.findAll();
    }

    @Override
    public Optional<opstina> findById(int id_opstina) {
        return this.opstinaRepository.findById(id_opstina);
    }
}
