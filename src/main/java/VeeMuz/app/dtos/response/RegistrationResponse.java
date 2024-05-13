package VeeMuz.app.dtos.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegistrationResponse {
    private Long id;

    @Override
    public String toString() {
        return "UserRegistrationResponse{" +
                "id=" + id +
                '}';
    }
}
