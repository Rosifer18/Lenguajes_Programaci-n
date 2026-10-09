package com.mycompany.sistema_de_programacion_de_citas;

public record Doctor(String codigo, String nombre, String cargo, String especialidad, String telefono, String disponibilidad, String horario) {
    
    public String aLineaTexto() {
        return codigo + ";" + nombre + ";" + cargo + ";" + especialidad + ";" + telefono + ";" + disponibilidad + ";"+ horario; 
    }
    
    public static Doctor desdeLineaTexto(String linea) {
        String[] d = linea.split(";");
        if (d.length == 8) {
            return new Doctor(d[0], d[1], d[2], d[3], d[4], d[5], d[6]);
        }
        return null;
    }
}
