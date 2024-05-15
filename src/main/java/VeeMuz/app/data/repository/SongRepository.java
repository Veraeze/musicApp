package VeeMuz.app.data.repository;

import VeeMuz.app.data.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Music, Long> {
}
