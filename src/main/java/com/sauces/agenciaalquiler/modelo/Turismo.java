/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.modelo;

/**
 *  Clase Turismo que desciende de la clase Vehiculo
 * @author David Aparicio Sir
 */
public class Turismo extends Vehiculo{
    private int plazas;

    public Turismo(Matricula matricula, Grupo grupo,int plazas) {
        super(matricula, grupo);
        this.plazas = plazas;
    }

    public Turismo() {
    }
    /**
     * Metodo que devuelve el numero de plazas del vehiculo
     * @return Devuelve el numero de plazas del vehiculo
     */
    public int getPlazas() {
        return plazas;
    }
    /**
     * Metodo que establece las plazas del vehiculo
     * @param plazas Plazas que a partir de ahora tendrá el vehiculo
     */
    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    /**
     * Metodo que devuelve el Vehiculo de la clase Turismo(matricula,grupo,plazas)
     * @return Devuelve el Vehiculo de la clase Turismo(matricula,grupo,plazas)
     */
    @Override
    public String toString() {
        return super.toString()+","+ plazas ;
    }
    /**
     * Metodo que devuelve el precio del alquiler del vehiculo por un dia
     * @return Devuelve el precio del alquiler del vehiculo por un dia si el grupo es A el precio es 50+(plazas*1.5) si el grupo es B el precio es 55+(plazas*2) y si el grupo es C el precio es 60+(plazas*2.5) plazas son las plazas del vehiculo
     * 
     */
    @Override
    public float getPrecioAlquiler() {
        Grupo g=getGrupo();
        return g.getPrecioFijo()+g.getPrecioTurismo()*plazas;
    }
}
