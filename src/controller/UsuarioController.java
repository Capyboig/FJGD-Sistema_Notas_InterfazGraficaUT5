package controller;

import Service.EmailValidator;
import Service.RegisterService;
import model.Usuario;

public class UsuarioController {
    private String email;
    private String password;
    private RegisterService registerService = new RegisterService();
    private EmailValidator emailValidator = new EmailValidator();

    public UsuarioController(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean llamadaDeRegistro() {
        if (emailValidator.esValido(this.email, this.password)) {
            registerService.almacenarUsuario(this.email, this.password);
            return true;
        }
        return false;
    }
}