package VeeMuz.app.service;

import VeeMuz.app.dtos.request.*;
import VeeMuz.app.dtos.response.AddSongResponse;
import VeeMuz.app.dtos.response.CreatePlaylistResponse;
import VeeMuz.app.dtos.response.SearchArtistResponse;
import VeeMuz.app.dtos.response.SearchMusicResponse;
import VeeMuz.app.exception.MusicException;

public interface MusicService {
    CreatePlaylistResponse createPlaylist(CreatePlaylistRequest request);

    SearchMusicResponse searchMusic(SearchMusicRequest request) throws MusicException;

    SearchArtistResponse searchArtist(SearchArtistRequest request) throws MusicException;

    AddSongResponse addSongToPlaylist(AddSongRequest request);

    void removeSongFromPlaylist(RemoveSongRequest request);
}
