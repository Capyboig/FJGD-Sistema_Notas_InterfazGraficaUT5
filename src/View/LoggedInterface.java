package View;

import exceptions.NotaNoExistenteException;
import repository.NotasRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoggedInterface {
    String emailSanitizado;
    NotasRepository notasRepository = new NotasRepository();
    private Scanner sc;
    public LoggedInterface() {

    }


    public void mostrarMenuLogin() throws IOException {
        int opcionLogged = 0;

        do {
            System.out.println(" ===== MENU PROFESOR =====");

            System.out.println("1.- Crear nota");
            System.out.println("2.- Listar notas");
            System.out.println("3.- Ver nota por numero");
            System.out.println("4.- Eliminar nota (por numero)");
            System.out.println("5.- Salir");

            opcionLogged = sc.nextInt();
            sc.nextLine();


            switch (opcionLogged) {
                case 1:
                    System.out.println("Introduce el titulo de la nota");
                    String notaTitulo = sc.nextLine();


                    System.out.println("Introduce el contenido para anotar");
                    String contenido = sc.nextLine();

                    notasRepository.guardarNota(emailSanitizado, notaTitulo, contenido);

                    break;



                case 2:
                    System.out.println("Trayendo las notas del usuario");
                    List<String> listaNotas = notasRepository.traerNotas(this.emailSanitizado);

                    if (listaNotas.isEmpty()) {
                        System.out.println("[ERROR] El usuario no tiene notas añadidas o no han podido ser traidas");
                    }

                    for (int i = 0; i < listaNotas.size(); i++) {
                        String linea = listaNotas.get(i);
                        String[] partes = linea.split(";");

                        System.out.println((i + 1) + ".- " + partes[0]);
                    }


                    break;




                case 3:
                    System.out.println("Introduce el numero de nota que quieres ver");
                    if (!sc.hasNextInt()) {
                        System.out.println("[ERROR] Introduce un número válido.");
                        sc.nextLine();
                        break;
                    }
                    int numeroNota = sc.nextInt();
                    sc.nextLine();

                    try {
                        String notaCompleta = notasRepository.obtenerNotaPorNumero(this.emailSanitizado, numeroNota);

                        String[] partesNota = notaCompleta.split(";");
                        System.out.println("---------------------------------");
                        System.out.println("TÍTULO: " + partesNota[0]);
                        System.out.println("CONTENIDO: " + partesNota[1]);
                        System.out.println("---------------------------------");

                    } catch (exceptions.NotaNoExistenteException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        System.out.println("[ERROR] No se pudo leer el archivo de notas.");
                    } catch (Exception e) {
                        System.out.println("[ERROR] Algo salió mal: " + e.getMessage());
                    }
                    break;



                case 4:
                    System.out.println("Introduce el numero de la nota a borrar");
                    int numeroNotaBorrar = sc.nextInt();

                    notasRepository.eliminarNota(emailSanitizado, numeroNotaBorrar);



                    break;



                case 5:



                    break;
            }
        } while(opcionLogged != 5);





    }


    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
