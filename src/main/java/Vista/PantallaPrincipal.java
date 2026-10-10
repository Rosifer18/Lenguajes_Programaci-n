/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package Vista;
import Vista.FormularioMedicamentos;
import Modelo.CRUDMedicamentos;
import Controlador.ControladorMedicamentos;
import Vista.FormularioDoctores;
import Modelo.CRUDDoctores;
import Controlador.ControladorDoctores;
import Vista.FormularioUsuarios;
import Modelo.CRUDUsuarios;
import Controlador.ControladorUsuarios;
import Vista.FormularioPacientes;
import Modelo.CRUDPacientes;
import Controlador.ControladorPacientes;
import Vista.FormularioCitas;
import Modelo.CRUDCitas;
import Controlador.ControladorCitas;
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Registros");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Usuarios");
        openMenuItem.addActionListener(this::openMenuItemActionPerformed);
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Doctores");
        saveMenuItem.addActionListener(this::saveMenuItemActionPerformed);
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Medicamentos");
        saveAsMenuItem.addActionListener(this::saveAsMenuItemActionPerformed);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Pacientes");
        exitMenuItem.addActionListener(this::exitMenuItemActionPerformed);
        fileMenu.add(exitMenuItem);

        jMenuItem1.setText("Citas de pacientes");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        fileMenu.add(jMenuItem1);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        FormularioPacientes form_pacientes = new FormularioPacientes();
        CRUDPacientes crud_pac = new CRUDPacientes();
        ControladorPacientes controlador_pac = new ControladorPacientes(form_pacientes,crud_pac);
        form_pacientes.setVisible(true);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        FormularioMedicamentos form_med = new FormularioMedicamentos();
        CRUDMedicamentos crud_med = new CRUDMedicamentos();
        ControladorMedicamentos controlador_med = new ControladorMedicamentos(form_med,crud_med);
        
        form_med.setVisible(true);
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        FormularioUsuarios form_usu = new FormularioUsuarios();
        CRUDUsuarios crud_usu = new CRUDUsuarios();
        ControladorUsuarios controlador_usu = new ControladorUsuarios(form_usu,crud_usu);
        form_usu.setVisible(true);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        FormularioDoctores form_doc= new FormularioDoctores();
        CRUDDoctores crud_doc = new CRUDDoctores();
        ControladorDoctores controlador_doc = new ControladorDoctores(form_doc,crud_doc);
        form_doc.setVisible(true);
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FormularioCitas form_citas = new FormularioCitas();
        CRUDCitas  crud_citas = new CRUDCitas();
        ControladorCitas controlador_cit = new ControladorCitas(form_citas,crud_citas);
        form_citas.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
