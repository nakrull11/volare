/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volare.vista;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import volare.modelo.Conexion;
import volare.modelo.Pasajero;
import volare.modelo.PasajeroData;

/**
 *
 * @author gustavo
 */
public class Login extends javax.swing.JInternalFrame {

    private Conexion conexion;
    private PasajeroData pasajeroData;
    /**
     * Creates new form Login
     */
    public Login() {
        
            initComponents();
            
            
        try {
            
            
            conexion = new Conexion("jdbc:mysql://localhost/volare", "root", "");
            pasajeroData = new PasajeroData (conexion);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbIngresar = new javax.swing.JButton();
        jtDocumento = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtCorreo = new javax.swing.JTextField();
        jCheckBoxPasaporte = new javax.swing.JCheckBox();
        jtPasaporte = new javax.swing.JTextField();
        jLabelFechaDeNac = new javax.swing.JLabel();
        jLabelFechaNacimientoElegida = new javax.swing.JLabel();
        jtFechaNacimiento = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 102, 255));
        setBorder(null);
        setForeground(new java.awt.Color(240, 240, 240));
        setTitle("Sign in\n");
        setFrameIcon(null);
        setName(""); // NOI18N

        jbIngresar.setBackground(new java.awt.Color(0, 204, 51));
        jbIngresar.setFont(new java.awt.Font("Myriad Pro Light", 1, 18)); // NOI18N
        jbIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jbIngresar.setText("Ingresar");
        jbIngresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbIngresar.setContentAreaFilled(false);
        jbIngresar.setOpaque(true);
        jbIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarActionPerformed(evt);
            }
        });

        jtDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtDocumento.setForeground(new java.awt.Color(255, 255, 255));
        jtDocumento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° de Documento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Myriad Pro Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jtDocumento.setOpaque(false);
        jtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDocumentoActionPerformed(evt);
            }
        });

        jPassword.setBackground(new java.awt.Color(102, 102, 255));
        jPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Myriad Pro Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPassword.setOpaque(false);
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/volare/vista/img/userIcon.png"))); // NOI18N

        jtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtNombre.setForeground(new java.awt.Color(255, 255, 255));
        jtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Myriad Pro Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jtNombre.setOpaque(false);
        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });

        jtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtApellido.setForeground(new java.awt.Color(255, 255, 255));
        jtApellido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Myriad Pro Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jtApellido.setOpaque(false);
        jtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtApellidoActionPerformed(evt);
            }
        });

        jtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Myriad Pro Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jtCorreo.setOpaque(false);
        jtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCorreoActionPerformed(evt);
            }
        });

        jCheckBoxPasaporte.setFont(new java.awt.Font("Miriam", 1, 10)); // NOI18N
        jCheckBoxPasaporte.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxPasaporte.setText("Poseo pasaporte");
        jCheckBoxPasaporte.setOpaque(false);
        jCheckBoxPasaporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPasaporteActionPerformed(evt);
            }
        });

        jtPasaporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtPasaporte.setForeground(new java.awt.Color(255, 255, 255));
        jtPasaporte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "N° de Pasaporte\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Myriad Pro Light", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jtPasaporte.setEnabled(false);
        jtPasaporte.setOpaque(false);
        jtPasaporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPasaporteActionPerformed(evt);
            }
        });

        jLabelFechaDeNac.setFont(new java.awt.Font("Miriam", 0, 14)); // NOI18N
        jLabelFechaDeNac.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechaDeNac.setText("Ingrese fecha de nacimiento");

        jLabelFechaNacimientoElegida.setFont(new java.awt.Font("Miriam", 0, 14)); // NOI18N
        jLabelFechaNacimientoElegida.setForeground(new java.awt.Color(255, 255, 255));

        jtFechaNacimiento.setText("dd/mm/aaaa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtPasaporte, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBoxPasaporte)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelFechaDeNac)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbIngresar)
                                            .addComponent(jLabelFechaNacimientoElegida)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFechaNacimientoElegida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxPasaporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtPasaporte, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFechaDeNac)
                            .addComponent(jtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDocumentoActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jbIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarActionPerformed

        boolean ingreso = false;
        String nombre= jtNombre.getText();
        String apellido= jtApellido.getText();
        String correo=jtCorreo.getText() ;
        String password=jPassword.getText();
        int documento=Integer.parseInt(jtDocumento.getText());
        int pasaporte;
         if(jCheckBoxPasaporte.isSelected()){
             pasaporte=Integer.parseInt(jtPasaporte.getText());
            }else pasaporte = 0;
        LocalDate fechaNac = LocalDate.parse(jtFechaNacimiento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Pasajero pasajero = new Pasajero();
        pasajero.setFechaNacimiento(fechaNac);
        pasajero.setApellido(apellido);
        pasajero.setNombre(nombre);
        pasajero.setPassword(password);
        pasajero.setCorreoElectronico(correo);
        pasajero.setDni(documento);
        pasajero.setPasaporte(pasaporte);
        if(pasajeroData.guardarPasajero(pasajero)){
            ingreso = true;
        }
        
        if(ingreso){
            jtNombre.setText(null);
            jtApellido.setText(null);
            jtCorreo.setText(null);
            jPassword.setText(null);
            jtDocumento.setText(null);
            jtPasaporte.setText(null);
            jCheckBoxPasaporte.setSelected(false);
            jtFechaNacimiento.setText("dd/mm/aaaa");
            JOptionPane.showMessageDialog(this,"Se ha registrado con exito,ahora puede reservar y gestionar sus vuelos");      
        }
        
        
              
    }//GEN-LAST:event_jbIngresarActionPerformed

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellidoActionPerformed

    private void jtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCorreoActionPerformed

    private void jtPasaporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPasaporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPasaporteActionPerformed

    private void jCheckBoxPasaporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPasaporteActionPerformed
        // TODO add your handling code here:
        
        jtPasaporte.setEnabled(jCheckBoxPasaporte.isSelected());
    }//GEN-LAST:event_jCheckBoxPasaporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxPasaporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFechaDeNac;
    private javax.swing.JLabel jLabelFechaNacimientoElegida;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JButton jbIngresar;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JTextField jtDocumento;
    private javax.swing.JTextField jtFechaNacimiento;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPasaporte;
    // End of variables declaration//GEN-END:variables
}
