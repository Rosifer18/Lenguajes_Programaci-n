package com.mycompany.sistema_de_programacion_de_citas;
public class Pacientes {
    private String codigo;
    private String nombre;
    private String DNI;
    private String edad;
    private String telefono;
    
    public Pacientes(String codigo, String nombre,String DNI,String edad, String telefono){
     this.codigo = codigo;
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getcodigo() {
        return codigo;
    }

    public String getnombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getedad() {
        return edad;
    }

    public String gettelefono() {
        return telefono;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setedad(String edad) {
        this.edad = edad;
    }

    public void settelefono(String telefono) {
        this.telefono = telefono;
    }
   
}
