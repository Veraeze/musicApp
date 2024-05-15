package VeeMuz.app.dtos.response;

import VeeMuz.app.data.model.Artist;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchArtistResponse {

    private Artist artist;

}
