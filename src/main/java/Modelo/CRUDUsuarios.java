package Modelo;
import Modelo.Usuario;
import java.io.*;
import java.util.ArrayList;
public class CRUDUsuarios {
    private final String rutaArchivo = "usuarios.txt";

    public boolean guardar(Usuario usu) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
         
            String linea = usu.nombre() + ";" + usu.contraseña();
            pw.println(linea);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public Usuario buscarPorNombre(String nombreBuscado) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 2 && datos[0].equalsIgnoreCase(nombreBuscado)) {
                    return new Usuario(datos[0], datos[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    public boolean modificar(String nombreModificar, Usuario nuevoUsu) {
        File archivoOriginal = new File(rutaArchivo);
        if (!archivoOriginal.exists()) return false;

        ArrayList<String> lineasGuardar = new ArrayList<>();
        boolean modificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 2 && datos[0].equalsIgnoreCase(nombreModificar)) {
                    String nuevaLinea = nuevoUsu.nombre() + ";" + nuevoUsu.contraseña();
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

    public boolean eliminar(String nombreEliminar) {
        File archivoOriginal = new File(rutaArchivo);
        if (!archivoOriginal.exists()) return false;

        ArrayList<String> lineasGuardar = new ArrayList<>();
        boolean eliminado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 2 && datos[0].equalsIgnoreCase(nombreEliminar)) {
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

    public boolean guardarLista(ArrayList<Usuario> listaUsuarios) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            for (Usuario usu : listaUsuarios) {
                String linea = usu.nombre() + ";" + usu.contraseña();
                pw.println(linea);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
