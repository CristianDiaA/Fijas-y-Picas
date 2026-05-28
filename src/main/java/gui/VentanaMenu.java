package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends JFrame {
    private JLabel titulo;
    private JLabel lblNombre;
    private JButton btnJugar;
    private JButton btnPuntajes;
    private JButton btnSalir;
    public VentanaMenu() {
        setTitle("Fijas Y Picas");
        setSize(550, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        inicializarComponentes();

    }
    public void inicializarComponentes(){
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 550, 300);

        //ETIQUETAS
        titulo = new JLabel("Fijas Y Picas");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(200, 10, 200, 30);
        panelMenu.add(titulo);

        lblNombre = new JLabel("@CristianDavidDiazAlarcon");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
        lblNombre.setBounds(10, 240, 200, 20);
        panelMenu.add(lblNombre);

        //BOTONES
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(180, 60, 200, 50);
        panelMenu.add(btnJugar);

        btnPuntajes = new JButton("Puntajes");
        btnPuntajes.setBounds(180, 120, 200, 50);
        panelMenu.add(btnPuntajes);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(180, 180, 200, 50);
        panelMenu.add(btnSalir);

        //AGREGAR PANEL
        add(panelMenu);

        //ACCIONES DE LOS BOTONES
        btnSalir.addActionListener(e -> System.exit(0));
        btnJugar.addActionListener(e -> {
            JDialog JuegoDialog = new JDialog(this, "JUEGO FIJAS Y PICAS", true);
            VentajaJuego ventanaJuego = new VentajaJuego();
            JuegoDialog.add(ventanaJuego);
            JuegoDialog.setSize(550, 600);
            JuegoDialog.setLocationRelativeTo(null);
            JuegoDialog.setVisible(true);
        });

        btnPuntajes.addActionListener(e -> {
            JDialog puntajesDialog = new JDialog(this, "PUNTAJES", true);
            VentanaPuntajes ventanaPuntajes = new VentanaPuntajes();
            ventanaPuntajes.setVisible(true);
            puntajesDialog.add(ventanaPuntajes);
            puntajesDialog.setSize(550, 300);
            puntajesDialog.setLocationRelativeTo(null);
            puntajesDialog.setVisible(true);
        });
    }
}
