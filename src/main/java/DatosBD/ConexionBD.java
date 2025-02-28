/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConexionBD  {
  private  ConexionBD instancia;
    private static Connection conexion = null;
    private final String url = "jdbc:mysql://localhost:3306/empleos";
    private final String usuario = "root";
    private final String contrasena = "ASV30885";

    public ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conectado a la base de datos");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public  ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la Conexion");
            }
        }
    }
    
}
