package Service;

import model.Usuario;

import java.util.regex.Pattern;

public class EmailValidator {


    public EmailValidator() {
    }


    private final Pattern GMAIL_PATTERN =
            Pattern.compile("^[a-z0-9](\\.?[a-z0-9]){4,29}@gmail\\.com$", Pattern.CASE_INSENSITIVE);





    public boolean esValido(String email, String password) {
        if (email == null || password == null) {
            return false;
        }

        return GMAIL_PATTERN.matcher(email).matches();
    }
}