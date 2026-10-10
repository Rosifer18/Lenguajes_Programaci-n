/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CRUDUsuarios;
import Modelo.Usuario;
import Vista.FormularioUsuarios;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rodrigo
 */
public class ControladorUsuarios implements ActionListener{
    private CRUDUsuarios crud;
    private FormularioUsuarios vista;
    public ControladorUsuarios(FormularioUsuarios vista, CRUDUsuarios crud){
        this.vista=vista;
        this.crud=crud;
        this.vista.getTxtNombre().addActionListener(this);
        this.vista.getTxtContraseña().addActionListener(this);
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnEnviar().addActionListener(this);
        
    }
    private Usuario capturarDatos() {
        String nombre = vista.getTxtNombre().getText().trim();
        String contraseña = vista.getTxtContraseña().getText().trim();

        if (nombre.isEmpty() || contraseña.isEmpty()) {
            vista.mostrarMensaje("Por favor, complete todos los campos.");
            return null; // Retorna null para indicar que la captura falló
        }


        return new Usuario(nombre, contraseña);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.getBtnGuardar()) {
            Usuario usu = capturarDatos();
            if (usu != null) {
                DefaultTableModel modelo = (DefaultTableModel) vista.getJTable1().getModel();
                modelo.addRow(new Object[]{
                    usu.nombre(), 
                    usu.contraseña()
                });

                vista.limpiarFormulario();
                vista.mostrarMensaje("Usuario guardado con éxito.");
            }
        }
        if (e.getSource() == vista.getBtnBuscar()) {
            String nombreBuscado = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el nombre a buscar:", 
                "Búsqueda de Usuario", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (nombreBuscado != null && !nombreBuscado.trim().isEmpty()) {
                nombreBuscado = nombreBuscado.trim();
                Usuario usuEncontrado = crud.buscarPorNombre(nombreBuscado);
                if (usuEncontrado != null) {
                    vista.getTxtNombre().setText(usuEncontrado.nombre());
                    vista.getTxtContraseña().setText(usuEncontrado.contraseña());
                    vista.mostrarMensaje("¡Usuario encontrado!");
                } else {
                    vista.mostrarMensaje("No se encontró ningún usuario con ese nombre.");
                }
            } else if (nombreBuscado != null) {
                vista.mostrarMensaje("Ingrese el nombre a buscar.");
            }
        }
        if (e.getSource() == vista.getBtnModificar()) {
            String nombreModificar = vista.getTxtNombre().getText().trim();
            if (nombreModificar != null && !nombreModificar.trim().isEmpty()) {
                nombreModificar = nombreModificar.trim();
                Usuario nuevosDatos = capturarDatos();
                if (crud.modificar(nombreModificar, nuevosDatos)) {
                    vista.mostrarMensaje("Usuario modificado con éxito.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Nombre no encontrado o error en el archivo.");
                }
                
            } else if (nombreModificar != null) {
                vista.mostrarMensaje("Ingrese el nombre a modificar.");
            }
        }
        if (e.getSource() == vista.getBtnEliminar()) {
            String nombreEliminar = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el nombre a eliminar:", 
                "Eliminación de Usuario", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (nombreEliminar != null && !nombreEliminar.trim().isEmpty()) {
                nombreEliminar = nombreEliminar.trim();
                if (crud.eliminar(nombreEliminar)) {
                    vista.mostrarMensaje("Usuario eliminado del archivo.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Nombre no encontrado.");
                }
            } else if (nombreEliminar != null) {
                vista.mostrarMensaje("Ingrese el nombre a eliminar.");
            }
        }
        if (e.getSource() == vista.getBtnEnviar()) {
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable1().getModel();
            if (modelo.getRowCount() == 0) {
                vista.mostrarMensaje("La tabla está vacía.");
                return;
            }

            ArrayList<Usuario> listaParaEnviar = new ArrayList<>();
            for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                Usuario usu = new Usuario(
                    modelo.getValueAt(fila, 0).toString(),
                    modelo.getValueAt(fila, 1).toString()
                );
                listaParaEnviar.add(usu);
            }

            
            if (crud.guardarLista(listaParaEnviar)) {
                vista.mostrarMensaje("Contenido de la tabla guardado correctamente.");
                modelo.setRowCount(0);
            } else {
                vista.mostrarMensaje("Error al guardar el contenido de la tabla.");
            }
        }
        
    }
}
