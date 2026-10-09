package com.mycompany.sistema_de_programacion_de_citas;

import java.io.*;
import java.util.ArrayList;

public class CRUDMedicamentos {
    private final String rutaArchivo = "medicamentos.txt";

    public boolean guardar(Medicamento med) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
         
            String linea = med.codigo() + ";" + med.nombre() + ";" + med.componente() + ";" + med.laboratorio() + ";" + med.stock();
            pw.println(linea);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public Medicamento buscarPorCodigo(String codigoBuscado) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 5 && datos[0].equalsIgnoreCase(codigoBuscado)) {
                    return new Medicamento(datos[0], datos[1], datos[2], datos[3], datos[4]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    public boolean modificar(String codigoModificar, Medicamento nuevoMed) {
        File archivoOriginal = new File(rutaArchivo);
        if (!archivoOriginal.exists()) return false;

        ArrayList<String> lineasGuardar = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 5 && datos[0].equalsIgnoreCase(codigoModificar)) {
                    String nuevaLinea = nuevoMed.codigo() + ";" + nuevoMed.nombre() + ";" + nuevoMed.componente() + ";" + nuevoMed.laboratorio() + ";" + nuevoMed.stock();
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
                if (datos.length == 5 && datos[0].equalsIgnoreCase(codigoEliminar)) {
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

    public boolean guardarLista(ArrayList<Medicamento> listaMedicamentos) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            for (Medicamento med : listaMedicamentos) {
                String linea = med.codigo() + ";" + med.nombre() + ";" + med.componente() + ";" + med.laboratorio() + ";" + med.stock();
                pw.println(linea);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}