package VeeMuz.app.service;

import VeeMuz.app.data.model.User;
import VeeMuz.app.data.repository.UserRepository;
import VeeMuz.app.dtos.request.RegistrationRequest;
import VeeMuz.app.dtos.response.RegistrationResponse;
import VeeMuz.app.exception.MusicException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static VeeMuz.app.service.validate.ValidateUser.*;


@Service
@AllArgsConstructor
public class UserServiceApp implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public RegistrationResponse register(RegistrationRequest request) throws MusicException {
        validateName(request.getName());
        validateEmail(request.getEmailAddress());
        validatePassword(request.getPassword());

        if (emailExist(request.getEmailAddress())){
            throw new MusicException("A user with this email already exists, kindly try again with a different email");
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        request.setPassword(user.getPassword());
        modelMapper.map(request, user);
        userRepository.save(user);

        RegistrationResponse response = new RegistrationResponse();
        response.setId(user.getId());

        return response;
    }

    private boolean emailExist(String email) {
        User user = userRepository.findUserByEmailAddress(email);
        return user != null;
    }

    public User findUserBy(Long userId) throws MusicException {
        return userRepository.findById(userId).orElseThrow(()->new MusicException("user not found"));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
