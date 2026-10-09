package com.mycompany.sistema_de_programacion_de_citas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CRUDPacientes {

    private String archivo = "pacientes.txt";

    // 1. CREAR PACIENTE
    public void crear(Pacientes p) {
        try (FileWriter escritor = new FileWriter(archivo, true)) {
            escritor.write(
                    p.getNombres() + ";" +
                    p.getAPELLIDOPATERNO() + ";" +
                    p.getAPELLIDOMATERNO() + ";" +
                    p.getDNI() + ";" +
                    p.getTELEFONO() + ";" +
                    p.getDIRECCION() + ";" +
                    p.getCORREO() + ";" 
            );
            escritor.write("\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el paciente: " + e.getMessage());
        }
    }

    // 2. BUSCAR PACIENTE POR CÓDIGO
    public Pacientes buscar(String codigo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 5 && datos[0].equals(codigo)) {
                    return new Pacientes(
                            datos[0],
                            datos[1],
                            datos[2],
                            datos[3],
                            datos[4],
                            datos[5],
                            datos[6]
                    );
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar el paciente: " + e.getMessage());
        }
        return null;
    }

    // 3. MODIFICAR PACIENTE
    public void modificar(Pacientes pacienteModificado) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length > 0 && datos[0].equals(pacienteModificado.getDNI())) {
                    String lineaNueva = pacienteModificado.getNombres() + ";" +
                                        pacienteModificado.getAPELLIDOPATERNO() + ";" +
                                        pacienteModificado.getAPELLIDOMATERNO() + ";" +
                                        pacienteModificado.getDNI() + ";" +
                                        pacienteModificado.getTELEFONO() + ";" +
                                        pacienteModificado.getDIRECCION() + ";" +
                                        pacienteModificado.getCORREO();
                    lineas.add(lineaNueva);
                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo para modificar: " + e.getMessage());
        }
        guardarLineas(lineas);
    }

    // 4. ELIMINAR PACIENTE
    public void eliminar(String codigo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length > 0 && !datos[0].equals(codigo)) {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo para eliminar: " + e.getMessage());
        }
        guardarLineas(lineas);
    }
        private void guardarLineas(List<String> lineas) {
            try (FileWriter escritor = new FileWriter(archivo, false)) {
    for (String l : lineas) {
        escritor.write(l + "\n");
    }
            } catch (IOException e) {
                System.out.println("ERROR AL GUARDAR LOS CAMBIOS: ");
            }
        }
}