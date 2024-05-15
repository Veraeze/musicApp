package VeeMuz.app.service;

import VeeMuz.app.data.model.Artist;
import VeeMuz.app.data.model.Music;
import VeeMuz.app.data.model.Playlist;
import VeeMuz.app.data.model.User;
import VeeMuz.app.data.repository.ArtistRepository;
import VeeMuz.app.data.repository.MusicRepository;
import VeeMuz.app.data.repository.PlaylistRepository;
import VeeMuz.app.dtos.request.CreatePlaylistRequest;
import VeeMuz.app.dtos.request.SearchArtistRequest;
import VeeMuz.app.dtos.request.SearchMusicRequest;
import VeeMuz.app.dtos.response.CreatePlaylistResponse;
import VeeMuz.app.dtos.response.SearchArtistResponse;
import VeeMuz.app.dtos.response.SearchMusicResponse;
import VeeMuz.app.exception.MusicException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static VeeMuz.app.service.validate.ValidateUser.validateName;

@Service
@AllArgsConstructor
public class MusicServiceApp implements MusicService{

    private final PlaylistRepository playlistRepository;
    private final MusicRepository musicRepository;
    private final ArtistRepository artistRepository;
    private UserServiceApp userService;
    private final ModelMapper modelMapper;


    @Override
    public CreatePlaylistResponse createPlaylist(CreatePlaylistRequest request) {
        validateName(request.getName());

        Optional<Playlist> optionalEvent = playlistRepository.findPlaylistByName(request.getName());
        if (optionalEvent.isEmpty()) {
            throw new MusicException("A playlist with this name already exist");
        }

        User user = userService.findUserBy(request.getUserId());

        Playlist playlist = new Playlist();
        request.setUserId(user.getId());
        modelMapper.map(request, playlist);
        userService.saveUser(user);
        playlistRepository.save(playlist);

        CreatePlaylistResponse response = new CreatePlaylistResponse();
        response.setId(playlist.getId());
        return response;
    }

    @Override
    public SearchMusicResponse searchMusic(SearchMusicRequest request) throws MusicException {
        validateName(request.getName());
        Music music = findMusic(request.getName());

        SearchMusicResponse response = new SearchMusicResponse();
        response.setMusic(music);
        return response;
    }

    private Music findMusic(String name) {
        Optional<Music> optionalMusic = musicRepository.findMusicByName(name);

        if (optionalMusic.isEmpty()){
            throw new MusicException("Music not found");
        }

        return optionalMusic.get();

    }

    @Override
    public SearchArtistResponse searchArtist(SearchArtistRequest request) throws MusicException {
        validateName(request.getName());
        Artist artist = findArtist(request.getName());

        SearchArtistResponse response = new SearchArtistResponse();
        response.setArtist(artist);
        return response;
    }

    private Artist findArtist(String name) {
        Optional<Artist> optionalArtist = artistRepository.findArtistByName(name);

        if (optionalArtist.isEmpty()){
            throw new MusicException("Artist not found");
        }

        return optionalArtist.get();

    }
}
