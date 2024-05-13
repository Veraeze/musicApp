package VeeMuz.app.data.repository;

import VeeMuz.app.data.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
