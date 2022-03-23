/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daw1
 */
public class Matricula implements Comparable<Matricula>,Serializable{
    private String valor;

    public Matricula() {
    }

    public Matricula(String valor) throws MatriculaException {
        if(!esValido(valor)){
            throw new MatriculaException("Formato Incorrecto de la Matricula");
        }
        this.valor = valor;
    }
    

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) throws MatriculaException {
        if(!esValido(valor)){
            throw new MatriculaException("Formato Incorrecto de la Matricula");
        }
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.valor);
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
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }
    public boolean esValido(String matricula){
        String patron="([0-9]{4})([A-Z&&[^AEIOUÑQ]]{3})";
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(matricula);
        return m.matches();
    }
    @Override
    public int compareTo(Matricula o) {
       return this.valor.compareTo(o.valor);
    }
    public static Matricula valueOf(String matricula) throws MatriculaException{
        return new Matricula(matricula);
    }
    
}
