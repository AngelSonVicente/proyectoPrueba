/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelos.Componente;
import Service.ComponenteService;
import exceptions.InvalidDataException;
import jakarta.servlet.http.HttpServletResponse;


public class ComponenteController {

    public void crearComponete(Componente componente, HttpServletResponse response) throws InvalidDataException {

        ComponenteService componenteService = new ComponenteService();

        componente = componenteService.crearComponente(componente);

        //Mandar Al RESPONSE
    }

    public void getComponente(int codigo) throws InvalidDataException {

        ComponenteService componenteService = new ComponenteService();

        if (codigo == 0) {

            //esto devuelve una toda la lista de componentes
            componenteService.getComponentes();

        } else {
            //devuelve un solo componente 

            componenteService.getComponenteID(codigo);

        }

    }

}
