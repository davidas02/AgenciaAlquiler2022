/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.util.List;

/**
 *
 * @author daw1
 */
public interface VehiculoDao{
    public List<Vehiculo> listar() throws DaoException;
    public int insertar(List<Vehiculo> vehiculos) throws DaoException;
}
