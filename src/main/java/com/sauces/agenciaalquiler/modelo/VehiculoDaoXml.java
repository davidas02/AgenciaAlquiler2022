/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.modelo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoDaoXml implements VehiculoDao {

    private Path path;

    public VehiculoDaoXml(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
    /**
     * Metodo que devuelve una lista de vehiculos que se han añadido al sistema
     * @return Devuelve una lista de vehiculos que se han añadido al sistema
     * @throws DaoException 
     */
    @Override
    public List<Vehiculo> listar() throws DaoException {
        XStream xstream = new XStream(new DomDriver());
        //XStream.setupDefaultSecurity(xstream); Deprecated
        xstream.allowTypeHierarchy(Turismo.class);
        xstream.allowTypeHierarchy(Furgoneta.class);
        List<Vehiculo> listado;

        try (BufferedReader br = Files.newBufferedReader(path);) {
            listado = (List<Vehiculo>) xstream.fromXML(br);
        } catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        return listado;
    }
    /**
     * 
     * @param vehiculos listado de vehiculos
     * @return Devuelve el numero de vehiculos almacenados
     * @throws DaoException 
     */
    @Override
    public int insertar(List<Vehiculo> vehiculos) throws DaoException {
        XStream xstream = new XStream(new DomDriver());
        //XStream.setupDefaultSecurity(xstream); Deprecated 
        xstream.allowTypeHierarchy(Turismo.class);
        xstream.allowTypeHierarchy(Furgoneta.class);
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            xstream.toXML(vehiculos, bw);
        } catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        return vehiculos.size();
    }
}
