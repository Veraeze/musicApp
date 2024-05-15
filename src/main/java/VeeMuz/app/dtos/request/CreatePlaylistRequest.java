package VeeMuz.app.dtos.request;

import VeeMuz.app.data.model.Music;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CreatePlaylistRequest {
    private String name;
    private List<Music> music;
    private Long userId;
}
