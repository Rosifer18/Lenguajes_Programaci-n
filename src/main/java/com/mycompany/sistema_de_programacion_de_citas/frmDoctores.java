package com.mycompany.sistema_de_programacion_de_citas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmDoctores extends javax.swing.JFrame {
    private DoctorLogica logica = new DoctorLogica();
    public frmDoctores() {
        initComponents();
        configurarTabla();
        cargarDatosTabla();
        this.setLocationRelativeTo(null);
    }
    private void configurarTabla(){
        DefaultTableModel modelo =new DefaultTableModel(
        new Object[][] {},
        new String[]{"Codigo", "Nombre","Cargo","Especialidad","Telefono","Disponibilidad","Horario"}
        );
        jTable1.setModel(modelo);
    }
    private void cargarDatosTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        try {
            List<Doctor> lista = logica.obtenerTodos();
            for (Doctor doc : lista) {
                modelo.addRow(new Object[]{
                    doc.codigo(),
                    doc.nombre(),
                    doc.cargo(),
                    doc.especialidad(),
                    doc.telefono(),
                    doc.disponibilidad(),
                    doc.horario()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos en la tabla: " + e.getMessage());
        }
    }
    private void limpiarCampos() {
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    
    if (jComboBox1.getItemCount() > 0) {
        jComboBox1.setSelectedIndex(0);
    }
    
    jTextField1.requestFocus();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        JLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        JLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        JLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        JLabel = new javax.swing.JLabel();
        JLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        JLabel2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Registro de Datos");

        JLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel3.setText("Codigo");

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        JLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel4.setText("Nombre");

        JLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel5.setText("Cargo");

        JLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel6.setText("Especialidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel4)
                    .addComponent(jTextField2))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel5))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel6))
                .addGap(548, 548, 548))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No Disponible", " " }));

        JLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLabel.setText("Disponibilidad");

        JLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLabel1.setText("Horario");

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JLabel2.setText("Telefono");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel1)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Modificar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton2.setText("Enviar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(122, 122, 122)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Doctor doc = logica.buscarPorCodigo(jTextField1.getText());
    
    if (doc != null) {
        jTextField2.setText(doc.nombre());
        jTextField3.setText(doc.cargo());
        jTextField4.setText(doc.especialidad());
        jTextField5.setText(doc.telefono());
        jComboBox1.setSelectedItem(doc.disponibilidad());
        jTextField6.setText(doc.horario());
    } else {
        JOptionPane.showMessageDialog(this, "Doctor no encontrado o código vacío.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String disp = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : "Disponible";
    Doctor docActualizado = new Doctor(
        jTextField1.getText().trim(), jTextField2.getText().trim(),
        jTextField3.getText().trim(), jTextField4.getText().trim(),
        jTextField5.getText().trim(), disp, jTextField6.getText().trim()
    );

    if (logica.modificarDoctor(docActualizado)) {
        JOptionPane.showMessageDialog(this, "Doctor modificado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        cargarDatosTabla();
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró el código para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
    }  

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String codigo = jTextField1.getText().trim();
    String nombre = jTextField2.getText().trim();
    String cargo = jTextField3.getText().trim();
    String especialidad = jTextField4.getText().trim();
    String telefono = jTextField5.getText().trim();
    
   
    String disponibilidad = "Disponible";
    if (jComboBox1.getSelectedItem() != null) {
        disponibilidad = jComboBox1.getSelectedItem().toString();
    }
    
    String horario = jTextField6.getText().trim();

    if (codigo.isEmpty() || nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Complete al menos el código y el nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Doctor nuevoDoctor = new Doctor(codigo, nombre, cargo, especialidad, telefono, disponibilidad, horario);

    if (logica.agregarDoctor(nuevoDoctor)) {
        JOptionPane.showMessageDialog(this, "Doctor registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        cargarDatosTabla(); 
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "El código ingresado ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    if (logica.eliminarDoctor(jTextField1.getText().trim())) {
        JOptionPane.showMessageDialog(this, "Doctor eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        cargarDatosTabla();
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró el código a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
    }      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
    */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel JLabel4;
    private javax.swing.JLabel JLabel5;
    private javax.swing.JLabel JLabel6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
