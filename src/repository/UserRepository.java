package repository;

import model.Usuario;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;


public class UserRepository {
    private static final String RUTA_BASE = "src/data/informacionUsuarios.txt";

    public static void almacenarUsuario(Usuario usuario) {
        Path ruta = Paths.get(RUTA_BASE);
        String contenido = "Email: " + usuario.getEmail() + " | Pass: " + usuario.getPassword() + System.lineSeparator();

        try (BufferedWriter writer = Files.newBufferedWriter(ruta, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(contenido);
        } catch (IOException e) {
            System.err.println("[ERROR] al escribir el archivo: " + e.getMessage());
        }
    }

    public boolean existeEmail(String email) {
        Path ruta = Path.of(RUTA_BASE);
        String patron = "Email: " + email + " |";

        try {
            java.util.List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);

            for (String linea : lineas) {
                if (linea.contains(patron)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("[ERROR] al leer el archivo: " + e.getMessage());
        }

        return false;
    }





    public static boolean comprobarCredenciales(String email, String password) {
        Path ruta = Paths.get(RUTA_BASE);

        String passwordHash = security.SecurityUtils.encriptarSHA256(password);

        String lineaBuscada = "Email: " + email + " | Pass: " + passwordHash;

        try {
            if (Files.exists(ruta)) {
                java.util.List<String> lineas = Files.readAllLines(ruta);
                for (String linea : lineas) {
                    if (linea.trim().equals(lineaBuscada)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("[ERROR] al leer el archivo: " + e.getMessage());
        }
        return false;
    }

}
