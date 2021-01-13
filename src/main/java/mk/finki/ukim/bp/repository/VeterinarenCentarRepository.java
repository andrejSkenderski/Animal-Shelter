package mk.finki.ukim.bp.repository;


import mk.finki.ukim.bp.model.VeterinarenCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeterinarenCentarRepository extends JpaRepository<VeterinarenCentar, Integer> {
    Optional<VeterinarenCentar> findById (int id_veterinaren_centar);

}