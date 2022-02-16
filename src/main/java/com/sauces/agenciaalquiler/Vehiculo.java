/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.util.Objects;

/**
 * Clase abstracta que sirve como clase envoltorio para las clases Furgoneta y Turismo
 * @author David Aparicio Sir
 */
public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String matricula;
    private Grupo grupo;

    public Vehiculo(String matricula, Grupo grupo) {
        this.matricula = matricula;
        this.grupo = grupo;
    }

    public Vehiculo() {
    }
    /**
     * Metodo que devuelve la matricula del vehiculo
     * @return matricula del vehiculo
     */
    public String getMatricula() {
        return matricula;
    }
    /**
     * Metodo que establece la Matricula de un vehiculo
     * @param matricula Matricula del vehiculo
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    /**
     * Metodo que devuelve el grupo del vehiculo
     * @return el grupo del vehiculo
     */
    public Grupo getGrupo() {
        return grupo;
    }
    /**
     * Metodo que establece el grupo del vehiculo
     * @param grupo grupo del vehiculo
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    /**
     *  Metodo que convierte el vehiculo a cadena
     * @return Cadena con la matricula y el grupo del vehiculo
     */
    @Override
    public String toString() {
        return matricula + "," + grupo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Vehiculo) {
            final Vehiculo other = (Vehiculo) obj;
            if (Objects.equals(this.matricula, other.matricula)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metodo abstracto que devuelve el precio del alquiler del vehiculo por un dia
     * @return  devuelve el precio del alquiler del vehiculo por un dia
     */
    public abstract float getPrecioAlquiler();
    /**
     * Metodo que devuelve el precio del alquiler del vehiculo por los dias del mismo
     * @param dias dias de duracion del alquiler
     * @return devuelve el precio del alquiler del vehiculo por los dias del mismo
     */
    public float getPrecioAlquiler(int dias){
        return getPrecioAlquiler()*dias;
    }
    /**
     * Metodo que compara las matriculas del vehiculo actual con las del vehiculo introducido
     * @param o vehiculo introducido
     * @return 0 si las matriculas son iguales 1 si la matricula del vehiculo actual es mayor 
     * y -1 si la matricula del vehiculo actual es menor
     */
    @Override
    public int compareTo(Vehiculo o) {
        return this.matricula.compareTo(o.matricula);
    }
}
