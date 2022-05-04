/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.controlador;

import com.sauces.agenciaalquiler.modelo.AgenciaAlquiler;
import com.sauces.agenciaalquiler.modelo.ComparadorPrecio;
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
import java.util.Collections;
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
        try {
            Matricula matricula = Matricula.valueOf(vista.getMatricula());
            Vehiculo v = agenciaAlquiler.consultarVehiculo(matricula);
            if (v == null) {
                vista.mostrarMensaje("El vehiculo con matricula " + matricula.toString() + " no existe");
            } else {
                if (agenciaAlquiler.eliminarVehiculo(v)) {
                    vista.mostrarMensaje("El vehiculo con matricula " + matricula.toString() + " ha sido eliminado");
                } else {

                    vista.mostrarMensaje("El vehiculo con matricula " + matricula.toString() + " no ha podido ser eliminado");
                }
                
            }
        } catch (MatriculaException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
        vista.limpiarCampos();
    }

    public void buscarVehiculo() {
        try {
            Matricula matricula = Matricula.valueOf(vista.getMatricula());
            Vehiculo v = agenciaAlquiler.consultarVehiculo(matricula);
            vista.mostrarGrupo(v.getGrupo().toString());
            vista.mostrarPrecioAlquiler(v.getPrecioAlquiler());
            if (v instanceof Turismo) {
                vista.mostrarPlazas(((Turismo) v).getPlazas());
            } else {
                vista.mostrarCapacidad(((Furgoneta) v).getCapacidad());
            }
        } catch (MatriculaException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void modificarVehiculo() {
        try {
            Vehiculo v=agenciaAlquiler.consultarVehiculo(Matricula.valueOf(vista.getMatricula()));
            if(v instanceof Turismo){
                ((Turismo) v).setPlazas(vista.getPlazas());
            }else{
                ((Furgoneta)v).setCapacidad(vista.getCapacidad());
            }
               vista.mostrarPrecioAlquiler(v.getPrecioAlquiler());
        } catch (MatriculaException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void listarVehiculos() {
        String grupo = vista.getFiltroGrupo();
        List<Vehiculo> listado = null;
        List<Vehiculo> listado2 = null;
        if (!grupo.equals("TODOS")) {
            listado = agenciaAlquiler.listarVehiculos(Grupo.valueOf(grupo));
        } else {
            listado = new ArrayList<>(agenciaAlquiler.getFlota().values());
        }
        String tipo = vista.getFiltroTipo();
        switch (tipo) {
            case "TODOS":
                listado2=new ArrayList<>(listado);
                break;
            case "TURISMOS":
                listado2=new ArrayList<>();
                for (Vehiculo v : listado) {
                    if (v instanceof Turismo) {
                       listado2.add(v);
                    }
                }
                break;
            case "FURGONETAS":
                listado2=new ArrayList<>();
                for (Vehiculo v : listado) {
                    if (v instanceof Furgoneta) {
                        listado2.add(v);
                    }
                }
                break;
        }
        switch(vista.getOrden()){
            case "ALQUILER":
                listado2.sort(new ComparadorPrecio());
                break;
        }
        if (listado2 != null) {
            vista.listarVehiculos(listado2);
        }

    }

    public void guardarVehiculos() {
        agenciaAlquiler.setVehiculoDao(getDao(vista.getArchivo()));
        try {
            vista.mostrarMensaje("Se han guardado " + agenciaAlquiler.guardarVehiculos() + " vehiculos");
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void cargarVehiculos() {
        agenciaAlquiler.setVehiculoDao(getDao(vista.getArchivo()));
        try {
            vista.mostrarMensaje("Se han cargado " + agenciaAlquiler.cargarVehiculos() + " vehiculos");
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    public void buscarVehiculoMasBarato() {
        Vehiculo v = agenciaAlquiler.getVehiculoMasBarato();
        if (v != null) {
            vista.mostrarMatricula(v.getMatricula().toString());
            vista.mostrarGrupo(v.getGrupo().toString());
            String tipo = v.getClass().getSimpleName().toUpperCase();
            vista.mostrarTipo(tipo);
            if (v instanceof Turismo) {
                vista.mostrarPlazas(((Turismo) v).getPlazas());
            } else {
                vista.mostrarCapacidad(((Furgoneta) v).getCapacidad());
            }
            vista.mostrarPrecioAlquiler(v.getPrecioAlquiler());
        } else {
            vista.mostrarMensaje("Ha habido un error");
        }
    }

    public void buscarVehiculoMasCaro() {
        Vehiculo v = Collections.max(agenciaAlquiler.getFlota().values(), new ComparadorPrecio());
        if (v != null) {
            vista.mostrarMatricula(v.getMatricula().toString());
            vista.mostrarGrupo(v.getGrupo().toString());
            String tipo = v.getClass().getSimpleName().toUpperCase();
            vista.mostrarTipo(tipo);
            if (v instanceof Turismo) {
                vista.mostrarPlazas(((Turismo) v).getPlazas());
            } else {
                vista.mostrarCapacidad(((Furgoneta) v).getCapacidad());
            }
            vista.mostrarPrecioAlquiler(v.getPrecioAlquiler());
        } else {
            vista.mostrarMensaje("Ha habido un error");
        }
    }

    public void iniciar() {
        vista.mostrar();
    }

    private static VehiculoDao getDao(String fichero) {
        VehiculoDao vd = null;
        int posPunto = fichero.lastIndexOf(".") + 1;
        String extension = fichero.substring(posPunto);
        switch (extension) {
            case "csv":
                vd = new VehiculoDaoCsv(fichero);
                break;
            case "obj":
                vd = new VehiculoDaoObj(fichero);
                break;
            case "json":
                vd = new VehiculoDaoJson(fichero);
                break;
            case "xml":
                vd = new VehiculoDaoXml(fichero);
        }
        return vd;
    }
}
