package VeeMuz.app.service;

import VeeMuz.app.data.model.Playlist;
import VeeMuz.app.data.model.User;
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
        return null;
    }

    @Override
    public SearchArtistResponse searchArtist(SearchArtistRequest request) throws MusicException {
        return null;
    }
}
