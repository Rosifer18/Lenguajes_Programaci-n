
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.CRUDCitas;
import Vista.FormularioCitas;
import Modelo.Cita;
import Modelo.GestorSesion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ControladorCitas implements ActionListener{
    private CRUDCitas crud;
    private FormularioCitas vista;
    private String rutaArchivo = "pacientes.txt";
    private String rutaArchivo1 = "doctores.txt";
    private String rutaArchivo2 = "medicamentos.txt";
    private String rutaArchivo3 = "citas.txt";
    
    
    public void ConfigurarCombobox(){
        
        File archivo = new File(rutaArchivo);
        String usuarioLogueado = (GestorSesion.obtenerUsuarioLogueado()).trim();
        System.out.println(usuarioLogueado);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 11) {
                    String paciente = String.join(" ", datos[0], datos[1], datos[2]);
                    
                    vista.getTxtPaciente().addItem(paciente);
                   
                    if (paciente.equalsIgnoreCase(usuarioLogueado)) {
                        vista.getTxtPaciente().setSelectedItem(paciente);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        
        
        File archivo1 = new File(rutaArchivo1);
        

        try (BufferedReader br1 = new BufferedReader(new FileReader(archivo1))) {
            String linea1;
            while ((linea1 = br1.readLine()) != null) {
                String[] datos1 = linea1.split(";");
                if (datos1.length == 7) {
                    String doctor = datos1[1];
                    vista.getTxtDoctor().addItem(doctor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        
        File archivo2 = new File(rutaArchivo2);
        

        try (BufferedReader br2 = new BufferedReader(new FileReader(archivo2))) {
            String linea2;
            while ((linea2 = br2.readLine()) != null) {
                String[] datos2 = linea2.split(";");
                if (datos2.length == 5) {
                    String medicamento = datos2[1];
                    vista.getTxtMedicamento().addItem(medicamento);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        
        
        
        File archivo4 = new File(rutaArchivo3);
        String ultimoCodigo;
        ultimoCodigo="";
        try (BufferedReader br4 = new BufferedReader(new FileReader(archivo4))) {
            String linea4;
            
            while ((linea4 = br4.readLine()) != null) {
                String[] datos4 = linea4.split(";");
                if (datos4.length == 8 ) {
                    ultimoCodigo=datos4[0];
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        int codigoActualizado = 1;
        try {
            if (!ultimoCodigo.isEmpty()) {
                codigoActualizado = Integer.parseInt(ultimoCodigo) + 1;
            }
        } catch (NumberFormatException e) {
            codigoActualizado = 1; 
        }
        String codigoActual= "00" + String.valueOf(codigoActualizado);
        vista.getTxtCodigo().setText(codigoActual);
    }
    public ControladorCitas(FormularioCitas vista, CRUDCitas crud){
        this.vista=vista;
        this.crud=crud;
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        ConfigurarCombobox();
        if (!GestorSesion.obtenerUsuarioLogueado().equals("admin")){
            vista.getTxtCodigo().setEditable(false);
            vista.getTxtPaciente().setEnabled(false);
            vista.getTxtMedicamento().setEnabled(false);
            vista.getTxtDiagnostico().setEditable(false);
            vista.getTxtGravedad().setEnabled(false);
        }

        
        
        
        
        
        
        
    }
    
    private Cita capturarDatos() {
        String codigo = vista.getTxtCodigo().getText().trim();
        String paciente =((String) vista.getTxtPaciente().getSelectedItem()).trim();
        String doctor = ((String) vista.getTxtDoctor().getSelectedItem()).trim();
        String medicamento=((String) vista.getTxtMedicamento().getSelectedItem()).trim();
        String dia = "";
        Date fechaSeleccionada = vista.getTxtDia().getDate();
        if (fechaSeleccionada != null) {
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
             dia = formato.format(fechaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una fecha.");
            return null;
        }
        
        
        String hora = ((String)vista.getTxtHora().getText()).trim();
        String diagnostico = vista.getTxtDiagnostico().getText().trim();
        String gravedad = ((String)vista.getTxtGravedad().getSelectedItem()).trim();
        
        if (codigo.isEmpty() || paciente.isEmpty() || doctor.isEmpty() || medicamento.isEmpty() || dia.isEmpty()|| hora.isEmpty()|| diagnostico.isEmpty()|| gravedad.isEmpty()) {
            vista.mostrarMensaje("Por favor, complete todos los campos.");
            return null; 
        }
        if (!hora.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            vista.mostrarMensaje("El formato de la hora es inválido. Use el formato HH:mm (Ej: 14:30).");
            return null;
        }
        if (paciente.equalsIgnoreCase("Seleccionar")) {
            vista.mostrarMensaje("Por favor, seleccione un paciente válido.");
            return null;
        }

        if (doctor.equalsIgnoreCase("Seleccionar")) {
            vista.mostrarMensaje("Por favor, seleccione un doctor válido.");
            return null;
        }

        return new Cita(codigo, paciente, doctor, medicamento, dia, hora, diagnostico,gravedad);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == vista.getBtnBuscar()) {
            String codigoBuscado = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el Código a buscar:", 
                "Búsqueda de Cita", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (codigoBuscado != null && !codigoBuscado.trim().isEmpty()) {
                codigoBuscado = codigoBuscado.trim();
                Cita citEncontrado = crud.buscarPorCodigo(codigoBuscado);
                
                if (citEncontrado != null) {
                    Date DiaDate = null;
                    try {
                        
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        DiaDate = formato.parse(citEncontrado.dia());

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(vista, "Error al convertir la fecha: " + ex.getMessage());
                    }
                    
                    
                    vista.getTxtCodigo().setText(citEncontrado.codigo());
                    vista.getTxtPaciente().setSelectedItem(citEncontrado.paciente());
                    vista.getTxtDoctor().setSelectedItem(citEncontrado.doctor());
                    vista.getTxtMedicamento().setSelectedItem(citEncontrado.medicamento());
                    vista.getTxtDia().setDate(DiaDate);
                    vista.getTxtHora().setText(citEncontrado.hora());
                    vista.getTxtDiagnostico().setText(citEncontrado.diagnostico());
                    vista.getTxtGravedad().setSelectedItem(citEncontrado.gravedad());
                    vista.mostrarMensaje("¡Cita encontrado!");
                } else {
                    vista.mostrarMensaje("No se encontró ningún paciente con ese dia.");
                }
            } else if (codigoBuscado != null) {
                vista.mostrarMensaje("Ingrese el dia a buscar.");
            }
        }
        if (e.getSource() == vista.getBtnModificar()) {
            String codigoModificar = vista.getTxtCodigo().getText().trim();
            if (codigoModificar != null && !codigoModificar.trim().isEmpty()) {
                codigoModificar = codigoModificar.trim();
                Cita nuevosDatos = capturarDatos();
                if (crud.modificar(codigoModificar, nuevosDatos)) {
                    vista.mostrarMensaje("Cita modificada con éxito.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Cita no encontrado o error en el archivo.");
                }
                
            } else if (codigoModificar != null) {
                vista.mostrarMensaje("Ingrese el codigo de cita a modificar.");
            }
        }
        if (e.getSource() == vista.getBtnEliminar()) {
            String codigoEliminar = javax.swing.JOptionPane.showInputDialog(
                null, 
                "Ingrese el codigo a eliminar:", 
                "Eliminación de Cita", 
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (codigoEliminar != null && !codigoEliminar.trim().isEmpty()) {
                codigoEliminar = codigoEliminar.trim();
                if (crud.eliminar(codigoEliminar)) {
                    vista.mostrarMensaje("Cita eliminada del archivo.");
                    vista.limpiarFormulario();
                } else {
                    vista.mostrarMensaje("Código no encontrado.");
                }
            } else if (codigoEliminar != null) {
                vista.mostrarMensaje("Ingrese el código a eliminar.");
            }
        }
        if (e.getSource() == vista.getBtnGuardar()) {

            ArrayList<Cita> listaParaEnviar = new ArrayList<>();
            Cita cit = capturarDatos();
            if (cit == null) return;
            listaParaEnviar.add(cit);
            
            if (crud.guardarLista(listaParaEnviar)) {
                vista.mostrarMensaje("Se ha guardado correctamente.");
                vista.limpiarFormulario();
                
            } else {
                vista.mostrarMensaje("Error al guardar.");
            }
        }
        
}
    
}
