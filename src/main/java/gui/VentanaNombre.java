package gui;
import javax.swing.*;
import usu.Jugador;

public class VentanaNombre extends JPanel {
    private Jugador jugador;

    public VentanaNombre(Jugador jugador) {
        this.jugador = jugador;
        setLayout(null);

        inicializarComponentes();
    }
    public void inicializarComponentes(){
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 450, 300);

        JLabel titulo = new JLabel("Ingrese su nombre");
        titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        titulo.setBounds(120, 10, 300, 30);
        panelMenu.add(titulo);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(100, 60, 250, 30);
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        panelMenu.add(txtNombre);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(150, 120, 150, 40);
        panelMenu.add(btnAceptar);

         btnAceptar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            if (!nombre.isEmpty()) {
                jugador.setNombre(nombre);
                JOptionPane.showMessageDialog(this, "¡Bienvenido, " + nombre + "!");
                SwingUtilities.getWindowAncestor(this).dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panelMenu);
    }
}