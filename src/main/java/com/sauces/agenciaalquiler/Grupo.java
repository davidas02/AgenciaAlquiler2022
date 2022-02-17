/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

/**
 *
 * @author daw1
 */
public enum Grupo {
    A(50,1.5F,5),B(55,2,10),C(60,2.5f,15);
    private final int precioFijo;
    private final float precioTurismo;
    private final int precioFurgoneta;

    private Grupo(int precioFijo, float precioTurismo, int precioFurgoneta) {
        this.precioFijo = precioFijo;
        this.precioTurismo = precioTurismo;
        this.precioFurgoneta = precioFurgoneta;
    }

    public int getPrecioFijo() {
        return precioFijo;
    }

    public float getPrecioTurismo() {
        return precioTurismo;
    }

    public int getPrecioFurgoneta() {
        return precioFurgoneta;
    }
    
}
