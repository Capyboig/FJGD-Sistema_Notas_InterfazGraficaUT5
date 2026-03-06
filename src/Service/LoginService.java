package Service;

import repository.UserRepository;
import Service.LoginService;
public class LoginService {


    public boolean hacerLogin(String email, String password) {
        return UserRepository.comprobarCredenciales(email, password);
    }
}