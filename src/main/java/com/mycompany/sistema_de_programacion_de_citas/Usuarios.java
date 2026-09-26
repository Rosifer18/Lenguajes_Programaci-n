package com.mycompany.sistema_de_programacion_de_citas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Usuarios extends javax.swing.JFrame {
        private void configurarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Código", "Nombre"}
        );
        jTable1.setModel(modelo);
        }
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Usuarios.class.getName());
    public Usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("REGISTRO DE USUARIOS");

        jLabel2.setText("Nombre:");

        jLabel3.setText("ID:");

        jLabel4.setText("Contraseña:");

        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jButton1.setText("Registrar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Enviar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "ID", "Contraseña"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Buscar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Modificar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton5.setText("Eliminar");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jButton1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton3)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    try {
        FileWriter archivo = new FileWriter("registros.txt", true);
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            String Nombre = modelo.getValueAt(fila, 0).toString();
            String ID = modelo.getValueAt(fila, 1).toString();
            String Contraseña = modelo.getValueAt(fila, 2).toString();
            archivo.write(Nombre + ";" + ID + ";" + Contraseña);
            archivo.write(System.lineSeparator());
        }
        archivo.close();
        JOptionPane.showMessageDialog(
                this,
                "Contenido de la tabla guardado correctamente."
        );
    } catch (IOException e) {
        JOptionPane.showMessageDialog(
                this,
                "Error al guardar el archivo: " + e.getMessage()
        );
    }
    modelo.setRowCount(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            String Nombre = jTextField1.getText();
    String ID = jTextField2.getText();
    String Contraseña = jTextField3.getText();
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.addRow(new Object[]{
        Nombre,
        ID,
        Contraseña
    });
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField1.requestFocus(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    String idBuscado = jTextField2.getText().trim();
    if (idBuscado.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Por favor, ingrese un ID para realizar la búsqueda.", 
            "Campo vacío", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    } 
File archivo = new File("registros.txt");
if (!archivo.exists()) {
    JOptionPane.showMessageDialog(this, "El archivo de registros aún no existe.");
    return;
}
boolean encontrado = false;
try {
    BufferedReader br = new BufferedReader(new FileReader(archivo));
    String linea;
    
    while ((linea = br.readLine()) != null) {
        String[] datos = linea.split(";");

        if (datos.length == 3 && datos[1].equalsIgnoreCase(idBuscado)) {
            jTextField1.setText(datos[0]);
            jTextField2.setText(datos[1]);
            jTextField3.setText(datos[2]);
            JOptionPane.showMessageDialog(this, "¡Usuario encontrado en el archivo!");
            encontrado = true;
            break;
        }
    }
    br.close();

    if (!encontrado) {
        JOptionPane.showMessageDialog(this, "No se encontró ningún usuario con ese ID.");
    }
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
            int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla para modificar.", "Atención", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String nuevoNombre = jTextField1.getText().trim();
    String nuevoID = jTextField2.getText().trim();
    String nuevaContrasena = jTextField3.getText().trim();
    if (nuevoNombre.isEmpty() || nuevoID.isEmpty() || nuevaContrasena.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos para modificar el registro.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        return;
    }
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setValueAt(nuevoNombre, filaSeleccionada, 0);
    modelo.setValueAt(nuevoID, filaSeleccionada, 1);
    modelo.setValueAt(nuevaContrasena, filaSeleccionada, 2);
    try (java.io.FileWriter archivo = new java.io.FileWriter("registros.txt", false)) { // 'false' limpia el archivo antes de escribir
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            String nom = modelo.getValueAt(fila, 0).toString();
            String id = modelo.getValueAt(fila, 1).toString();
            String pass = modelo.getValueAt(fila, 2).toString();
            archivo.write(nom + ";" + id + ";" + pass);
            archivo.write(System.lineSeparator());
        }
        JOptionPane.showMessageDialog(this, "Registro modificado correctamente tanto en la tabla como en el archivo.");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error crítico al guardar los cambios en el archivo: " + e.getMessage(), "Error de Archivo", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione el usuario que desea eliminar de la tabla.", "Atención", JOptionPane.WARNING_MESSAGE);
        return;
    }
    int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar permanentemente este registro del archivo txt?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
    if (respuesta == JOptionPane.YES_OPTION) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.removeRow(filaSeleccionada);
        try (java.io.FileWriter archivo = new java.io.FileWriter("registros.txt", false)) {
            for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                String nom = modelo.getValueAt(fila, 0).toString();
                String id = modelo.getValueAt(fila, 1).toString();
                String pass = modelo.getValueAt(fila, 2).toString();
                archivo.write(nom + ";" + id + ";" + pass);
                archivo.write(System.lineSeparator());
            }
            JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el archivo después de eliminar: " + e.getMessage(), "Error de Archivo", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> new Usuarios().setVisible(true));
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
