/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.main;

import com.sauces.agenciaalquiler.controlador.Controlador;
import com.sauces.agenciaalquiler.modelo.AgenciaAlquiler;
import com.sauces.agenciaalquiler.vista.Ventana;

/**
 *
 * @author daw1
 */
public class AAVentana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana vista=new Ventana();
        AgenciaAlquiler modelo=new AgenciaAlquiler();
        Controlador controlador=new Controlador(vista, modelo);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
    
}
