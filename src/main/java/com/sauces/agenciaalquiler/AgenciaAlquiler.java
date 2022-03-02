/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *  Clase Agencia alquiler 
 * @author David Aparicio Sir
 */
public class AgenciaAlquiler {

    private String nombre;
    private Map<Matricula,Vehiculo> flota;

    public AgenciaAlquiler() {
        flota=new TreeMap<>();
    }
    /**
     * Metodo para obtener el nombre de la agencia alquiler
     * @return nombre de la AgenciaAlquiler
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre de la AgenciaAlquiler
     * @param nombre nombre de la AgenciaAlquiler
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     *  Metodo para obtener la flota de la agencia
     * @return Lista de los vehiculos
     */
    public Map<Matricula,Vehiculo> getFlota() {
        return flota;
    }
    /**
     *  Establece la lista de la flota de la AgenciaAlquiler
     * @param flota Lista de los vehiculos
     */
    public void setFlota(Map<Matricula,Vehiculo> flota) {
        this.flota = flota;
    }
    /**
     *  Metodo para introducir el vehiculo en la lista de vehiculos
     * @param vehiculo Vehiculo a inluir
     * @return true si el vehiculo se introduce y false si el vehiculo no se introduce en la lista
     */
    public boolean incluirVehiculo(Vehiculo vehiculo) {
        boolean incluido=false;
        if(flota.putIfAbsent(vehiculo.getMatricula(),vehiculo)==null){
            incluido=true;
        }
        return incluido;
    }
    /**
     *  Metodo de busqueda de un vehiculo en la agencia
     * @param matricula matricula del vehiculo a buscar
     * @return Devuelve el vehiculo que hemos buscado por matricula o null si no se encuentra
     */
    public Vehiculo consultarVehiculo(Matricula matricula) {
       if(flota.containsKey(matricula)){
           return flota.get(matricula);
       }
       return null;
    }
    /**
     * Metodo que elimina un vehiculo
     * @param vehiculo vehiculo a eliminar
     * @return true si se elimina correctamente y false si no se puede eliminar
     */
    public boolean eliminarVehiculo(Vehiculo vehiculo){
       if(vehiculo!=null){
        return flota.remove(vehiculo.getMatricula(),vehiculo);
       }
       return false;
    }
    /**
     * Metodo que lista los vehiculos por precio
     * @return lista de los vehiculos ordenados por precio
     */
    public List<Vehiculo> listarVehiculosPorPrecio(){
        List<Vehiculo> salida=new  ArrayList<>(flota.values());
        Collections.sort(salida,new ComparadorPrecio());
        return salida;
    }
    /**
     * Metodo que devuelve una lista de vehiculos del grupo elegido
     * @param grupo grupo del cual queremos buscar los vehiculos que lo componen
     * @return Lista de vehiculos del grupo escogido
     */
    public List<Vehiculo> listarVehiculos(Grupo grupo){
        List<Vehiculo> salida=new ArrayList<>();
        for(Vehiculo v:flota.values()){
            if(v.getGrupo().equals(grupo)){
                salida.add(v);
            }
        }
        return salida;
    }
    /**
     * Metodo que devuelve el vehiculo mas barato de la flota
     * @return vehiculo con el precio de alquiler mas bajo de la flota
     */
    public Vehiculo getVehiculoMasBarato(){
        return Collections.min(flota.values(),new ComparadorPrecio());
    }
}
