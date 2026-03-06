package View;

import repository.NotasRepository;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private String emailSanitizado;
    private NotasRepository notasRepository;

    private DefaultListModel<String> modeloLista;
    private JList<String> listaNotas;
    private JTextField txtTitulo;
    private JTextArea txtContenido;

    public VentanaPrincipal(String emailSanitizado) {
        this.emailSanitizado = emailSanitizado;
        this.notasRepository = new NotasRepository();

        setTitle("Gestor de Notas - Usuario: " + emailSanitizado);
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));


        modeloLista = new DefaultListModel<>();
        listaNotas = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaNotas);
        scrollLista.setPreferredSize(new Dimension(200, 0));

        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Tus Notas"));
        panelIzquierdo.add(scrollLista, BorderLayout.CENTER);
        add(panelIzquierdo, BorderLayout.WEST);


        JPanel panelCentral = new JPanel(new BorderLayout(5, 5));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.add(new JLabel("Título: "), BorderLayout.WEST);
        txtTitulo = new JTextField();
        panelTitulo.add(txtTitulo, BorderLayout.CENTER);
        panelCentral.add(panelTitulo, BorderLayout.NORTH);

        txtContenido = new JTextArea();
        panelCentral.add(new JScrollPane(txtContenido), BorderLayout.CENTER);


        JPanel panelBotones = new JPanel();
        JButton btnGuardar = new JButton("Crear / Sobrescribir");
        JButton btnEliminar = new JButton("Eliminar Seleccionada");
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCerrarSesion);
        panelCentral.add(panelBotones, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);



        cargarNotasEnLista();


        listaNotas.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && listaNotas.getSelectedIndex() != -1) {
                int numeroNota = listaNotas.getSelectedIndex() + 1;
                try {
                    String notaCompleta = notasRepository.obtenerNotaPorNumero(emailSanitizado, numeroNota);
                    String[] partes = notaCompleta.split(";");
                    if (partes.length >= 2) {
                        txtTitulo.setText(partes[0]);
                        txtContenido.setText(partes[1]);
                    }
                } catch (Exception ex) {
                    System.out.println("Error al cargar nota: " + ex.getMessage());
                }
            }
        });


        btnGuardar.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            String contenido = txtContenido.getText();

            if (titulo.isEmpty() || contenido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El título y el contenido no pueden estar vacíos.");
                return;
            }

            try {
                notasRepository.guardarNota(emailSanitizado, titulo, contenido);
                JOptionPane.showMessageDialog(this, "Nota guardada con éxito.");
                txtTitulo.setText("");
                txtContenido.setText("");
                cargarNotasEnLista();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
            }
        });


        btnEliminar.addActionListener(e -> {
            int index = listaNotas.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una nota de la lista primero.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de borrar esta nota?", "Borrar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    notasRepository.eliminarNota(emailSanitizado, index + 1);
                    JOptionPane.showMessageDialog(this, "Nota eliminada.");
                    txtTitulo.setText("");
                    txtContenido.setText("");
                    cargarNotasEnLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
                }
            }
        });

        btnCerrarSesion.addActionListener(e -> {
            this.dispose();
            new VentanaLogin().setVisible(true);
        });
    }

    private void cargarNotasEnLista() {
        modeloLista.clear();
        try {
            List<String> notas = notasRepository.traerNotas(emailSanitizado);
            for (String linea : notas) {
                String[] partes = linea.split(";");
                modeloLista.addElement(partes[0]);
            }
        } catch (Exception ex) {
            System.out.println("No se pudieron cargar las notas.");
        }
    }
}