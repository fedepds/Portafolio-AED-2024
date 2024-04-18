import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
    private JTextField nombreTextField;

    public MyFrame() {
        super("Saludo App"); // Título del JFrameForm
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configura el diseño del marco
        setLayout(new FlowLayout());

        // Crea un JLabel para mostrar "Ingresar nombre"
        JLabel label = new JLabel("Ingresar nombre:");
        add(label);

        // Crea un JTextField para que el usuario ingrese su nombre
        nombreTextField = new JTextField(20);
        add(nombreTextField);

        // Crea un JButton para el botón "Saludar"
        JButton botonSaludar = new JButton("Saludar");
        add(botonSaludar);

        // Agrega un ActionListener al botón para manejar su evento de clic
        botonSaludar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtiene el nombre ingresado por el usuario
                String nombre = nombreTextField.getText();

                // Muestra un cuadro de diálogo con el saludo
                JOptionPane.showMessageDialog(null, "¡Hola, " + nombre + "!");
            }
        });

        // Configura el tamaño y la posición del marco
        setSize(300, 150);
        setLocationRelativeTo(null); // Centra el marco en la pantalla
    }

    public static void main(String[] args) {
        // Crea una instancia de tu JFrameForm
        MyFrame frame = new MyFrame();

        // Configura la visibilidad del marco
        frame.setVisible(true);
    }
}
