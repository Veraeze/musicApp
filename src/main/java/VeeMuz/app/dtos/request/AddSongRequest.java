package VeeMuz.app.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddSongRequest {
    private String musicName;
    private String playlistName;

}
