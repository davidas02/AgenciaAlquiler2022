/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.controlador;

import com.sauces.agenciaalquiler.modelo.AgenciaAlquiler;
import com.sauces.agenciaalquiler.modelo.DaoException;
import com.sauces.agenciaalquiler.modelo.Furgoneta;
import com.sauces.agenciaalquiler.modelo.Grupo;
import com.sauces.agenciaalquiler.modelo.Matricula;
import com.sauces.agenciaalquiler.modelo.MatriculaException;
import com.sauces.agenciaalquiler.modelo.Turismo;
import com.sauces.agenciaalquiler.modelo.Vehiculo;
import com.sauces.agenciaalquiler.modelo.VehiculoDao;
import com.sauces.agenciaalquiler.modelo.VehiculoDaoCsv;
import com.sauces.agenciaalquiler.modelo.VehiculoDaoJson;
import com.sauces.agenciaalquiler.modelo.VehiculoDaoObj;
import com.sauces.agenciaalquiler.modelo.VehiculoDaoXml;
import com.sauces.agenciaalquiler.vista.Ventana;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw1
 */
public class Controlador {

    private Ventana vista;
    private AgenciaAlquiler agenciaAlquiler;

    public Controlador(Ventana vista, AgenciaAlquiler modelo) {
        this.vista = vista;
        this.agenciaAlquiler = modelo;
    }

    public void crearVehiculo() {
        Vehiculo v = null;
        try {
            Matricula matricula = Matricula.valueOf(vista.getMatricula());
            Grupo grupo = Grupo.valueOf(vista.getGrupo());
            String tipo = vista.getTipo();
            switch (tipo) {
                case "TURISMO":
                    int plazas = vista.getPlazas();
                    v = new Turismo(matricula, grupo, plazas);
                    break;
                case "FURGONETA":
                    float capacidad = vista.getCapacidad();
                    v = new Furgoneta(matricula, grupo, capacidad);
                    break;
            }

            if (agenciaAlquiler.incluirVehiculo(v)) {
                vista.mostrarPrecioAlquiler(v.getPrecioAlquiler());
                vista.mostrarMensaje("Vehiculo incluido con exito");
            } else {
                vista.mostrarMensaje("No se ha podido incluir el vehiculo");
            }
        } catch (MatriculaException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void borrarVehiculo() {

    }

    public void buscarVehiculo() {
        try {
            Matricula matricula=Matricula.valueOf(vista.getMatricula());
            Vehiculo v=agenciaAlquiler.consultarVehiculo(matricula);
            vista.mostrarGrupo(v.getGrupo().toString());
            vista.mostrarPrecioAlquiler(v.getPrecioAlquiler());
            if(v instanceof Turismo){
                vista.mostrarPlazas(((Turismo) v).getPlazas());
            }else{
                vista.mostrarCapacidad(((Furgoneta)v).getCapacidad());
            }
        } catch (MatriculaException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void modificarVehiculo() {

    }

    public void listarVehiculos() {
        vista.listarVehiculos(agenciaAlquiler.listarVehiculosPorPrecio());
    }

    public void guardarVehiculos() {
        agenciaAlquiler.setVehiculoDao(getDao(vista.getArchivo()));
        try {
            vista.mostrarMensaje("Se han guardado "+agenciaAlquiler.guardarVehiculos()+" vehiculos");
        } catch (DaoException ex) {
           vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void cargarVehiculos() {
       agenciaAlquiler.setVehiculoDao(getDao(vista.getArchivo()));
        try {
            vista.mostrarMensaje("Se han cargado "+agenciaAlquiler.cargarVehiculos()+" vehiculos");
        } catch (DaoException ex) {
           vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void buscarVehiculoMasBarato() {
        Vehiculo v = agenciaAlquiler.getVehiculoMasBarato();
        vista.mostrarMatricula(v.getMatricula().toString());
        vista.mostrarGrupo(v.getGrupo().toString());
        String tipo=v.getClass().getSimpleName();
        vista.mostrarTipo(tipo);
        if(v instanceof Turismo){
            vista.mostrarPlazas(((Turismo) v).getPlazas());
        }else{
        vista.mostrarCapacidad(((Furgoneta)v).getCapacidad());
        }
        vista.mostrarPrecioAlquiler(v.getPrecioAlquiler());
    }

    public void buscarVehiculoMasCaro() {
        
    }

    public void iniciar() {
        vista.mostrar();
    }
     private static VehiculoDao getDao(String fichero){
        VehiculoDao vd=null;
        int posPunto=fichero.lastIndexOf(".")+1;
        String extension=fichero.substring(posPunto);
        switch(extension){
            case "csv":
                vd=new VehiculoDaoCsv(fichero);
            break;
            case "obj":
                vd=new VehiculoDaoObj(fichero);
            break;
            case "json":
                vd=new VehiculoDaoJson(fichero);
                break;
            case "xml":
                vd=new VehiculoDaoXml(fichero);
        }
        return vd;
    }
}
