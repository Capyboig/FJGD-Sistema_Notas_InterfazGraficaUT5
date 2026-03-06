package View;

import Service.LoginService;
import Service.RegisterService;
import controller.UsuarioController;
import exceptions.UsuarioYaExistenteException;
import repository.UserRepository;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {

    private JTextField txtEmail;
    private JPasswordField txtPassword;

    public VentanaLogin() {
        setTitle("Gestor de Notas - Acceso");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel(" Email (@gmail.com):", SwingConstants.CENTER));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel(" Contraseña:", SwingConstants.CENTER));
        txtPassword = new JPasswordField();
        add(txtPassword);

        JButton btnLogin = new JButton("Iniciar Sesión");
        JButton btnRegistrar = new JButton("Registrar");

        add(btnLogin);
        add(btnRegistrar);


        btnLogin.addActionListener(e -> {
            String email = txtEmail.getText();
            String pass = new String(txtPassword.getPassword());

            LoginService loginService = new LoginService();
            RegisterService registerService = new RegisterService();

            if (loginService.hacerLogin(email, pass)) {
                JOptionPane.showMessageDialog(this, "¡Bienvenido!");
                String emailSanitizado = registerService.sanitizarEmail(email);

                this.dispose();
                new VentanaPrincipal(emailSanitizado).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Email o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnRegistrar.addActionListener(e -> {
            String email = txtEmail.getText();
            String pass = new String(txtPassword.getPassword());

            try {
                UserRepository userRepository = new UserRepository();
                if (userRepository.existeEmail(email)) {
                    throw new UsuarioYaExistenteException("El usuario ya existe en el sistema.");
                }

                UsuarioController usuarioController = new UsuarioController(email, pass);

                if (!usuarioController.llamadaDeRegistro()) {
                    JOptionPane.showMessageDialog(this, "El email no es válido (recuerda usar @gmail.com)", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");
                    txtEmail.setText("");
                    txtPassword.setText("");
                }

            } catch (UsuarioYaExistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}