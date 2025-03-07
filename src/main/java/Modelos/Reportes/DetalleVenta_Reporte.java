/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Reportes;

/**
 *
 * @author angel
 */
public class DetalleVenta_Reporte {
    
    private int idComputadora;
    private int idUsuario;
    private String fechaEnsamble;
    private String nombreCOmputadora;
    private float costoUnitario;

    public DetalleVenta_Reporte() {
    }

    public DetalleVenta_Reporte(int idComputadora, int idUsuario, String fechaEnsamble, String nombreCOmputadora, float costoUnitario) {
        this.idComputadora = idComputadora;
        this.idUsuario = idUsuario;
        this.fechaEnsamble = fechaEnsamble;
        this.nombreCOmputadora = nombreCOmputadora;
        this.costoUnitario = costoUnitario;
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaEnsamble() {
        return fechaEnsamble;
    }

    public void setFechaEnsamble(String fechaEnsamble) {
        this.fechaEnsamble = fechaEnsamble;
    }

    public String getNombreCOmputadora() {
        return nombreCOmputadora;
    }

    public void setNombreCOmputadora(String nombreCOmputadora) {
        this.nombreCOmputadora = nombreCOmputadora;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    
    
    
    
    
}
