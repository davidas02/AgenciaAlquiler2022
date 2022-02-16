/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

/**
 * Clase Furgoneta que desciende de la clase Vehiculo
 * @author David Aparicio Sir
 */
public class Furgoneta extends Vehiculo {

    private float capacidad;

    public Furgoneta() {
    }

    public Furgoneta(String matricula, Grupo grupo, float capacidad) {
        super(matricula, grupo);
        this.capacidad = capacidad;
    }
    /**
     * Metodo que devuelve la capacidad de la Furgoneta
     * @return devuelve la capacidad de la Furgoneta
     */
    public float getCapacidad() {
        return capacidad;
    }
    /**
     * Metodo que establece la capacidad de la furgoneta
     * @param capacidad nueva capacidad de la furgoneta
     */
    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }
    /**
     * Metodo que devuelve el Vehiculo de la clase Furgoneta(matricula,grupo,capacidad)
     * @return Devuelve el Vehiculo de la clase Furgoneta(matricula,grupo,capacidad)
     */
    @Override
    public String toString() {
        return super.toString() + "," + capacidad;
    }
    /**
     * Metodo que devuelve el precio del alquiler por un dia del vehiculo
     * @return devuelve el precio dependiendo de la clase. Si es de clase A el precio es 50+(5*capacidad), si es de clase B el precio es 55+(10*capacidad) y si es de la clase C el precio será de 60+(15*capacidad)
     */
    @Override
    public float getPrecioAlquiler() {
        Grupo g = getGrupo();
        float precio = 0;
        switch (g) {
            case A:
                precio = 50 + 5 * capacidad;
                break;
            case B:
                precio = 55 + 10 * capacidad;
                break;
            case C:
                precio = 60 + 15 * capacidad;
                break;
        }
        return precio;
    }

}
