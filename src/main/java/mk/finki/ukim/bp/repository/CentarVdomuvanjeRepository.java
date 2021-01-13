package mk.finki.ukim.bp.repository;

import mk.finki.ukim.bp.model.CentarVdomuvanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentarVdomuvanjeRepository extends JpaRepository<CentarVdomuvanje, Integer> {

    Optional<CentarVdomuvanje> findById(int id_centar_vdomuvanje);


}
