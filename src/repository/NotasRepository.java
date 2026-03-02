package repository;


import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class NotasRepository {
    private static final String RUTA_BASE = "src/data/usuarios/";

    public void guardarNota(String emailsanitizado, String titulo, String contenido) {
        Path carpetaUsuario = Paths.get(RUTA_BASE, emailsanitizado);
        Path archivoNotas = carpetaUsuario.resolve("notas.txt");

        try {
            if (Files.notExists(carpetaUsuario)) {
                Files.createDirectories(carpetaUsuario);
            }

            String lineaNota = titulo + ";" + contenido + System.lineSeparator();

            Files.writeString(archivoNotas, lineaNota,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            System.out.println("[EXITO] Nota guardada correctamente");
            System.out.println("Guardado con el email " + emailsanitizado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public List<String> traerNotas(String emailSanitizado) throws IOException{
        Path rutaArchivo = Paths.get(RUTA_BASE, emailSanitizado, "notas.txt");


        if (!Files.exists(rutaArchivo)) {
            return new ArrayList<>();
        }

        return Files.readAllLines(rutaArchivo);
    }



    public void eliminarNota(String emailSanitizado, int numeroEliminar) throws IOException {
        Path rutaArchivo = Paths.get(RUTA_BASE, emailSanitizado, "notas.txt");
        List<String> notas = traerNotas(emailSanitizado);


        if (numeroEliminar > 0 && numeroEliminar <= notas.size()) {
            notas.remove(numeroEliminar - 1);
            Files.write(rutaArchivo, notas);
            System.out.println("DEBUG: Notas restantes en lista: " + notas.size());
            System.out.println("[EXITO] Nota eliminada correctamente.");
        } else {
            System.out.println("[ERROR] El número de nota no es válido.");
        }
    }
}
