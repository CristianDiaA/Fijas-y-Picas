package gui;
import java.util.Arrays;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.*;

import usu.Jugador;
import gestion.*;
import java.util.Timer;
import java.util.TimerTask;

public class VentajaJuego extends JPanel {
        private Jugador jugador;

        private JLabel titulo;
        private JLabel lblNombre;
        private JLabel lblIntentos;
        private JLabel lblTiempo;

        private OperacionesNumero opr;

        private int intentos;
        private int[] numeroAdivinar;
        private int[] numeroUsuario;
        private int segundos;

        private Timer timer;

        private JTextField txtNumero;

        private JButton btnIngresar;
        private JButton btnSalir;

        private JTextArea areaResultados;

    public VentajaJuego() {
        setLayout(null);

        inicializarComponentes();

    }
    public void inicializarComponentes(){
        if (jugador == null) {
            jugador = new Jugador();
        }
        if (jugador.getNombre() == null){
        JDialog nomb = new JDialog((java.awt.Frame) null, "REGISTRO", true);
        VentanaNombre requiNombre = new VentanaNombre(jugador);
        nomb.setContentPane(requiNombre);
        nomb.setSize(450, 300);
        nomb.setLocationRelativeTo(null);
        nomb.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        nomb.setVisible(true);
}
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 520, 600);

        titulo = new JLabel("FIJAS Y PICAS");
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(Color.decode("#6f00ff"));
        titulo.setBounds(135, 10, 400, 30);
        panelMenu.add(titulo);

        lblNombre = new JLabel("Jugador: " + jugador.getNombre());
        lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
        lblNombre.setBounds(10, 530, 200, 20);
        panelMenu.add(lblNombre);

        lblIntentos = new JLabel("# Intentos: "+intentos);
        lblIntentos.setFont(new Font("Arial", Font.BOLD, 12));
        lblIntentos.setBounds(440, 10, 200, 20);
        panelMenu.add(lblIntentos);

        lblTiempo = new JLabel("Tiempo: "+jugador.getTiempo()+" Seg");
        lblTiempo.setFont(new Font("Arial", Font.BOLD, 12));
        lblTiempo.setBounds(10, 10, 200, 20);
        panelMenu.add(lblTiempo);

        txtNumero = new JTextField();
        txtNumero.setFont(new Font("Arial", Font.BOLD, 40));
        txtNumero.setHorizontalAlignment(JTextField.CENTER);
        txtNumero.setBounds(170, 70, 200, 50);
        panelMenu.add(txtNumero);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(170, 150, 200, 40);
        panelMenu.add(btnIngresar);
    
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(410, 530, 100, 20);
        panelMenu.add(btnSalir);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultados);
        scrollPane.setBounds(50, 200, 435, 300);
        panelMenu.add(scrollPane);
        opr = new OperacionesNumero();
        numeroAdivinar = opr.getNumero();

        add(panelMenu);
        iniciarTiempo();

        btnSalir.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this).dispose();
        });

        btnIngresar.addActionListener(e -> {
            String numeroIngresado = txtNumero.getText().trim();
            // Validar longitud
            if (numeroIngresado.length() != 4) {
                JOptionPane.showMessageDialog(
                        this,
                        "El número debe tener exactamente 4 dígitos.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            // Validar que sean números
            if (!esNumerico(numeroIngresado)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Por favor, ingrese solo números.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                txtNumero.setText("");
                return;
            }
            numeroUsuario = new int[4];
            // Convertir String a arreglo de enteros
            for (int i = 0; i < 4; i++) {
                numeroUsuario[i] =
                        Character.getNumericValue(numeroIngresado.charAt(i));
            }
            // Validar repetidos
            if (!verificarNoRepetir(numeroUsuario)) {
                return;
            }
            // Verificar resultado
            verificarFijasYPicas();
        });
    }
    public void iniciarTiempo() {
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            segundos++;
            SwingUtilities.invokeLater(() -> {
                lblTiempo.setText("Tiempo: " + segundos + " Seg");
            });
        }
    }, 1000, 1000);
}
    public boolean esNumerico(String cadena) {
        try{
         return cadena != null && cadena.matches("^\\d+$");
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void verificarFijasYPicas() {
        int fijas = 0;
        int picas = 0;
        for (int i = 0; i < 4; i++) {
            if (numeroUsuario[i] == numeroAdivinar[i]) {
                fijas++;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (numeroUsuario[i] == numeroAdivinar[j]) {
                        picas++;
                    }
                }
            }
        }
        areaResultados.append(Arrays.toString(numeroUsuario) +" "+
                ": " + fijas + " Fijas, "
                + picas + " Picas\n");
        intentos++;
        lblIntentos.setText("# Intentos: "+intentos);
        if (fijas == 4) {
                timer.cancel();
            areaResultados.append(
                    "¡Felicidades! Has adivinado el número en "
                    + intentos + " intentos.\n");
            btnIngresar.setEnabled(false);
            jugador.setTiempo(segundos);
            jugador.setIntentos(intentos);
            int valortotal = opr.getNumeroInt();
            jugador.setNumeroG(String.valueOf(valortotal));
            guardarDatos();
        }
    }
    public boolean verificarNoRepetir(int[] numeroUsuario){
        for (int i = 0; i < numeroUsuario.length; i++) {
            for (int j = i + 1; j < numeroUsuario.length; j++) {
                if (numeroUsuario[i] == numeroUsuario[j]) {
                    JOptionPane.showMessageDialog(this,
                            "Los dígitos no pueden repetirse.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }
    public void guardarDatos(){
        try {
            System.out.println("Entró a guardarDatos()");
            String nombre =jugador.getNombre();
                int intentos =jugador.getIntentos();
                String numeroG =jugador.getNumeroG();
                int tiempo =jugador.getTiempo();
                Jugador nuevojugador = Jugador
                    .builder()
                    .nombre(nombre)
                    .intentos(intentos)
                    .numeroG(numeroG)
                    .tiempo(tiempo)
                    .build();
            OperacionesJugador oper = new OperacionesJugador();
            oper.crear(nuevojugador);
            JOptionPane.showMessageDialog(
                    this,
                    "Datos guardados correctamente"
            );
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al guardar los datos: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}