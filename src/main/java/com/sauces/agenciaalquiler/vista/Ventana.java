/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sauces.agenciaalquiler.vista;

import com.sauces.agenciaalquiler.controlador.Controlador;
import com.sauces.agenciaalquiler.modelo.Vehiculo;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author daw1
 */
public class Ventana extends javax.swing.JFrame {

    /** Creates new form Ventana */
    public Ventana() {
        initComponents();
    }
    private DialogoVehiculo dialogoVehiculo=new DialogoVehiculo(this, true);
    private Controlador controlador;
    private VehiculoTableModel vehiculoTM;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgListado = new javax.swing.ButtonGroup();
        selectorFicheros = new javax.swing.JFileChooser();
        panelVehiculo = new javax.swing.JPanel();
        lMatricula = new javax.swing.JLabel();
        tfMatricula = new javax.swing.JTextField();
        lGrupo = new javax.swing.JLabel();
        cbGrupo = new javax.swing.JComboBox<>();
        lTipo = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        lPlazas = new javax.swing.JLabel();
        spPlazas = new javax.swing.JSpinner();
        lPrecio = new javax.swing.JLabel();
        tfPrecio = new javax.swing.JFormattedTextField();
        bBorrar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        lCapacidad = new javax.swing.JLabel();
        tfCapacidad = new javax.swing.JFormattedTextField();
        panelListado = new javax.swing.JPanel();
        bListar = new javax.swing.JButton();
        panelTablaVehiculos = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        lOrdenListado = new javax.swing.JLabel();
        rbListarMatricula = new javax.swing.JRadioButton();
        rbListarAlquiler = new javax.swing.JRadioButton();
        lFiltroGrupo = new javax.swing.JLabel();
        cbFiltroGrupo = new javax.swing.JComboBox<>();
        lFiltrarTipo = new javax.swing.JLabel();
        cbFiltrarTipo = new javax.swing.JComboBox<>();
        panelOtras = new javax.swing.JPanel();
        bMasBarato = new javax.swing.JButton();
        bMasCaro = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        miAbrir = new javax.swing.JMenuItem();
        miGuardar = new javax.swing.JMenuItem();
        miVehiculo = new javax.swing.JMenu();
        miNuevoVehiculo = new javax.swing.JMenuItem();
        miBuscarVehiculo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelVehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Vehiculo"));

        lMatricula.setText("MATRÍCULA");

        tfMatricula.setEditable(false);

        lGrupo.setText("GRUPO");

        cbGrupo.setMaximumRowCount(3);
        cbGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));
        cbGrupo.setEnabled(false);

        lTipo.setText("TIPO");

        cbTipo.setMaximumRowCount(2);
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TURISMO", "FURGONETA" }));
        cbTipo.setEnabled(false);
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        lPlazas.setText("PLAZAS");

        lPrecio.setText("PRECIO POR DIA");

        tfPrecio.setEditable(false);

        bBorrar.setText("BORRAR");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        bModificar.setText("MODIFICAR");

        lCapacidad.setText("CAPACIDAD");

        javax.swing.GroupLayout panelVehiculoLayout = new javax.swing.GroupLayout(panelVehiculo);
        panelVehiculo.setLayout(panelVehiculoLayout);
        panelVehiculoLayout.setHorizontalGroup(
            panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addComponent(lGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addComponent(bBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bModificar))
                    .addGroup(panelVehiculoLayout.createSequentialGroup()
                        .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelVehiculoLayout.createSequentialGroup()
                                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lMatricula)
                                    .addComponent(lPlazas))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelVehiculoLayout.createSequentialGroup()
                                .addComponent(lPrecio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelVehiculoLayout.createSequentialGroup()
                                .addComponent(lCapacidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelVehiculoLayout.setVerticalGroup(
            panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMatricula)
                    .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lGrupo)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTipo)
                    .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPlazas)
                    .addComponent(spPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCapacidad)
                    .addComponent(tfCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPrecio)
                    .addComponent(tfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBorrar)
                    .addComponent(bModificar))
                .addContainerGap())
        );

        panelListado.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Vehiculos"));

        bListar.setText("LISTAR VEHÍCULOS");
        bListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bListarActionPerformed(evt);
            }
        });

        vehiculoTM=new VehiculoTableModel();
        tablaVehiculos.setModel(vehiculoTM);
        tablaVehiculos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent lse){
                int fila=tablaVehiculos.getSelectedRow();
                if(fila>=0){
                    mostrarMatricula((String) tablaVehiculos.getValueAt(fila,0));
                    mostrarGrupo((String)tablaVehiculos.getValueAt(fila,2));
                    String tipo=(String)tablaVehiculos.getValueAt(fila, 1);
                    if(tipo.equals("TURISMO")){
                        mostrarPlazas((int)tablaVehiculos.getValueAt(fila, 3));
                    }else{
                        mostrarCapacidad((float) tablaVehiculos.getValueAt(fila,4));
                    }
                    mostrarPrecioAlquiler((float)tablaVehiculos.getValueAt(fila,5));
                }
            }
        }

    );
    panelTablaVehiculos.setViewportView(tablaVehiculos);

    lOrdenListado.setText("ORDEN DEL LISTADO");

    bgListado.add(rbListarMatricula);
    rbListarMatricula.setSelected(true);
    rbListarMatricula.setText("MATRÍCULA");

    bgListado.add(rbListarAlquiler);
    rbListarAlquiler.setText("PRECIO ALQUILER");

    lFiltroGrupo.setText("FILTRAR POR GRUPO");

    cbFiltroGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "A", "B", "C" }));

    lFiltrarTipo.setText("FILTRAR POR TIPO");

    cbFiltrarTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "TURISMOS", "FURGONETAS" }));

    javax.swing.GroupLayout panelListadoLayout = new javax.swing.GroupLayout(panelListado);
    panelListado.setLayout(panelListadoLayout);
    panelListadoLayout.setHorizontalGroup(
        panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelListadoLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTablaVehiculos, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(panelListadoLayout.createSequentialGroup()
                    .addGroup(panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelListadoLayout.createSequentialGroup()
                            .addComponent(rbListarMatricula)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rbListarAlquiler))
                        .addGroup(panelListadoLayout.createSequentialGroup()
                            .addComponent(lOrdenListado)
                            .addGap(76, 76, 76)
                            .addComponent(lFiltroGrupo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbFiltroGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lFiltrarTipo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbFiltrarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 9, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListadoLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(bListar)
            .addGap(218, 218, 218))
    );
    panelListadoLayout.setVerticalGroup(
        panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelListadoLayout.createSequentialGroup()
            .addComponent(bListar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(panelTablaVehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lOrdenListado)
                .addComponent(lFiltroGrupo)
                .addComponent(cbFiltroGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lFiltrarTipo)
                .addComponent(cbFiltrarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(panelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rbListarMatricula)
                .addComponent(rbListarAlquiler))
            .addContainerGap())
    );

    panelOtras.setBorder(javax.swing.BorderFactory.createTitledBorder("Otras Operaciones"));

    bMasBarato.setText("MOSTRAR VEHÍCULO MÁS BARATO");
    bMasBarato.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bMasBaratoActionPerformed(evt);
        }
    });

    bMasCaro.setText("MOSTRAR VEHÍCULO MÁS CARO");
    bMasCaro.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bMasCaroActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelOtrasLayout = new javax.swing.GroupLayout(panelOtras);
    panelOtras.setLayout(panelOtrasLayout);
    panelOtrasLayout.setHorizontalGroup(
        panelOtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelOtrasLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelOtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bMasBarato, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addComponent(bMasCaro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    panelOtrasLayout.setVerticalGroup(
        panelOtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelOtrasLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(bMasBarato)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(bMasCaro)
            .addContainerGap(101, Short.MAX_VALUE))
    );

    menuArchivo.setText("Archivo");

    miAbrir.setText("Abrir");
    miAbrir.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            miAbrirActionPerformed(evt);
        }
    });
    menuArchivo.add(miAbrir);

    miGuardar.setText("Guardar");
    miGuardar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            miGuardarActionPerformed(evt);
        }
    });
    menuArchivo.add(miGuardar);

    menu.add(menuArchivo);

    miVehiculo.setText("Vehiculo");

    miNuevoVehiculo.setText("Nuevo");
    miNuevoVehiculo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            miNuevoVehiculoActionPerformed(evt);
        }
    });
    miVehiculo.add(miNuevoVehiculo);

    miBuscarVehiculo.setText("Buscar");
    miBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            miBuscarVehiculoActionPerformed(evt);
        }
    });
    miVehiculo.add(miBuscarVehiculo);

    menu.add(miVehiculo);

    setJMenuBar(menu);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(panelOtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(panelListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(panelListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(panelOtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(24, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarVehiculoActionPerformed
        // TODO add your handling code here:
        mostrarMatricula(JOptionPane.showInputDialog("Introduce la maricula del vehículo a buscar"));
        controlador.buscarVehiculo();
    }//GEN-LAST:event_miBuscarVehiculoActionPerformed

    private void miNuevoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevoVehiculoActionPerformed
        // TODO add your handling code here:
        dialogoVehiculo.limpiarCampos();
        if(dialogoVehiculo.mostrar()==DialogoVehiculo.ACEPTAR){
            mostrarMatricula(dialogoVehiculo.getMatricula());
            mostrarGrupo(dialogoVehiculo.getGrupo());
            String tipo=dialogoVehiculo.getTipo();
            mostrarTipo(tipo);
            if(tipo.equals("TURISMO")){
                mostrarPlazas(dialogoVehiculo.getPlazas());
            }else{
                mostrarCapacidad(dialogoVehiculo.getCapacidad());
            }
            controlador.crearVehiculo();
        }
    }//GEN-LAST:event_miNuevoVehiculoActionPerformed

    private void bListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bListarActionPerformed
        controlador.listarVehiculos();
    }//GEN-LAST:event_bListarActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
       if(cbTipo.getSelectedItem().equals("TURISMO")){
            lCapacidad.setVisible(false);
            tfCapacidad.setVisible(false);
            lPlazas.setVisible(true);
            spPlazas.setVisible(true);
        }else{
        lCapacidad.setVisible(true);
            tfCapacidad.setVisible(true);
            lPlazas.setVisible(false);
            spPlazas.setVisible(false);
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void miAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbrirActionPerformed
        // TODO add your handling code here:
        if(selectorFicheros.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
         controlador.cargarVehiculos();
        }
    }//GEN-LAST:event_miAbrirActionPerformed

    private void miGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarActionPerformed
        // TODO add your handling code here:
        if(selectorFicheros.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            controlador.guardarVehiculos();
        }
    }//GEN-LAST:event_miGuardarActionPerformed

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        // TODO add your handling code here:
        if(solicitarConfirmacion()){}
    }//GEN-LAST:event_bBorrarActionPerformed

    private void bMasBaratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasBaratoActionPerformed
        // TODO add your handling code here:
        controlador.buscarVehiculoMasBarato();
    }//GEN-LAST:event_bMasBaratoActionPerformed

    private void bMasCaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasCaroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bMasCaroActionPerformed
    
    public String getMatricula(){
        return tfMatricula.getText();
    }
    public String getGrupo(){
        return cbGrupo.getSelectedItem().toString();
    }
    public String getTipo(){
        return cbTipo.getSelectedItem().toString();
    }
    public int getPlazas(){
        return (int)spPlazas.getValue();
    }
    public float getCapacidad(){
       return Float.parseFloat(this.tfCapacidad.getText().replace(',','.'));
    }
    public String getArchivo(){
        return selectorFicheros.getSelectedFile().getAbsolutePath();
    }
    public String getOrden(){
        if(rbListarMatricula.isSelected()){
            return "MATRICULA";
        }else{
            return "ALQUILER";
        }
    }
    public String getFiltroGrupo(){
        return cbFiltroGrupo.getSelectedItem().toString();
    }
    public String getFiltroTipo(){
        return cbFiltrarTipo.getSelectedItem().toString();
    }
    public void mostrarMatricula(String matricula){
        tfMatricula.setText(matricula);
    }
    public void mostrarTipo(String tipo){
        cbTipo.setSelectedItem(tipo);
    }
    public void mostrarGrupo(String grupo){
        cbGrupo.setSelectedItem(grupo);
    }
    public void mostrarPlazas(int plazas){
        spPlazas.setValue(plazas);
    }
    public void mostrarCapacidad(float capacidad){
        tfCapacidad.setValue(capacidad);
    }
    public void mostrarPrecioAlquiler(float precio){
        tfPrecio.setValue(precio);
    }
    public void listarVehiculos(List<Vehiculo> listado){
        vehiculoTM.setListadoVehiculos(listado);
        vehiculoTM.fireTableDataChanged();
    }
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
    public boolean solicitarConfirmacion(){
        if(JOptionPane.showConfirmDialog(this, bMasCaro,"",JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }
    }
    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }
    public void limpiarCampos(){
        tfMatricula.setText("");
        cbGrupo.setSelectedIndex(0);
        spPlazas.setValue(0);
        cbTipo.setSelectedItem("TURISMO");
        tfCapacidad.setValue(0);
    }
    public void mostrar(){
        setVisible(true);
    }
    public void actualizarTabla(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bListar;
    private javax.swing.JButton bMasBarato;
    private javax.swing.JButton bMasCaro;
    private javax.swing.JButton bModificar;
    private javax.swing.ButtonGroup bgListado;
    private javax.swing.JComboBox<String> cbFiltrarTipo;
    private javax.swing.JComboBox<String> cbFiltroGrupo;
    private javax.swing.JComboBox<String> cbGrupo;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel lCapacidad;
    private javax.swing.JLabel lFiltrarTipo;
    private javax.swing.JLabel lFiltroGrupo;
    private javax.swing.JLabel lGrupo;
    private javax.swing.JLabel lMatricula;
    private javax.swing.JLabel lOrdenListado;
    private javax.swing.JLabel lPlazas;
    private javax.swing.JLabel lPrecio;
    private javax.swing.JLabel lTipo;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem miAbrir;
    private javax.swing.JMenuItem miBuscarVehiculo;
    private javax.swing.JMenuItem miGuardar;
    private javax.swing.JMenuItem miNuevoVehiculo;
    private javax.swing.JMenu miVehiculo;
    private javax.swing.JPanel panelListado;
    private javax.swing.JPanel panelOtras;
    private javax.swing.JScrollPane panelTablaVehiculos;
    private javax.swing.JPanel panelVehiculo;
    private javax.swing.JRadioButton rbListarAlquiler;
    private javax.swing.JRadioButton rbListarMatricula;
    private javax.swing.JFileChooser selectorFicheros;
    private javax.swing.JSpinner spPlazas;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JFormattedTextField tfCapacidad;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JFormattedTextField tfPrecio;
    // End of variables declaration//GEN-END:variables

}