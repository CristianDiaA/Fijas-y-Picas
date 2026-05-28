package gui;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class VentanaPuntajes extends JPanel {
    private JLabel premiumPanel;    
    private JLabel titulo;
    private JLabel lblNumeroCuenta;
    private JButton btnPagar;
    private JButton btnVolver;
    public VentanaPuntajes() {
        setLayout(null);

        inicializarComponentes();
    }
    public void inicializarComponentes(){
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 550, 300);

        titulo = new JLabel("PUNTAJES PREMIUM");
        titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        titulo.setBounds(80, 10, 450, 30);
        panelMenu.add(titulo);

        premiumPanel = new JLabel("PAGA AL SIGUIENTE NUMERO DE CUENTA PARA OBTENER LOS PUNTAJES PREMIUM");
        premiumPanel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
        premiumPanel.setBounds(50, 50, 450, 30);
        panelMenu.add(premiumPanel);

        lblNumeroCuenta = new JLabel("Nequi/Daviplata: 312 458 6437");
        lblNumeroCuenta.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        lblNumeroCuenta.setBounds(150, 100, 400, 30);
        panelMenu.add(lblNumeroCuenta);

        btnPagar = new JButton("Pagar");
        btnPagar.setBounds(200, 150, 100, 30);
        panelMenu.add(btnPagar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(200, 200, 100, 30);
        panelMenu.add(btnVolver);

        add(panelMenu);

        btnPagar.addActionListener(e -> {
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI("https://clientes.nequi.com.co/recargas"));

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "No se pudo abrir el enlace",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        btnVolver.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Has vuelto al menú principal.");
            SwingUtilities.getWindowAncestor(this).dispose();
        });
    }
}
