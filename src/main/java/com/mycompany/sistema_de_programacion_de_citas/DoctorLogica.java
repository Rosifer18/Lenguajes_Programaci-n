package com.mycompany.sistema_de_programacion_de_citas;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class DoctorLogica {
    private final String RUTA_ARCHIVO = "CargoEspecialidad.txt";

    
    public List<Doctor> obtenerTodos() {
        List<Doctor> lista = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO);
        
        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    Doctor doctor = Doctor.desdeLineaTexto(linea);
                    if (doctor != null) {
                        lista.add(doctor);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    
    public boolean agregarDoctor(Doctor doctor) {
        if (buscarPorCodigo(doctor.codigo()) != null) {
            return false; 
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            bw.write(doctor.aLineaTexto());
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public Doctor buscarPorCodigo(String codigo) {
        for (Doctor d : obtenerTodos()) {
            if (d.codigo().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }

    
    public boolean modificarDoctor(Doctor doctorActualizado) {
        List<Doctor> lista = obtenerTodos();
        boolean encontrado = false;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).codigo().equalsIgnoreCase(doctorActualizado.codigo())) {
                lista.set(i, doctorActualizado);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            guardarListaCompleta(lista);
        }
        return encontrado;
    }

    
    public boolean eliminarDoctor(String codigo) {
        List<Doctor> lista = obtenerTodos();
        boolean eliminado = lista.removeIf(d -> d.codigo().equalsIgnoreCase(codigo));

        if (eliminado) {
            guardarListaCompleta(lista);
        }
        return eliminado;
    }

   
    private void guardarListaCompleta(List<Doctor> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, false))) {
            for (Doctor d : lista) {
                bw.write(d.aLineaTexto());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
