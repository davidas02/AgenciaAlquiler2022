/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoDaoCsv implements VehiculoDao{
    private Path path;
    public VehiculoDaoCsv(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = Paths.get(path);
    }
    
    @Override
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listado=new ArrayList<>();
        String linea;
        String[] tokens;
        String tipo;
        String grupo;
        String matricula;
        int plazas;
        float capacidad;
        Vehiculo vehiculo=null;
        try(BufferedReader entrada=Files.newBufferedReader(path)){
            linea=entrada.readLine();
            while(linea!=null){
                tokens=linea.split(",");
                tipo=tokens[0];
                matricula=tokens[1];
                grupo=tokens[2];
                switch(tipo){
                    case "Turismo":
                        plazas=Integer.parseInt(tokens[3]);
                        vehiculo=new Turismo(Matricula.valueOf(matricula),Grupo.valueOf(grupo), plazas);
                     break;
                    case "Furgoneta":
                        capacidad=Float.parseFloat(tokens[3]);
                        vehiculo=new Furgoneta(Matricula.valueOf(matricula), Grupo.valueOf(grupo), capacidad);
                       break;
            }
                listado.add(vehiculo);
                linea=entrada.readLine();
            }
        }catch(MatriculaException | IOException me){
            throw new DaoException(me.getMessage());
        } catch(Exception ex){
        throw new DaoException("Error de formato");
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
int n=0;
        String linea;
        try(BufferedWriter salida=Files.newBufferedWriter(path)){
            for(Vehiculo v:vehiculos){
                linea=v.getClass().getSimpleName()+","+v.toString();
                salida.write(linea);
                salida.newLine();
                n++;
            }
        }catch(IOException ex){
            throw new DaoException(ex.toString());
        }  
        return n;
}
    
}
