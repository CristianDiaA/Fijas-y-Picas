package gestion;

import java.sql.*;
public class GestorConexion {

    public static Connection obtenerConexion() throws ClassNotFoundException, SQLException {
        String usuario = "neondb_owner";
        String clave = "npg_jVGXdyPwc62Z";
        String url = "jdbc:postgresql://ep-billowing-union-acrop7i3-pooler.sa-east-1.aws.neon.tech:5432/neondb";

        Class.forName("org.postgresql.Driver");
        //return DriverManager.getConnection("jdbc:h2:mem:mibasedatos", "admin", "123456");
        return DriverManager.getConnection(url, usuario, clave);
    }

        public static void inicializarBaseDeDatos() {
        String sql = """
            CREATE TABLE IF NOT EXISTS fijasypicas (
                id SERIAL PRIMARY KEY,
                nombre VARCHAR(100),
                intentos INT,
                numeroAdivinado VARCHAR(100),
                TiempoSegundos INT
            )
        """;

        try (Connection conn = GestorConexion.obtenerConexion();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'fijasypicas' verificada/creada.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

}
