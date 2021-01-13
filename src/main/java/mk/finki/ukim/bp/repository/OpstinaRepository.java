package mk.finki.ukim.bp.repository;


import mk.finki.ukim.bp.model.Opstina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpstinaRepository extends JpaRepository<Opstina, Integer> {
    Optional<Opstina> findById(int id_opstina);

}