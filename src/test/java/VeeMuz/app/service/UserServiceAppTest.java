package VeeMuz.app.service;

import VeeMuz.app.dtos.request.RegistrationRequest;
import VeeMuz.app.exception.MusicException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserServiceAppTest {
    @Autowired
    private UserService userService;

    @Test
    void testThatAUserCanRegister(){
        RegistrationRequest request = new RegistrationRequest();
        request.setName("vera");
        request.setEmailAddress("vera@email.com");
        request.setPassword("password01!");
        userService.register(request);
    }

    @Test
    void testThatTwoUsersCannotHaveTheSameEmail() {
        RegistrationRequest request = new RegistrationRequest();
        request.setName("user1");
        request.setEmailAddress("user1@email.com");
        request.setPassword("password02!");

        RegistrationRequest request2 = new RegistrationRequest();
        request2.setName("user2");
        request2.setEmailAddress("user1@email.com");
        request2.setPassword("password03!");

        assertThrows(MusicException.class, ()-> userService.register(request));
        assertThrows(MusicException.class, ()-> userService.register(request2));
    }

}