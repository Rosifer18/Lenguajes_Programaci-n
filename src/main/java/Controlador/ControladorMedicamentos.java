package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.CRUDMedicamentos;
import Vista.FormularioMedicamentos;
import Modelo.Medicamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ControladorMedicamentos implements ActionListener{
    private CRUDMedicamentos crud;
    private FormularioMedicamentos vista;
    public ControladorMedicamentos(FormularioMedicamentos vista, CRUDMedicamentos crud){
        this.vista=vista;
        this.crud=crud;
        this.vista.getTxtCodigo().addActionListener(this);
        this.vista.getTxtNombre().addActionListener(this);
        this.vista.getTxtComponente().addActionListener(this);
        this.vista.getTxtLaboratorio().addActionListener(this);
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnEnviar().addActionListener(this);
        
    }
    private Medicamento capturarDatos() {
        String codigo = vista.getTxtCodigo().getText().trim();
        String nombre = vista.getTxtNombre().getText().trim();
        String componente = vista.getTxtComponente().getText().trim();
        String laboratorio = vista.getTxtLaboratorio().getText().trim();
        String stock = vista.getTxtStock().getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || componente.isEmpty() || laboratorio.isEmpty() || stock.isEmpty()) {
            vista.mostrarMensaje("Por favor, complete todos los campos.");
            return null; // Retorna null para indicar que la captura falló
        }


        return new Medicamento(codigo, nombre, componente, laboratorio, stock);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.getBtnGuardar()) {
            Medicamento med = capturarDatos();
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable3().getModel();
            modelo.addRow(new Object[]{med.codigo(), med.nombre(), med.componente(), med.laboratorio(), med.stock()});

            vista.limpiarFormulario();
            vista.mostrarMensaje("Medicamento guardado con éxito.");
            
        }
        
        if (e.getSource() == vista.getBtnBuscar()) {
            String codigoBuscado = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el código a buscar:", 
                "Búsqueda de Medicamento", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (codigoBuscado != null && !codigoBuscado.trim().isEmpty()) {
                codigoBuscado = codigoBuscado.trim();
                Medicamento medEncontrado = crud.buscarPorCodigo(codigoBuscado);
                if (medEncontrado != null) {
                    vista.getTxtCodigo().setText(medEncontrado.codigo());
                    vista.getTxtNombre().setText(medEncontrado.nombre());
                    vista.getTxtComponente().setText(medEncontrado.componente());
                    vista.getTxtLaboratorio().setText(medEncontrado.laboratorio());
                    vista.getTxtStock().setText(medEncontrado.stock());
                    vista.mostrarMensaje("¡Medicamento encontrado!");
                } else {
                    vista.mostrarMensaje("No se encontró ningún medicamento con ese código.");
                }
            } else if (codigoBuscado != null) {
                vista.mostrarMensaje("Ingrese el código a buscar.");
            }
        }
        if (e.getSource() == vista.getBtnModificar()) {
            String codigoModificar = vista.getTxtCodigo().getText().trim();
            if (codigoModificar != null && !codigoModificar.trim().isEmpty()) {
                codigoModificar = codigoModificar.trim();
                Medicamento nuevosDatos = capturarDatos();
                if (crud.modificar(codigoModificar, nuevosDatos)) {
                    vista.mostrarMensaje("Medicamento modificado con éxito.");
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
                "Eliminación de Medicamento", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (codigoEliminar != null && !codigoEliminar.trim().isEmpty()) {
                codigoEliminar = codigoEliminar.trim();
                if (crud.eliminar(codigoEliminar)) {
                    vista.mostrarMensaje("Medicamento eliminado del archivo.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Código no encontrado.");
                }
            } else if (codigoEliminar != null) {
                vista.mostrarMensaje("Ingrese el código a eliminar.");
            }
        }
        if (e.getSource() == vista.getBtnEnviar()) {
            DefaultTableModel modelo = (DefaultTableModel) vista.getJTable3().getModel();
            if (modelo.getRowCount() == 0) {
                vista.mostrarMensaje("La tabla está vacía.");
                return;
            }

            ArrayList<Medicamento> listaParaEnviar = new ArrayList<>();
            for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                Medicamento med = new Medicamento(
                    modelo.getValueAt(fila, 0).toString(),
                    modelo.getValueAt(fila, 1).toString(),
                    modelo.getValueAt(fila, 2).toString(),
                    modelo.getValueAt(fila, 3).toString(),
                    modelo.getValueAt(fila, 4).toString()
                );
                listaParaEnviar.add(med);
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
