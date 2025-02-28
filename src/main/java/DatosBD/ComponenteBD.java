/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Modelos.Componente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class ComponenteBD {

    private Connection conexion;

    private static final String CREAR = "INSERT INTO Componente ( nombre, costo, cantidad_stock) VALUES (?,?,?);";

    private static final String GET_COMPONENTES = "SELECT * FROM Componente;";
    private static final String GET_COMPONENTE = "SELECT * FROM Componente WHERE id_componente = 1;";

    public ComponenteBD(Connection conexion) {
        this.conexion = conexion;
    }

    public ComponenteBD() {
        ConexionBD conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();

    }

    public Componente crearComponente(Componente componente) {

        try {
            PreparedStatement insert = conexion.prepareStatement(CREAR, PreparedStatement.RETURN_GENERATED_KEYS);
            insert.setString(1, componente.getNombre());
            insert.setDouble(2, componente.getCosto());
            insert.setInt(3, componente.getCantidadStock());

            System.out.println(insert.toString());
            int affectedRows = insert.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La inserción no tuvo éxito, ningún ID generado.");
            }

            try (ResultSet generatedKeys = insert.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    System.out.println("COmponente Creado");
                    componente.setIdComponente(generatedID);
                    return componente;
                } else {
                    throw new SQLException("La inserción no tuvo éxito, ningún ID generado.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<Componente> getComponentes() {
        List<Componente> componentes = new ArrayList<>();
        try {
            PreparedStatement select = conexion.prepareStatement(GET_COMPONENTES);

            System.out.println("queryy_ " + select.toString());
            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                componentes.add(new Componente(resultset.getInt("id_componente"), resultset.getString("nombre"), resultset.getFloat("costo"),
                        resultset.getInt("cantidad_stock")
                ));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error:  " + ex);
        }

        return componentes;
    }

    public Componente getComponenteID(int codigo) {
        try {
            PreparedStatement select = conexion.prepareStatement(GET_COMPONENTE);
            select.setInt(1, codigo);
            ResultSet resultset = select.executeQuery();

            if (resultset.next()) {
                return new Componente(resultset.getInt("id_componente"), resultset.getString("nombre"),
                        resultset.getDouble("costo"), resultset.getInt("cantidad_stock")
                );
            }
        } catch (SQLException ex) {

            ex.printStackTrace();

            System.out.println(ex);
        }

        return null;
    }
}
