package Modelo;
import Modelo.Doctor;
import java.io.*;
import java.util.ArrayList;

public class CRUDDoctores {
    private final String rutaArchivo = "doctores.txt";

    public boolean guardar(Doctor doc) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
         
            String linea = doc.codigo() + ";" + doc.nombre() + ";" + doc.cargo() + ";" + doc.especialidad() + ";" + doc.disponibilidad() + ";" + doc.horario() + ";" + doc.telefono();
            pw.println(linea);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public Doctor buscarPorCodigo(String codigoBuscado) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[0].equalsIgnoreCase(codigoBuscado)) {
                    return new Doctor(datos[0], datos[1], datos[2], datos[3], datos[4],datos[5],datos[6]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    public boolean modificar(String codigoModificar, Doctor nuevoDoc) {
        File archivoOriginal = new File(rutaArchivo);
        if (!archivoOriginal.exists()) return false;

        ArrayList<String> lineasGuardar = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[0].equalsIgnoreCase(codigoModificar)) {
                    String nuevaLinea = nuevoDoc.codigo() + ";" + nuevoDoc.nombre() + ";" + nuevoDoc.cargo() + ";" + nuevoDoc.especialidad() + ";" + nuevoDoc.disponibilidad() + ";" + nuevoDoc.horario() + ";" + nuevoDoc.telefono();
                    lineasGuardar.add(nuevaLinea);
                    modificado = true;
                } else {
                    lineasGuardar.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al modificar: " + e.getMessage());
            return false;
        }

        if (modificado) {
            try (FileWriter fw = new FileWriter(archivoOriginal, false)) {
                for (String l : lineasGuardar) {
                    fw.write(l);
                    fw.write(System.lineSeparator());
                }
            } catch (IOException e) {
                return false;
            }
        }
        return modificado;
    }

    public boolean eliminar(String codigoEliminar) {
        File archivoOriginal = new File(rutaArchivo);
        if (!archivoOriginal.exists()) return false;

        ArrayList<String> lineasGuardar = new ArrayList<>();
        boolean eliminado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[0].equalsIgnoreCase(codigoEliminar)) {
                    eliminado = true;
                } else {
                    lineasGuardar.add(linea);
                }
            }
        } catch (IOException e) {
            return false;
        }

        if (eliminado) {
            try (FileWriter fw = new FileWriter(archivoOriginal, false)) {
                for (String l : lineasGuardar) {
                    fw.write(l);
                    fw.write(System.lineSeparator());
                }
            } catch (IOException e) {
                return false;
            }
        }
        return eliminado;
    }

    public boolean guardarLista(ArrayList<Doctor> listaDoctors) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            for (Doctor doc : listaDoctors) {
                String linea = doc.codigo() + ";" + doc.nombre() + ";" + doc.cargo() + ";" + doc.especialidad() + ";" + doc.disponibilidad() + ";" + doc.horario() + ";" + doc.telefono();
                pw.println(linea);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
