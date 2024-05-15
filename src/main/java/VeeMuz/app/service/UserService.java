package VeeMuz.app.service;

import VeeMuz.app.data.model.User;
import VeeMuz.app.dtos.request.RegistrationRequest;
import VeeMuz.app.dtos.response.RegistrationResponse;
import VeeMuz.app.exception.MusicException;

public interface UserService {
    RegistrationResponse register(RegistrationRequest request) throws MusicException;

}
