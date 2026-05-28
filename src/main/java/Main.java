import gestion.OperacionesNumero;
import gui.VentanaMenu;

import javax.swing.SwingUtilities;

public class Main {
public static void main(String[] asrs){
        System.out.println("Inicio aplicación.");
        SwingUtilities.invokeLater(() -> {
            new VentanaMenu().setVisible(true);
        });
} 
}
