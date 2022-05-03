/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.controlador;

import com.sauces.agenciaalquiler.modelo.AgenciaAlquiler;
import com.sauces.agenciaalquiler.vista.Ventana;

/**
 *
 * @author daw1
 */
public class Controlador {
    private Ventana vista;
    private AgenciaAlquiler modelo;
    public Controlador(Ventana vista, AgenciaAlquiler modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void iniciar(){
        vista.mostrar();
    }
}
