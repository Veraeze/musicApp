package VeeMuz.app.dtos.response;

import VeeMuz.app.data.model.Music;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchMusicResponse {

    private Music music;

}
