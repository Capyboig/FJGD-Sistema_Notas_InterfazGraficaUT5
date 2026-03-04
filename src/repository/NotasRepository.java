package repository;

import exceptions.NotaNoExistenteException; // Importa tu excepción

import java.io.BufferedReader;
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
        } catch (IOException e) {
            System.err.println("[ERROR] No se pudo guardar la nota: " + e.getMessage());
        }
    }

    public List<String> traerNotas(String emailSanitizado) throws IOException {
        Path rutaArchivo = Paths.get(RUTA_BASE, emailSanitizado, "notas.txt");
        List<String> notas = new ArrayList<>();

        if (!Files.exists(rutaArchivo)) return notas;

        try (BufferedReader reader = Files.newBufferedReader(rutaArchivo)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                notas.add(linea);
            }
        }
        return notas;
    }

    public String obtenerNotaPorNumero(String email, int numero) throws NotaNoExistenteException, IOException {
        List<String> notas = traerNotas(email);

        if (numero <= 0 || numero > notas.size()) {
            throw new NotaNoExistenteException("[ERROR] La nota número " + numero + " no existe.");
        }

        return notas.get(numero - 1);
    }

    public void eliminarNota(String emailSanitizado, int numeroEliminar) throws IOException, NotaNoExistenteException {
        Path rutaArchivo = Paths.get(RUTA_BASE, emailSanitizado, "notas.txt");
        List<String> notas = traerNotas(emailSanitizado);

        if (numeroEliminar <= 0 || numeroEliminar > notas.size()) {
            throw new NotaNoExistenteException("[ERROR] Imposible eliminar: La nota " + numeroEliminar + " no existe.");
        }

        notas.remove(numeroEliminar - 1);

        // Files.write con una lista de strings escribe cada elemento en una línea nueva automáticamente
        Files.write(rutaArchivo, notas, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

        System.out.println("[EXITO] Nota eliminada del fichero.");
    }
}