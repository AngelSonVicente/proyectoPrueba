/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DatosBD.ComponenteBD;
import DatosBD.ConexionBD;
import Modelos.Componente;
import exceptions.InvalidDataException;
import java.sql.Connection;
import java.util.List;

public class ComponenteService {

    private Connection conexion;
    private ComponenteBD componenteBD;

    public ComponenteService() {
        ConexionBD conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
        componenteBD = new ComponenteBD(conexion);

    }

    public ComponenteService(Connection conexion) {
        this.conexion = conexion;
        componenteBD = new ComponenteBD();
    }

    public Componente crearComponente(Componente componente) throws InvalidDataException {

        validar(componente);

        return componenteBD.crearComponente(componente);

    }
    
    public List<Componente> getComponentes(){
    
    return componenteBD.getComponentes();
    }
    public Componente getComponenteID(int codigo) throws InvalidDataException {

        if(codigo<=0){
            throw new InvalidDataException("el codigo no existe");
        }
        return componenteBD.getComponenteID(codigo);
    }
    
    
    

    public void validar(Componente componente) throws InvalidDataException {
        if (componente.getNombre() == null || componente.getCosto() <= 0.0 || componente.getCantidadStock() <= 0) {

            throw new InvalidDataException("Faltan datos o datos incorrectos");

        }

    }
}
