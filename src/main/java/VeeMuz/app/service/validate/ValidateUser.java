package VeeMuz.app.service.validate;

import VeeMuz.app.exception.MusicException;

public class ValidateUser {
    public static void validateName(String name) throws MusicException {
        if (name == null || name.trim().isEmpty()) {
            throw new MusicException("{\"error\": \"name field cannot be empty\"}");
        }
    }

    public static void validateEmail(String email) throws MusicException{
        if (email == null || email.trim().isEmpty()) {
            throw new MusicException("{\"error\": \"email field is empty\"}");
        }
        if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new MusicException("{\"error\": \"invalid email format\"}");
        }
    }

    public static void validatePassword(String password) throws MusicException {
        if (password == null || password.trim().isEmpty()) {
            throw new MusicException("{\"Error\": \"password field is empty, kindly provide your password\"}");
        }

        if (!password.matches("^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()+.=-])(?!.*\\s).{7,}$")) {
            throw new MusicException("{\"Error\": \"password must contain a minimum of 7 characters including letters,numbers and characters\"}");
        }
    }
}
