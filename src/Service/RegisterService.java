package Service;

import model.Usuario;
import repository.UserRepository;
import security.SecurityUtils; // La clase que creamos antes

public class RegisterService {
    private Usuario usuario = new Usuario();

    public void almacenarUsuario(String email, String password) {
        this.usuario.setEmail(email);

        String passEncriptada = SecurityUtils.encriptarSHA256(password);

        this.usuario.setPassword(passEncriptada);

        UserRepository.almacenarUsuario(this.usuario);
    }

    public String sanitizarEmail(String email) {
        return email.replace("@", "_").replace(".", "_");
    }
}