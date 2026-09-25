package com.mycompany.sistema_de_programacion_de_citas;

public class Medicamento {
    // Atributos basicos solicitados
    String codigo;
    String nombre;
    String componente;
    String laboratorio;
    String stock;

    // Constructor para inicializar el medicamento
    public Medicamento(String codigo, String nombre, String componente, String laboratorio, String stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.componente = componente;
        this.laboratorio = laboratorio;
        this.stock = stock;
    }
}
