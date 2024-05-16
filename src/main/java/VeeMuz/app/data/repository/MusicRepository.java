package VeeMuz.app.data.repository;

import VeeMuz.app.data.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {
    Optional<Music> findMusicByName(String name);

    List<Music> ;
}
