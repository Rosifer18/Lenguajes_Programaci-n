package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.CRUDPacientes;
import Vista.FormularioPacientes;
import Modelo.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ControladorPacientes implements ActionListener{
    private CRUDPacientes crud;
    private FormularioPacientes vista;
    private File archivoSeleccionado = null;
    public ControladorPacientes(FormularioPacientes vista, CRUDPacientes crud){
        this.vista=vista;
        this.crud=crud;
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnCargarFoto().addActionListener(this);

    }
    
    private Paciente capturarDatos() {
        String nombres = vista.getTxtNombres().getText().trim();
        String apellidoPaterno = vista.getTxtApellidoPaterno().getText().trim();
        String apellidoMaterno = vista.getTxtApellidoMaterno().getText().trim();
        Date fechaSeleccionada = vista.getTxtFechaNacimiento().getDate();
        String fechaNacimiento="";
        if (fechaSeleccionada != null) {
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
             fechaNacimiento = formato.format(fechaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una fecha.");
            return null;
        }
        String dni = vista.getTxtDni().getText().trim();
        String telefono = vista.getTxtTelefono().getText().trim();
        String direccion = vista.getTxtDireccion().getText().trim();
        String foto = vista.getTxtFoto().getText().trim();
        String estadoCivil = ((String)vista.getTxtEstadoCivil().getSelectedItem()).trim();
        String genero = "";
        if (vista.getTxtRbFemenino().isSelected() && vista.getTxtRbMasculino().isSelected()){
            vista.mostrarMensaje("No puede elegir ambos géneros");
            return null;
        }else if (vista.getTxtRbFemenino().isSelected()){
            genero = "Femenino";
        }
        else if (vista.getTxtRbMasculino().isSelected()){
            genero = "Masculino";
        }
        String correo = vista.getTxtCorreo().getText().trim();

        if (nombres.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || fechaNacimiento.isEmpty() || dni.isEmpty()|| telefono.isEmpty()|| direccion.isEmpty()|| foto.isEmpty()|| estadoCivil.isEmpty()|| genero.isEmpty()|| correo.isEmpty()) {
            vista.mostrarMensaje("Por favor, complete todos los campos.");
            return null; 
        }


        return new Paciente(nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, dni, telefono, direccion,foto,estadoCivil,genero,correo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == vista.getBtnBuscar()) {
            String dniBuscado = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el DNI a buscar:", 
                "Búsqueda de Paciente", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (dniBuscado != null && !dniBuscado.trim().isEmpty()) {
                dniBuscado = dniBuscado.trim();
                Paciente pacEncontrado = crud.buscarPorDni(dniBuscado);
                
                if (pacEncontrado != null) {
                    Date fechaNacimientoDate = null;
                    try {
                        
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        fechaNacimientoDate = formato.parse(pacEncontrado.fechaNacimiento());

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(vista, "Error al convertir la fecha: " + ex.getMessage());
                    }
                    
                    
                    vista.getTxtNombres().setText(pacEncontrado.nombres());
                    vista.getTxtApellidoPaterno().setText(pacEncontrado.apellidoPaterno());
                    vista.getTxtApellidoMaterno().setText(pacEncontrado.apellidoMaterno());
                    vista.getTxtFechaNacimiento().setDate(fechaNacimientoDate);
                    vista.getTxtDni().setText(pacEncontrado.dni());
                    vista.getTxtTelefono().setText(pacEncontrado.telefono());
                    vista.getTxtDireccion().setText(pacEncontrado.direccion());
                    vista.getTxtFoto().setText(pacEncontrado.foto());
                    vista.getTxtEstadoCivil().setSelectedItem(pacEncontrado.estadoCivil());
                    if (pacEncontrado.genero().equalsIgnoreCase("Femenino")){
                        vista.getTxtRbFemenino().setSelected(true);
                        vista.getTxtRbMasculino().setSelected(false);
                    }else if (pacEncontrado.genero().equalsIgnoreCase("Masculino")){
                        vista.getTxtRbFemenino().setSelected(false);
                        vista.getTxtRbMasculino().setSelected(true);
                    }
                    vista.getTxtCorreo().setText(pacEncontrado.correo());
                    vista.mostrarMensaje("¡Paciente encontrado!");
                } else {
                    vista.mostrarMensaje("No se encontró ningún paciente con ese dni.");
                }
            } else if (dniBuscado != null) {
                vista.mostrarMensaje("Ingrese el dni a buscar.");
            }
        }
        if (e.getSource() == vista.getBtnModificar()) {
            String dniModificar = vista.getTxtDni().getText().trim();
            if (dniModificar != null && !dniModificar.trim().isEmpty()) {
                dniModificar = dniModificar.trim();
                Paciente nuevosDatos = capturarDatos();
                if (crud.modificar(dniModificar, nuevosDatos)) {
                    vista.mostrarMensaje("Paciente modificado con éxito.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Dni no encontrado o error en el archivo.");
                }
                
            } else if (dniModificar != null) {
                vista.mostrarMensaje("Ingrese el dni a modificar.");
            }
        }
        if (e.getSource() == vista.getBtnEliminar()) {
            String dniEliminar = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el dni a eliminar:", 
                "Eliminación de Paciente", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (dniEliminar != null && !dniEliminar.trim().isEmpty()) {
                dniEliminar = dniEliminar.trim();
                if (crud.eliminar(dniEliminar)) {
                    vista.mostrarMensaje("Paciente eliminado del archivo.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Código no encontrado.");
                }
            } else if (dniEliminar != null) {
                vista.mostrarMensaje("Ingrese el dni a eliminar.");
            }
        }
        if (e.getSource() == vista.getBtnGuardar()) {

            ArrayList<Paciente> listaParaEnviar = new ArrayList<>();
            Paciente pac = capturarDatos();
            if (pac == null) return;
            listaParaEnviar.add(pac);
            if (archivoSeleccionado == null) {
                JOptionPane.showMessageDialog(vista, "Por favor, selecciona una foto primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                // Crear la carpeta "imagenes" en la raíz del proyecto si no existe
                File carpetaDestino = new File("imagenes");
                if (!carpetaDestino.exists()) {
                    carpetaDestino.mkdir();
                }

                // Copiar el archivo físicamente
                File archivoDestino = new File(carpetaDestino, archivoSeleccionado.getName());
                Files.copy(
                        archivoSeleccionado.toPath(), 
                        archivoDestino.toPath(), 
                        StandardCopyOption.REPLACE_EXISTING
                );

                // Obtener el nombre para tu lógica de base de datos
                String nombreParaBD = archivoSeleccionado.getName();

                JOptionPane.showMessageDialog(vista, "¡Guardado exitoso!\nNombre registrado: " + nombreParaBD);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                return;
            }
            
            if (crud.guardarLista(listaParaEnviar)) {
                vista.mostrarMensaje("Se ha guardado correctamente.");
                
            } else {
                vista.mostrarMensaje("Error al guardar.");
            }
        }
        if (e.getSource() == vista.getBtnCargarFoto()){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (JPG, PNG)", "jpg", "png", "jpeg");
            fileChooser.setFileFilter(filtro);

            int resultado = fileChooser.showOpenDialog(vista);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                archivoSeleccionado = fileChooser.getSelectedFile();
                
                
                vista.getTxtFoto().setText(archivoSeleccionado.getName());

                
                ImageIcon iconoOriginal = new ImageIcon(archivoSeleccionado.getAbsolutePath());
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                        vista.getLblFoto().getWidth(), 
                        vista.getLblFoto().getHeight(), 
                        Image.SCALE_SMOOTH
                );
                vista.getLblFoto().setIcon(new ImageIcon(imagenEscalada));
                vista.getLblFoto().setText("");
        }
        
    }
}
}
