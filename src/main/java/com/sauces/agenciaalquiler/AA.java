/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author David Aparicio Sir
 */
public class AA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        AgenciaAlquiler aa = new AgenciaAlquiler();
        int opcion, opcion2, plazas;
        String mat, gru;
        Grupo grupo = null;
        float capacidad;
        boolean correcto;
        Matricula matricula = null;
        do {
            System.out.println("1.-Crear Vehiculo");
            System.out.println("2.-Consultar Vehiculo");
            System.out.println("3.-Eliminar Vehiculo");
            System.out.println("4.-Listar Vehiculos");
            System.out.println("5.-Consultar alquiler mas barato");
            System.out.println("0.-Salir");
            System.out.println("Elige una Opcion");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("1.-Crear Turismo");
                        System.out.println("2.-Crear Furgoneta");
                        System.out.println("0.-Cerrar");
                        opcion2 = teclado.nextInt();
                        teclado.nextLine();
                        switch (opcion2) {
                            case 1:
                                System.out.println("Crear Turismo");
                                System.out.println("Introduce Matricula del vehiculo");
                                do {
                                    correcto = true;
                                    try {
                                        mat = teclado.nextLine();
                                        matricula = Matricula.valueOf(mat);
                                    } catch (MatriculaException ex) {
                                        System.out.println(ex.getMessage());
                                        System.out.println("Error. Introduce Matricula del vehiculo");
                                        correcto = false;
                                    }
                                } while (!correcto);
                                do {
                                    correcto = true;
                                    try {
                                        System.out.println("Introduce Grupo del vehiculo " + Arrays.toString(Grupo.values()));
                                        gru = teclado.nextLine();
                                        grupo = Grupo.valueOf(gru);

                                    } catch (IllegalArgumentException iae) {
                                        System.out.println("Introduce Grupo del vehiculo " + Arrays.toString(Grupo.values()));
                                        correcto = false;
                                    }
                                } while (!correcto);
                                System.out.println("Introduce Plazas del vehiculo");
                                plazas = teclado.nextInt();
                                teclado.nextLine();
                                if (aa.incluirVehiculo(new Turismo(matricula, grupo, plazas))) {
                                    System.out.println("Vehiculo incluido correctamente");
                                } else {
                                    System.out.println("El vehiculo no se ha podido incluir");
                                }
                                break;

                            case 2:
                                System.out.println("Crear Furgoneta");
                                System.out.println("Introduce Matricula del vehiculo");
                                do {
                                    correcto = true;
                                    try {
                                        mat = teclado.nextLine();
                                        matricula = Matricula.valueOf(mat);

                                    } catch (MatriculaException ex) {
                                        System.out.println(ex.getMessage());
                                        System.out.println("Error. Introduce Matricula del vehiculo");
                                        correcto = false;
                                    }
                                } while (!correcto);
                                do {
                                    correcto = true;
                                    try {
                                        System.out.println("Introduce Grupo del vehiculo " + Arrays.toString(Grupo.values()));
                                        gru = teclado.nextLine();
                                        grupo = Grupo.valueOf(gru);

                                    } catch (IllegalArgumentException iae) {
                                        System.out.println("Introduce Grupo del vehiculo " + Arrays.toString(Grupo.values()));
                                        correcto = false;
                                    }
                                } while (!correcto);
                                System.out.println("Introduce capacidad del Vehiculo");
                                capacidad = teclado.nextFloat();
                                teclado.nextLine();
                                if (aa.incluirVehiculo(new Furgoneta(matricula, grupo, capacidad))) {
                                    System.out.println("Vehiculo incluido correctamente");
                                } else {
                                    System.out.println("El vehiculo no se ha podido incluir");
                                }
                                break;
                            default:
                                System.out.println("Opcion Incorrecta");
                                break;
                        }
                    } while (opcion2 != 0);
                    break;
                case 2:
                    System.out.println("Introduce Matricula del vehiculo");
                    mat = teclado.nextLine();
                     {
                        try {
                            matricula = Matricula.valueOf(mat);
                        } catch (MatriculaException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    if (aa.consultarVehiculo(matricula) != null) {
                        System.out.println(aa.consultarVehiculo(matricula));
                    } else {
                        System.out.println("Vehiculo no existe");
                    }
                    break;

                case 3:

                    System.out.println("Introduce Matricula del vehiculo");
                    mat = teclado.nextLine();
                     {
                        try {
                            matricula = Matricula.valueOf(mat);
                        } catch (MatriculaException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    if (aa.consultarVehiculo(matricula) != null) {
                        aa.eliminarVehiculo(aa.consultarVehiculo(matricula));
                        System.out.println("Vehiculo eliminado correctamente");
                    } else {
                        System.out.println("El vehiculo no se ha podido eliminar");
                    }
                    break;

                case 4:
                    do {
                        System.out.println("1.-Listar por precio");
                        System.out.println("2.-Listar Turismos");
                        System.out.println("3.-Listar Furgonetas");
                        System.out.println("4.-Listar vehiculos por grupo");
                        System.out.println("0.-Cerrar");
                        opcion2 = teclado.nextInt();
                        teclado.nextLine();
                        switch (opcion2) {
                            case 1:
                                System.out.println(aa.listarVehiculosPorPrecio());
                                break;
                            case 2:
                                for (Vehiculo v : aa.listarVehiculosPorPrecio()) {
                                    if (v.getClass().equals(Turismo.class)) {
                                        System.out.println(v.toString());
                                    }
                                }
                                break;
                            case 3:
                                for (Vehiculo v : aa.listarVehiculosPorPrecio()) {
                                    if (v instanceof Furgoneta) {
                                        System.out.println(v.toString());
                                    }
                                }
                                break;
                            case 4:
                                correcto = false;
                                do {
                                    correcto = false;
                                    System.out.println("Introduce Grupo a buscar");
                                    gru = teclado.nextLine();
                                    grupo = Grupo.valueOf(gru);
                                    for (Grupo g : Grupo.values()) {
                                        if (grupo.equals(g)) {
                                            correcto = true;
                                        }
                                    }
                                } while (!correcto);
                                for (Vehiculo v : aa.listarVehiculos(grupo)) {
                                    System.out.println(v);
                                }
                                break;
                        }
                    } while (opcion2 != 0);
                    break;
                case 5:
                    Vehiculo vehiculo = aa.getVehiculoMasBarato();
                    System.out.println(vehiculo + " " + vehiculo.getPrecioAlquiler());
                    break;
                case 0:
                    System.out.println("ADIOS");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
        } while (opcion != 0);

    }

}
