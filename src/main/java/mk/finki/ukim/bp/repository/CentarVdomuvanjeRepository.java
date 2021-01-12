package mk.finki.ukim.bp.repository;

import mk.finki.ukim.bp.model.centar_vdomuvanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentarVdomuvanjeRepository extends JpaRepository<centar_vdomuvanje, Integer> {

    Optional<centar_vdomuvanje> findById(int id_centar_vdomuvanje);


}
