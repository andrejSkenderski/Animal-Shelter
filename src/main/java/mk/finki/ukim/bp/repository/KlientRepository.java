package mk.finki.ukim.bp.repository;

import mk.finki.ukim.bp.model.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KlientRepository extends JpaRepository<Klient, String> {
    Optional<Klient> findByEmbg(String embg);
    List<Klient> findAll();
//    void deleteByEmbg (String embg);

}
