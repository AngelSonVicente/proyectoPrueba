/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Reportes;

import java.util.List;

/**
 *
 * @author angel
 */
public class Venta_Reporte {
 
    private int id;
    private int codigoCliente;
    private String nombreCliente;
    private String fecha;
    private float costoTotal;
   
    
 
    private  List<DetalleVenta_Reporte> detalleVenta;    

    public Venta_Reporte() {
    }

    public Venta_Reporte(int id, int codigoCliente, String nombreCliente, String fecha, float costoTotal, List<DetalleVenta_Reporte> detalleVenta) {
        this.id = id;
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.costoTotal = costoTotal;
        this.detalleVenta = detalleVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public List<DetalleVenta_Reporte> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta_Reporte> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    
    
}
