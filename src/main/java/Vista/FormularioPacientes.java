package com.mycompany.sistema_de_programacion_de_citas;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DISEÑOPACIENTES extends javax.swing.JFrame {
   
java.util.List<Pacientes> listaPacientes = new java.util.ArrayList<>();
    private String rutaFoto = "";
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DISEÑOPACIENTES.class.getName());

    public DISEÑOPACIENTES() {
        initComponents();
        txtFECHAHORA.setEditable(false);
        cmbNUMEROCITA.setEditable(false);
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String textofecha = ahora.format(FECHA);
        txtFECHAHORA.setText(textofecha);
        
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRegistroPacientes = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAPELLIDOPATERNO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAPELLIDOMATERNO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtTELEFONO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDIRECCION = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox<>();
        rbMasculino = new javax.swing.JRadioButton();
        rbFemenino = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        btnGUARDAR = new javax.swing.JButton();
        btnMODIFICAR = new javax.swing.JButton();
        btnLIMPIAR = new javax.swing.JButton();
        btnBUSCAR = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCORREO = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtDIAGNOSTICO = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtINDICACIONES = new javax.swing.JTextField();
        txtMEDICAMENTOS = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbCLASIFICACION = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        txtFECHAHORA = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnEDITARINFORMACION = new javax.swing.JButton();
        btnGUARDARHISTORIAL = new javax.swing.JButton();
        cmbNUMEROCITA = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("*NOMBRES:");

        jLabel2.setText("*APELLIDOS");

        txtAPELLIDOPATERNO.addActionListener(this::txtAPELLIDOPATERNOActionPerformed);

        jLabel3.setText("APELLIDO PATERNO:");

        jLabel4.setText("APELLIDO MATERNO:");

        jLabel5.setText("FECHA DE NACIMIENTO:");

        jLabel6.setText("TELÉFONO:");

        jLabel7.setText("DIRECCIÓN:");

        jLabel8.setText("ESTADO CIVIL:");

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Soltero(a)", "Casado(a)", "Viudo(a)", "Divorciado(a)" }));
        cmbEstadoCivil.addActionListener(this::cmbEstadoCivilActionPerformed);

        rbMasculino.setText("Masculino");

        rbFemenino.setText("Femenino");
        rbFemenino.addActionListener(this::rbFemeninoActionPerformed);

        jLabel9.setText("GÉNERO DEL PACIENTE:");

        btnGUARDAR.setText("GUARDAR");
        btnGUARDAR.addActionListener(this::btnGUARDARActionPerformed);

        btnMODIFICAR.setText("MODIFICAR");
        btnMODIFICAR.addActionListener(this::btnMODIFICARActionPerformed);

        btnLIMPIAR.setText("LIMPIAR");
        btnLIMPIAR.addActionListener(this::btnLIMPIARActionPerformed);

        btnBUSCAR.setText("BUSCAR");
        btnBUSCAR.addActionListener(this::btnBUSCARActionPerformed);

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCargarFoto.setText("CARGAR FOTO");
        btnCargarFoto.addActionListener(this::btnCargarFotoActionPerformed);

        jLabel10.setText("CORREO ELECTRÓNICO:");

        jLabel11.setText("DNI:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGUARDAR)
                        .addGap(36, 36, 36)
                        .addComponent(btnMODIFICAR)
                        .addGap(41, 41, 41)
                        .addComponent(btnLIMPIAR))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAPELLIDOMATERNO)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAPELLIDOPATERNO)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDIRECCION)
                            .addComponent(txtTELEFONO)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNI))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnCargarFoto))
                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(btnBUSCAR))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCORREO, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAPELLIDOPATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAPELLIDOMATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargarFoto)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel11)
                                .addGap(9, 9, 9)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbFemenino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCORREO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(txtDIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGUARDAR)
                    .addComponent(btnMODIFICAR)
                    .addComponent(btnLIMPIAR)
                    .addComponent(btnBUSCAR))
                .addGap(16, 16, 16))
        );

        PanelRegistroPacientes.addTab("DATOS PERSONALES", jPanel1);

        jLabel15.setText("*DIAGNÓSTICO DEL PACIENTE:");

        txtDIAGNOSTICO.addActionListener(this::txtDIAGNOSTICOActionPerformed);

        jLabel16.setText("INDICACIONES");

        jLabel17.setText("*RECETA MÉDICA");

        jLabel18.setText("MEDICAMENTOS:");

        jLabel19.setText("CLASIFICACIÓN DE GRAVEDAD:");

        cmbCLASIFICACION.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "ESTABLE", "GRAVE", "CRÍTICO" }));

        jLabel20.setText("FECHA Y HORA DE ATENCIÓN: ");

        txtFECHAHORA.addActionListener(this::txtFECHAHORAActionPerformed);

        jLabel21.setText("NÚMERO DE CITAS:");

        btnEDITARINFORMACION.setText("EDITAR INFORMACIÓN");

        btnGUARDARHISTORIAL.setText("GUARDAR");

        cmbNUMEROCITA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNUMEROCITA.addItemListener(this::cmbNUMEROCITAItemStateChanged);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(txtMEDICAMENTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtINDICACIONES, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbCLASIFICACION, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(126, 126, 126)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnEDITARINFORMACION)
                        .addGap(37, 37, 37)
                        .addComponent(btnGUARDARHISTORIAL))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtFECHAHORA, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtDIAGNOSTICO, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNUMEROCITA, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNUMEROCITA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFECHAHORA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDIAGNOSTICO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMEDICAMENTOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtINDICACIONES, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCLASIFICACION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEDITARINFORMACION)
                    .addComponent(btnGUARDARHISTORIAL))
                .addGap(32, 32, 32))
        );

        PanelRegistroPacientes.addTab("HISTORIAL", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "FECHA", "HORA", "MEDICO", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel22.setText("RESUMEN DE CITAS");

        jLabel23.setText("TOTAL DE CITAS: ");

        jLabel24.setText("ASISTIDAS: ");

        jLabel25.setText("PENDIENTES:");

        jLabel26.setText("REGISTRO HISTÓRICO DE CITAS:");

        jButton9.setText("CANCELAR CITA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(jLabel24)
                            .addGap(80, 80, 80)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26))
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(28, 28, 28)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(29, 29, 29))
        );

        PanelRegistroPacientes.addTab("CITAS", jPanel3);

        getContentPane().add(PanelRegistroPacientes, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAPELLIDOPATERNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPELLIDOPATERNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPELLIDOPATERNOActionPerformed

    private void txtDIAGNOSTICOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDIAGNOSTICOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDIAGNOSTICOActionPerformed

    private void cmbEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoCivilActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
  JFileChooser fileChooser = new JFileChooser();
  FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes(*. jpg, *.png)","jpg","png");
  fileChooser.setFileFilter(filtro);
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void btnGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGUARDARActionPerformed
      if(txtNombres.getText().trim().isEmpty()){
          javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del paciente.");
          txtNombres.requestFocus();
          return;
      }
      if(txtAPELLIDOPATERNO.getText().trim().isEmpty()){
          javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar el apellido paterno del paciente.");
          txtAPELLIDOPATERNO.requestFocus();
          return;
      }
      if (txtAPELLIDOMATERNO.getText(). trim().isEmpty()){
          javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar el apellido materno del paciente");
          txtAPELLIDOMATERNO.requestFocus();
          return;
      }
    if(jDateChooser1.getDate() == null){
        javax.swing.JOptionPane.showMessageDialog (this, "Debe seleccionar la fecha de nacimiento.");
        jDateChooser1.requestFocus();
        return;
    }
    if(txtDNI.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar el DNI del paciente");
        txtDNI.requestFocus();
        return;
    }
    if(txtTELEFONO.getText().trim().isEmpty()){
        javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el número del teléfono del paciente.");
        txtTELEFONO.requestFocus();
        return;
    }
    if(txtDIRECCION.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la dirección del paciente.");
        txtDIRECCION.requestFocus();
        return;       
    }
    if(cmbEstadoCivil.getSelectedIndex()== 0){
        javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un estado civil.");
        cmbEstadoCivil.requestFocus();
    return;
    }
    if(!rbFemenino.isSelected() && !rbMasculino.isSelected()) {
        javax.swing.JOptionPane.showMessageDialog (this, "Debe seleccionar el género del paciente.");
        return;
      }
    String genero = "";
    if(rbFemenino.isSelected()) {
        genero = "Femenino";
    }else if(rbMasculino.isSelected()) {
             genero = "Masculino";
    }
    if(txtCORREO.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog (this,"Debe ingresar el correo electrónico del paciente.");
        txtCORREO.requestFocus();
    return;
    }
    javax.swing.JOptionPane.showMessageDialog(this, "¡Paciente registrado con éxito! \nGénero seleccionado: " + genero);
    
    
    }//GEN-LAST:event_btnGUARDARActionPerformed

    private void rbFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemeninoActionPerformed

    }//GEN-LAST:event_rbFemeninoActionPerformed

    private void btnLIMPIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIMPIARActionPerformed
    txtNombres.setText("");
    txtAPELLIDOPATERNO.setText("");
    txtAPELLIDOMATERNO.setText("");
    jDateChooser1.setDate(null);
    txtDNI.setText("");
    txtTELEFONO.setText("");
    txtDIRECCION.setText("");
    cmbEstadoCivil.setSelectedIndex(0);
    rbFemenino.setSelected(false);
    rbMasculino.setSelected(false);
    txtCORREO.setText("");
    
    txtDNI.requestFocus();
    }//GEN-LAST:event_btnLIMPIARActionPerformed

    private void btnBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCARActionPerformed
    String dniBuscado = javax.swing.JOptionPane.showInputDialog(
        null, 
        "Ingrese solo el DNI para buscar:", 
        "Búsqueda de Paciente", 
        javax.swing.JOptionPane.QUESTION_MESSAGE
    );

    if (dniBuscado == null) return;

    dniBuscado = dniBuscado.trim();

    if (dniBuscado.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(null, "Debe ingresar un DNI.");
        return;
    }

    txtDNI.setText(dniBuscado);

    boolean encontrado = false;

    for (Pacientes p : listaPacientes) {
        if (p.getDNI().equals(dniBuscado)) {
            txtNombres.setText(p.getNombres());
            txtAPELLIDOPATERNO.setText(p.getAPELLIDOPATERNO());
            txtAPELLIDOMATERNO.setText(p.getAPELLIDOMATERNO());
            txtTELEFONO.setText(p.getTELEFONO());
            txtDIRECCION.setText(p.getDIRECCION());
            txtCORREO.setText(p.getCORREO());

            encontrado = true;
            javax.swing.JOptionPane.showMessageDialog(null, "Paciente encontrado.");
            break;
        }
    }

    if (!encontrado) {
        javax.swing.JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con el DNI: " + dniBuscado);
    }
   
    }//GEN-LAST:event_btnBUSCARActionPerformed

    private void btnMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMODIFICARActionPerformed
    String DNIBuscado = txtDNI.getText().trim();
    if (DNIBuscado.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(null,"Primero busque o ingrese el DNI del paciente.");
        return;
    }
    boolean modificado = false;
    for (Pacientes p : listaPacientes) {
        if (p.getDNI().equals(DNIBuscado)) {
            p.setNombres(txtNombres.getText().trim());
            p.setAPELLIDOPATERNO(txtAPELLIDOPATERNO.getText().trim());
            p.setAPELLIDOMATERNO(txtAPELLIDOMATERNO.getText().trim());
            p.setTELEFONO(txtTELEFONO.getText().trim());
            p.setDIRECCION(txtDIRECCION.getText().trim());
            p.setCORREO(txtCORREO.getText().trim());
            
            modificado = true;
            javax.swing.JOptionPane.showMessageDialog(null,"Datos del paciente actualizados con éxito.");
            break; 
        }
    }
    if (!modificado) {
        javax.swing.JOptionPane.showMessageDialog(null,"No se encontró el paciente para modificar");
    }
    }//GEN-LAST:event_btnMODIFICARActionPerformed

    private void txtFECHAHORAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFECHAHORAActionPerformed

    }//GEN-LAST:event_txtFECHAHORAActionPerformed

    private void cmbNUMEROCITAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNUMEROCITAItemStateChanged
   if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {     
        String citaSeleccionada = cmbNUMEROCITA.getSelectedItem().toString();
        if (citaSeleccionada.equals("Seleccione") || citaSeleccionada.equals("Item 1")) {
            txtFECHAHORA.setText("");
            txtDIAGNOSTICO.setText("");
            txtMEDICAMENTOS.setText("");
            txtINDICACIONES.setText("");
            cmbCLASIFICACION.setSelectedItem(0);
            return;
            
        }
        boolean encontrado = false;
        if(!encontrado) {
             txtFECHAHORA.setText("");
            txtDIAGNOSTICO.setText("");
            txtMEDICAMENTOS.setText("");
            txtINDICACIONES.setText("");
        }
    }
    }//GEN-LAST:event_cmbNUMEROCITAItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PanelRegistroPacientes;
    private javax.swing.JButton btnBUSCAR;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnEDITARINFORMACION;
    private javax.swing.JButton btnGUARDAR;
    private javax.swing.JButton btnGUARDARHISTORIAL;
    private javax.swing.JButton btnLIMPIAR;
    private javax.swing.JButton btnMODIFICAR;
    private javax.swing.JComboBox<String> cmbCLASIFICACION;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbNUMEROCITA;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField txtAPELLIDOMATERNO;
    private javax.swing.JTextField txtAPELLIDOPATERNO;
    private javax.swing.JTextField txtCORREO;
    private javax.swing.JTextField txtDIAGNOSTICO;
    private javax.swing.JTextField txtDIRECCION;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtFECHAHORA;
    private javax.swing.JTextField txtINDICACIONES;
    private javax.swing.JTextField txtMEDICAMENTOS;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTELEFONO;
    // End of variables declaration//GEN-END:variables
}