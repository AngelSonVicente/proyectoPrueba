/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Reportes;

/**
 *
 * @author angel
 */
public class ComputadoraReporte {
    
    private int idDetalle;
    private  int idVenta;
    private String fechaVenta;
    private String nombreCliente;
    private String nombreComputadora;
    private float precioUnitario;
    private int cantidad;

    public ComputadoraReporte() {
    }

    public ComputadoraReporte(int idDetalle, int idVenta, String fechaVenta, String nombreCliente, String nombreComputadora, float precioUnitario, int cantidad) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.nombreCliente = nombreCliente;
        this.nombreComputadora = nombreComputadora;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreComputadora() {
        return nombreComputadora;
    }

    public void setNombreComputadora(String nombreComputadora) {
        this.nombreComputadora = nombreComputadora;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
          
}
