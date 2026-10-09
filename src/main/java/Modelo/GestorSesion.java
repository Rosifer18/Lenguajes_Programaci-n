/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_programacion_de_citas;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author Rodrigo
 */
public class GestorSesion {
    private static final String ARCHIVO_SESION = "sesion_actual.txt";

    // Guarda el nombre del usuario logueado en el archivo
    public static void guardarSesion(String usuario) {
        try (FileWriter writer = new FileWriter(ARCHIVO_SESION, false)) { // false sobreescribe el archivo
            writer.write(usuario);
        } catch (IOException e) {
            System.err.println("Error al guardar la sesión: " + e.getMessage());
        }
    }

    // Lee y retorna el usuario que inició sesión
    public static String obtenerUsuarioLogueado() {
        File file = new File(ARCHIVO_SESION);
        if (!file.exists()) {
            return null;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.readLine();
        } catch (IOException e) {
            System.err.println("Error al leer la sesión: " + e.getMessage());
            return null;
        }
    }
}
