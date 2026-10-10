package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Paciente;
import java.io.*;
import java.util.ArrayList;
public class CRUDPacientes {
    private final String rutaArchivo = "pacientes.txt";

    public boolean guardar(Paciente pac) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
         
            String linea = pac.nombres() + ";" + pac.apellidoPaterno() + ";" + pac.apellidoMaterno() + ";" + pac.fechaNacimiento() + ";" + pac.dni() + ";" + pac.telefono() +  ";" + pac.direccion() + ";" + pac.foto() + ";" + pac.estadoCivil() + ";" + pac.genero() + ";" + pac.correo();
            pw.println(linea);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public Paciente buscarPorDni(String dniBuscado) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 11 && datos[4].equalsIgnoreCase(dniBuscado)) {
                    return new Paciente(datos[0], datos[1], datos[2], datos[3], datos[4],datos[5],datos[6],datos[7],datos[8],datos[9],datos[10]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    public boolean modificar(String dniModificar, Paciente nuevoDoc) {
        File archivoOriginal = new File(rutaArchivo);
        if (!archivoOriginal.exists()) return false;

        ArrayList<String> lineasGuardar = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 11 && datos[4].equalsIgnoreCase(dniModificar)) {
                    String nuevaLinea = nuevoDoc.nombres() + ";" + nuevoDoc.apellidoPaterno() + ";" + nuevoDoc.apellidoMaterno() + ";" + nuevoDoc.fechaNacimiento() + ";" + nuevoDoc.dni() + ";" + nuevoDoc.telefono() + ";" + nuevoDoc.direccion()+ ";" + nuevoDoc.foto()  + ";" + nuevoDoc.estadoCivil()  + ";" + nuevoDoc.genero()   + ";" + nuevoDoc.correo();
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

    public boolean eliminar(String dniEliminar) {
        File archivoOriginal = new File(rutaArchivo);
        if (!archivoOriginal.exists()) return false;

        ArrayList<String> lineasGuardar = new ArrayList<>();
        boolean eliminado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 11 && datos[5].equalsIgnoreCase(dniEliminar)) {
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

    public boolean guardarLista(ArrayList<Paciente> listaPacientes) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            for (Paciente pac : listaPacientes) {
                String linea = pac.nombres() + ";" + pac.apellidoPaterno() + ";" + pac.apellidoMaterno() + ";" + pac.fechaNacimiento() + ";" + pac.dni() + ";" + pac.telefono() + ";" + pac.direccion()  + ";" + pac.foto() + ";" + pac.estadoCivil() + ";" + pac.genero() + ";" + pac.correo();
                pw.println(linea);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}