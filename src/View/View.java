package View;

import Service.LoginService;
import Service.RegisterService;
import controller.UsuarioController;

import java.io.IOException;
import java.util.Scanner;

public class View {
    private Scanner sc = new Scanner(System.in);

    public View() {

    }

    LoggedInterface loggedInterface = new LoggedInterface();
    RegisterService registerService = new RegisterService();
    public void mostrarMenu() throws IOException {

            System.out.println("======== MENU ========");
            System.out.println("1.- Registrar Usuario");
            System.out.println("2.- Login Usuario");
            System.out.println("3.- Salir");
            int opcionMenu = sc.nextInt();
            sc.nextLine();



            switch (opcionMenu) {
                case 1:
                    System.out.println("Introduce el gmail para registrar al usuario");
                    String email = sc.nextLine();

                    System.out.println("Introduce la contraseña");
                    String password = sc.nextLine();

                    UsuarioController usuarioController = new UsuarioController(email, password);


                    if (!usuarioController.llamadaDeRegistro()) {
                        System.out.println("[ERROR] El email no es válido (recuerda usar @gmail.com)");
                    } else {
                        System.out.println("[EXITO] Se ha registrado correctamente el usuario");
                    }
                    break;



                case 2:
                    System.out.println("Introduce tu email para iniciar sesión:");
                    String emailLogin = sc.nextLine();

                    System.out.println("Introduce tu contraseña:");
                    String passLogin = sc.nextLine();


                    LoginService loginService = new LoginService();


                    if (loginService.hacerLogin(emailLogin, passLogin)) {
                        System.out.println("[EXITO] ¡Bienvenido! Has iniciado sesión correctamente.");
                        loggedInterface.emailSanitizado = registerService.sanitizarEmail(emailLogin);
                        loggedInterface.setSc(sc);

                        loggedInterface.mostrarMenuLogin();

                    } else {
                        System.out.println("[ERROR] Email o contraseña incorrectos, o el usuario no existe.");
                    }



                    break;


                case 3:

                    System.out.println("Saliendo....");

                    break;



            }






        }
    }

