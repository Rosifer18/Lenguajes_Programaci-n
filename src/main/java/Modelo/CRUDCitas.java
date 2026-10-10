package Modelo;
import Modelo.Cita;
import java.io.*;
import java.util.ArrayList;

public class CRUDCitas {
    private final String rutaArchivo = "citas.txt";


    public Cita buscarPorCodigo(String codigoBuscado) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 8 && datos[0].equalsIgnoreCase(codigoBuscado)) {
                    return new Cita(datos[0], datos[1], datos[2], datos[3], datos[4],datos[5],datos[6],datos[7]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    public boolean modificar(String codigoModificar, Cita nuevoDoc) {
        File archivoOriginal = new File(rutaArchivo);
        if (!archivoOriginal.exists()) return false;

        ArrayList<String> lineasGuardar = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 8 && datos[0].equalsIgnoreCase(codigoModificar)) {
                    String nuevaLinea = nuevoDoc.codigo() + ";" + nuevoDoc.paciente() + ";" + nuevoDoc.doctor() + ";" + nuevoDoc.medicamento() + ";" + nuevoDoc.dia() + ";" + nuevoDoc.hora() + ";" + nuevoDoc.diagnostico() +";" + nuevoDoc.gravedad();
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
                if (datos.length == 8 && datos[0].equalsIgnoreCase(codigoEliminar)) {
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

    public boolean guardarLista(ArrayList<Cita> listaCitas) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            for (Cita cit : listaCitas) {
                String linea = cit.codigo() + ";" + cit.paciente() + ";" + cit.doctor() + ";" + cit.medicamento() + ";" + cit.dia() + ";" + cit.hora() + ";" + cit.diagnostico() + ";" + cit.gravedad();
                pw.println(linea);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
