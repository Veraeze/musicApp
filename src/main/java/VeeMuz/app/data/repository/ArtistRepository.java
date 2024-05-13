package VeeMuz.app.data.repository;

import VeeMuz.app.data.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
