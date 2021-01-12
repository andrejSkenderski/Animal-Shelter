package mk.finki.ukim.bp.repository;


import mk.finki.ukim.bp.model.mileniche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface MilenicheRepository extends JpaRepository<mileniche, Integer> {
    Optional<mileniche> findById(int id_mileniche);


}
