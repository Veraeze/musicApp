package VeeMuz.app.data.repository;

import VeeMuz.app.data.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Optional<Playlist> findPlaylistByName(String name);
}
