/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoDaoObj implements VehiculoDao{
   private Path path; 

    public VehiculoDaoObj(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
    /**
     * Metodo que devuelve una lista de vehiculos que se han añadido al sistema desde un fichero obj
     * @return Devuelve una lista de vehiculos que se han añadido al sistema desde un fichero obj
     * @throws DaoException 
     */
    @Override
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listado=new ArrayList<>();
        try(InputStream is=Files.newInputStream(path);
            ObjectInputStream entrada=new ObjectInputStream(is)){
            while(is.available()>0){
                listado.add((Vehiculo)entrada.readObject());
            }
        } catch (ClassNotFoundException | IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        return listado;    
    }
    /**
     *  Metodo que devuelve un listado de vehiculos 
     * @param listado listado de vehiculos
     * @return Devuelve el numero de vehiculos almacenados
     * @throws DaoException 
     */
    @Override
    public int insertar(List<Vehiculo> vehiculos) throws DaoException {
        try(ObjectOutputStream salida=new ObjectOutputStream(Files.newOutputStream(path))){
           for(Vehiculo v:vehiculos){
               salida.writeObject(v);
           }
        } catch (IOException ex) { 
       throw new DaoException(ex.getMessage());
       } 
        return vehiculos.size();
    }
    
   
}
