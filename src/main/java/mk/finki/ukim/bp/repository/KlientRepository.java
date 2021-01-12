package mk.finki.ukim.bp.repository;

import mk.finki.ukim.bp.model.klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KlientRepository extends JpaRepository<klient, String> {
    Optional<klient> findByEmbg(String embg);
    List<klient> findAll();
    void deleteByEmbg (String embg);

}
