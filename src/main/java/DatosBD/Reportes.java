/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Modelos.Coneccion;
import Modelos.Reportes.ComputadoraReporte;
import Modelos.Reportes.DetalleVenta_Reporte;
import Modelos.Reportes.Venta_Reporte;
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
public class Reportes {

    public List<Venta_Reporte> getReporteVEntas(String fechaInicio, String fechaFinal) {

        Connection connection = Coneccion.getConnection();

        List<Venta_Reporte> Ventas = new ArrayList<>();

        String queryVentas = "SELECT v.id_venta, v.id_cliente, c.nombre AS nombre_cliente, v.fecha_venta, v.total_venta FROM Venta v JOIN Cliente c ON v.id_cliente = c.id_cliente WHERE v.fecha_venta BETWEEN ? AND ? ORDER BY v.fecha_venta;";

        //encontrar todas las ventas en las fechas indicadas
        try {
            //      System.out.println(SelectTodoUsuario);
            PreparedStatement select = connection.prepareStatement(queryVentas);
            select.setString(1, fechaInicio);
            select.setString(2, fechaFinal);
            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                Ventas.add(new Venta_Reporte(resultset.getInt("id_venta"), resultset.getInt("id_cliente"),
                        resultset.getString("nombre_cliente"), resultset.getString("fecha_venta"), resultset.getFloat("total_venta"), null
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }

        //encontrar los detalles de la venta
        for (Venta_Reporte venta : Ventas) {

            String queryDetalle = "SELECT dv.id_detalle, dv.id_venta,dv.id_ensamblado, compu.nombre AS nombre_computadora, compu.precio_venta AS precio_unitario, dv.cantidad FROM Detalle_Venta dv JOIN Computadora_Ensamblada ce ON dv.id_ensamblado = ce.id_ensamblado JOIN Computadora compu ON ce.id_computadora = compu.id_computadora WHERE dv.id_venta = " + venta.getId();

            List<DetalleVenta_Reporte> detalle = new ArrayList<>();

            try {
                //      System.out.println(SelectTodoUsuario);
                PreparedStatement select = connection.prepareStatement(queryDetalle);
            
                ResultSet resultset = select.executeQuery();
                while (resultset.next()) {
                    detalle.add(new DetalleVenta_Reporte(resultset.getInt("id_ensamblado") ,
                            resultset.getInt("id_usuario"),"", resultset.getString("nombre_computadora"), resultset.getFloat("precio_unitario")
                    ));
                }

            } catch (SQLException ex) {
                // TODO pendiente manejo
                ex.printStackTrace();

                System.out.println(ex);
            }
            
            //setear el detalle de la venta al objeto Venta 
            
            venta.setDetalleVenta(new ArrayList<>(detalle));

        }

        return Ventas;
    }
    
    
    
    public List<ComputadoraReporte> getComputadoraMasVendida(String fechaInicial, String fechaFinal){
          Connection connection = Coneccion.getConnection();

        List<ComputadoraReporte> computadora = new ArrayList<>();

        String queryVentas = "WITH ComputadoraMasVendida AS (\n"
                + "    SELECT \n"
                + "        ce.id_computadora,\n"
                + "        c.nombre AS nombre_computadora,\n"
                + "        SUM(dv.cantidad) AS total_vendida\n"
                + "    FROM Detalle_Venta dv\n"
                + "    JOIN Computadora_Ensamblada ce ON dv.id_ensamblado = ce.id_ensamblado\n"
                + "    JOIN Computadora c ON ce.id_computadora = c.id_computadora\n"
                + "    JOIN Venta v ON dv.id_venta = v.id_venta\n"
                + "    WHERE v.fecha_venta BETWEEN ? AND ?\n"
                + "    GROUP BY ce.id_computadora, c.nombre\n"
                + "    ORDER BY total_vendida DESC\n"
                + "    LIMIT 1\n"
                + ")\n"
                + "SELECT \n"
                + "    dv.id_detalle, \n"
                + "    v.id_venta, \n"
                + "    v.fecha_venta, \n"
                + "    cli.nombre AS nombre_cliente, \n"
                + "    c.nombre AS nombre_computadora, \n"
                + "    c.precio_venta AS precio_unitario, \n"
                + "    dv.cantidad\n"
                + "FROM Detalle_Venta dv\n"
                + "JOIN Computadora_Ensamblada ce ON dv.id_ensamblado = ce.id_ensamblado\n"
                + "JOIN Computadora c ON ce.id_computadora = c.id_computadora\n"
                + "JOIN Venta v ON dv.id_venta = v.id_venta\n"
                + "JOIN Cliente cli ON v.id_cliente = cli.id_cliente\n"
                + "WHERE c.id_computadora = (SELECT id_computadora FROM ComputadoraMasVendida)\n"
                + "AND v.fecha_venta BETWEEN ? AND ?\n"
                + "ORDER BY v.fecha_venta;";
        //encontrar todas las ventas en las fechas indicadas
        try {
            //      System.out.println(SelectTodoUsuario);
            PreparedStatement select = connection.prepareStatement(queryVentas);
            select.setString(1, fechaInicial);
            select.setString(2, fechaFinal);
            select.setString(3, fechaInicial);
            select.setString(4, fechaFinal);
            
            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                computadora.add(new ComputadoraReporte(resultset.getInt("id_detalle"), resultset.getInt("id_venta"),
                        resultset.getString("fecha_venta"), resultset.getString("nombre_cliente"), resultset.getString("nombre_computadora"),resultset.getFloat("total_venta"), resultset.getInt("cantidad")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        
        
        return computadora;
    }
    
    public List<ComputadoraReporte> getComputadoraMenosVendida(String fechaInicial, String fechaFinal){
          Connection connection = Coneccion.getConnection();

        List<ComputadoraReporte> computadora = new ArrayList<>();

        String queryVentas = "WITH ComputadoraMenosVendida AS (\n"
                + "    SELECT \n"
                + "        ce.id_computadora,\n"
                + "        c.nombre AS nombre_computadora,\n"
                + "        SUM(dv.cantidad) AS total_vendida\n"
                + "    FROM Detalle_Venta dv\n"
                + "    JOIN Computadora_Ensamblada ce ON dv.id_ensamblado = ce.id_ensamblado\n"
                + "    JOIN Computadora c ON ce.id_computadora = c.id_computadora\n"
                + "    JOIN Venta v ON dv.id_venta = v.id_venta\n"
                + "    WHERE v.fecha_venta BETWEEN ? AND ?\n"
                + "    GROUP BY ce.id_computadora, c.nombre\n"
                + "    ORDER BY total_vendida ASC\n"
                + "    LIMIT 1\n"
                + ")\n"
                + "SELECT \n"
                + "    dv.id_detalle, \n"
                + "    v.id_venta, \n"
                + "    v.fecha_venta, \n"
                + "    cli.nombre AS nombre_cliente, \n"
                + "    c.nombre AS nombre_computadora, \n"
                + "    c.precio_venta AS precio_unitario, \n"
                + "    dv.cantidad\n"
                + "FROM Detalle_Venta dv\n"
                + "JOIN Computadora_Ensamblada ce ON dv.id_ensamblado = ce.id_ensamblado\n"
                + "JOIN Computadora c ON ce.id_computadora = c.id_computadora\n"
                + "JOIN Venta v ON dv.id_venta = v.id_venta\n"
                + "JOIN Cliente cli ON v.id_cliente = cli.id_cliente\n"
                + "WHERE c.id_computadora = (SELECT id_computadora FROM ComputadoraMenosVendida)\n"
                + "AND v.fecha_venta BETWEEN ? AND ?\n"
                + "ORDER BY v.fecha_venta;";
        //encontrar todas las ventas en las fechas indicadas
        try {
            //      System.out.println(SelectTodoUsuario);
            PreparedStatement select = connection.prepareStatement(queryVentas);
            select.setString(1, fechaInicial);
            select.setString(2, fechaFinal);
            select.setString(3, fechaInicial);
            select.setString(4, fechaFinal);
            
            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                computadora.add(new ComputadoraReporte(resultset.getInt("id_detalle"), resultset.getInt("id_venta"),
                        resultset.getString("fecha_venta"), resultset.getString("nombre_cliente"), resultset.getString("nombre_computadora"),resultset.getFloat("total_venta"), resultset.getInt("cantidad")
                ));
            }

        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();

            System.out.println(ex);
        }
        
        
        return computadora;
    }
    
    
    
    

  

}
