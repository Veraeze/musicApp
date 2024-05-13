package VeeMuz.app.util;

import VeeMuz.app.data.model.User;

public class Mapper {
    public static User userMap(String name, String emailAddress, String password){
        User user = new User();
        user.setName(name);
        user.setEmailAddress(emailAddress);
        user.setPassword(password);

        return user;

    }
}
