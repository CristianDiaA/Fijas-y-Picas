package gestion;
import usu.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesJugador implements OperacionesGeneric<Jugador> {

    public void crear(Jugador entidad) {
        String sql = "insert into fijasypicas (nombre, intentos, numeroAdivinado, tiemposegundos) values (?, ?, ?, ?)";

    try (Connection con = GestorConexion.obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.println("Conectado a DB");

            ps.setString(1, entidad.getNombre());
            ps.setInt(2, entidad.getIntentos());
            ps.setString(3, entidad.getNumeroG());
            ps.setInt(4, entidad.getTiempo());

            int filas = ps.executeUpdate();

            System.out.println("Filas insertadas: " + filas);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
    public List<Jugador> obtenerTodos(){
        List<Jugador> jugadores=new ArrayList<>();
        String sql = "select * from fijasypicas";
        try(Connection con = GestorConexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre =rs.getString("nombre");
                int intentos =rs.getInt("intentos");
                String numeroG =rs.getString("numeroAdivinado");
                int tiempo =rs.getInt("tiemposegundos");
                Jugador jugador = Jugador
                    .builder()
                    .nombre(nombre)
                    .intentos(intentos)
                    .numeroG(numeroG)
                    .tiempo(tiempo)
                    .build();
                jugadores.add(jugador);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return jugadores;
    }
    
}
