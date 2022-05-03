/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.modelo;

import java.util.Comparator;

/**
 * Clase comparadora de precio de alquiler
 * @author David Aparicio Sir
 */
public class ComparadorPrecio implements Comparator<Vehiculo>{
/**
 * 
 * @param o1 vehiculo comparado
 * @param o2 vehiculo a comparar
 * @return 0 si son iguales 1 si o1 es mayor que o2 y -1 si o2 es mayor que o1
 */
    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
        int salida=0;
        float p1=o1.getPrecioAlquiler();
        float p2=o2.getPrecioAlquiler();
        if (p1 > p2) {
            salida = 1;
        } else {
            if (p1 < p2) {
                salida = -1;
            }
        }
        return salida;
    }
    
}
