package com.mycompany.sistema_de_programacion_de_citas;
public class Pacientes {
    private String Nombres;
    private String APELLIDOPATERNO;
    private String APELLIDOMATERNO;
    private String DNI;
    private String TELEFONO;
    private String DIRECCION;
    private String CORREO;

    
    public Pacientes(String Nombres, String APELLIDOPATERNO,String APELLIDOMATERNO,String DNI, String TELEFONO, String DIRECCION, String CORREO){
        this.Nombres = Nombres;
        this.APELLIDOPATERNO = APELLIDOPATERNO;
        this.APELLIDOMATERNO = APELLIDOMATERNO;
        this.DNI = DNI;
        this.TELEFONO = TELEFONO;
        this.DIRECCION = DIRECCION;
        this.CORREO = CORREO;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getAPELLIDOPATERNO() {
        return APELLIDOPATERNO;
    }

    public String getAPELLIDOMATERNO() {
        return APELLIDOMATERNO;
    }
    
    public String getDNI() {
        return DNI;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }
    
    public String getCORREO() {
        return CORREO;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setAPELLIDOPATERNO(String APELLIDOPATERNO) {
        this.APELLIDOPATERNO = APELLIDOPATERNO;
    }

    public void setAPELLIDOMATERNO(String APELLIDOMATERNO) {
        this.APELLIDOMATERNO = APELLIDOMATERNO;
    }
    
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }
    
    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }
}
