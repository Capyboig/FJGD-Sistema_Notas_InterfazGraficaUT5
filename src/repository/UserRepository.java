package repository;

import model.Usuario;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;


public class UserRepository {

    public static void almacenarUsuario(Usuario usuario, String password) {
        Path ruta = Paths.get("src/data/informacionUsuarios.txt");

        System.out.println("Guardando en: " + ruta.toAbsolutePath());

        String contenido = "Email: " + usuario.getEmail() + " | Pass: " + password + System.lineSeparator();

        try {
            Files.writeString(ruta, contenido,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("[ERROR] al escribir el archivo: " + e.getMessage());
        }
    }






    public static boolean comprobarCredenciales(String email, String password) {
        Path ruta = Paths.get("src/data/informacionUsuarios.txt");
        String lineaBuscada = "Email: " + email + " | Pass: " + password;

        try {

            java.util.List<String> lineas = Files.readAllLines(ruta);


            for (String linea : lineas) {
                if (linea.trim().equals(lineaBuscada)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("[ERROR] al leer el archivo: " + e.getMessage());
        }

        return false;
    }

}
