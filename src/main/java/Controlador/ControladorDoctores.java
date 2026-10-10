
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.CRUDDoctores;
import Vista.FormularioDoctores;
import Modelo.Doctor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ControladorDoctores implements ActionListener{
    private CRUDDoctores crud;
    private FormularioDoctores vista;
    
    public ControladorDoctores(FormularioDoctores vista, CRUDDoctores crud){
        this.vista=vista;
        this.crud=crud;
        this.vista.getTxtCodigo().addActionListener(this);
        this.vista.getTxtNombre().addActionListener(this);
        this.vista.getTxtCargo().addActionListener(this);
        this.vista.getTxtEspecialidad().addActionListener(this);
        this.vista.getTxtDisponibilidad().addActionListener(this);
        this.vista.getTxtHorario().addActionListener(this);
        this.vista.getTxtTelefono().addActionListener(this);
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnEnviar().addActionListener(this);
    }
    
    private Doctor capturarDatos() {
        String codigo = vista.getTxtCodigo().getText().trim();
        String nombre = vista.getTxtNombre().getText().trim();
        String cargo = vista.getTxtCargo().getText().trim();
        String especialidad = vista.getTxtEspecialidad().getText().trim();
        String disponibilidad = ((String) vista.getTxtDisponibilidad().getSelectedItem()).trim();
        String horario = vista.getTxtHorario().getText().trim();
        String telefono = vista.getTxtTelefono().getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || cargo.isEmpty() || especialidad.isEmpty() || disponibilidad.isEmpty()|| horario.isEmpty()|| telefono.isEmpty()) {
            vista.mostrarMensaje("Por favor, complete todos los campos.");
            return null; 
        }
        String regexHorario = "^([01]?[0-9]|2[0-3]):[0-5][0-9] - ([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        if (!horario.matches(regexHorario)) {
            vista.mostrarMensaje("El horario debe tener el formato válido (Ej: 08:00 - 17:00).");
            return null;
        }

        
        String telefonoLimpio = telefono.replace(" ", "").trim();
        if (!telefonoLimpio.matches("^9\\d{8}$")) {
            vista.mostrarMensaje("El teléfono celular debe tener 9 dígitos y empezar con 9 (Ej: 912 345 678).");
            return null;
        }


        return new Doctor(codigo, nombre, cargo, especialidad,telefono, disponibilidad, horario);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        

        if (e.getSource() == vista.getBtnGuardar()) {
            Doctor doc = capturarDatos();
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable1().getModel();
            modelo.addRow(new Object[]{doc.codigo(), doc.nombre(), doc.cargo(), doc.especialidad(), doc.telefono(), doc.disponibilidad(), doc.horario()});

            vista.limpiarFormulario();
            vista.mostrarMensaje("Doctor guardado con éxito.");
            
        }
        if (e.getSource() == vista.getBtnBuscar()) {
            String codigoBuscado = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el código a buscar:", 
                "Búsqueda de Doctor", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (codigoBuscado != null && !codigoBuscado.trim().isEmpty()) {
                codigoBuscado = codigoBuscado.trim();
                Doctor docEncontrado = crud.buscarPorCodigo(codigoBuscado);
                if (docEncontrado != null) {
                    vista.getTxtCodigo().setText(docEncontrado.codigo());
                    vista.getTxtNombre().setText(docEncontrado.nombre());
                    vista.getTxtCargo().setText(docEncontrado.cargo());
                    vista.getTxtEspecialidad().setText(docEncontrado.especialidad());
                    vista.getTxtDisponibilidad().setSelectedItem(docEncontrado.disponibilidad());
                    vista.getTxtHorario().setText(docEncontrado.horario());
                    vista.getTxtTelefono().setText(docEncontrado.telefono());
                    vista.mostrarMensaje("¡Doctor encontrado!");
                } else {
                    vista.mostrarMensaje("No se encontró ningún doctor con ese código.");
                }
            } else if (codigoBuscado != null) {
                vista.mostrarMensaje("Ingrese el código a buscar.");
            }
        }
        if (e.getSource() == vista.getBtnModificar()) {
            String codigoModificar = vista.getTxtCodigo().getText().trim();
            if (codigoModificar != null && !codigoModificar.trim().isEmpty()) {
                codigoModificar = codigoModificar.trim();
                Doctor nuevosDatos = capturarDatos();
                if (crud.modificar(codigoModificar, nuevosDatos)) {
                    vista.mostrarMensaje("Doctor modificado con éxito.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Código no encontrado o error en el archivo.");
                }
                
            } else if (codigoModificar != null) {
                vista.mostrarMensaje("Ingrese el código a modificar.");
            }
        }
        if (e.getSource() == vista.getBtnEliminar()) {
            String codigoEliminar = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el código a eliminar:", 
                "Eliminación de Doctor", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (codigoEliminar != null && !codigoEliminar.trim().isEmpty()) {
                codigoEliminar = codigoEliminar.trim();
                if (crud.eliminar(codigoEliminar)) {
                    vista.mostrarMensaje("Doctor eliminado del archivo.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Código no encontrado.");
                }
            } else if (codigoEliminar != null) {
                vista.mostrarMensaje("Ingrese el código a eliminar.");
            }
        }
        if (e.getSource() == vista.getBtnEnviar()) {
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable1().getModel();
            if (modelo.getRowCount() == 0) {
                vista.mostrarMensaje("La tabla está vacía.");
                return;
            }

            ArrayList<Doctor> listaParaEnviar = new ArrayList<>();
            for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                Doctor doc = new Doctor(
                    modelo.getValueAt(fila, 0).toString(),
                    modelo.getValueAt(fila, 1).toString(),
                    modelo.getValueAt(fila, 2).toString(),
                    modelo.getValueAt(fila, 3).toString(),
                    modelo.getValueAt(fila, 4).toString(),
                    modelo.getValueAt(fila, 5).toString(),
                    modelo.getValueAt(fila, 6).toString()
                );
                listaParaEnviar.add(doc);
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

