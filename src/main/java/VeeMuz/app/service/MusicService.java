package VeeMuz.app.service;

import VeeMuz.app.dtos.request.CreatePlaylistRequest;
import VeeMuz.app.dtos.request.SearchMusicRequest;
import VeeMuz.app.dtos.response.CreatePlaylistResponse;
import VeeMuz.app.dtos.response.SearchMusicResponse;
import VeeMuz.app.exception.MusicException;

public interface MusicService {
    CreatePlaylistResponse createPlaylist(CreatePlaylistRequest request);

    SearchMusicResponse searchMusic(SearchMusicRequest request) throws MusicException;


    SearchArtistResponse searchArtist(SearchArtistRequest request) throws MusicException;

}
