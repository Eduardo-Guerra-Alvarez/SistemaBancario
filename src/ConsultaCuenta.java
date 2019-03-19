
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ConsultaCuenta extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    int cargo;
    
    public ConsultaCuenta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void CargoBan(int a){
        cargo = a;
    }
    public int getCargo(){
        return cargo;
    }
    public void Consultar(int diaI, int mesI, int anioI, String tipo, int diaF, int mesF, int anioF) throws FileNotFoundException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.txt"));
        ArrayList<Cuentas> lista = new ArrayList();
        try{
            while(true){
               Cuentas c = new Cuentas();
                c.setIdCuenta(fileIn.readDouble());
                c.setIdCliente(fileIn.readDouble());
                c.setIdUsuario(fileIn.readDouble());
                c.setDia(fileIn.readInt());
                c.setMes(fileIn.readInt());
                c.setAnio(fileIn.readInt());
                c.setSaldo_actual(fileIn.readDouble());
                c.setContrato(fileIn.readInt());
                c.setTipo_cuenta(fileIn.readUTF());
                c.setDiaM(fileIn.readInt());
                c.setMesM(fileIn.readInt());
                c.setAnioM(fileIn.readInt());
                lista.add(c);
            }
        }catch(IOException ex){
            
        }
        String [] nombre = {"ID Cuenta","ID Cliente","ID Ussuario","Fecha", "Fecha Movimiento", "Saldo Actual", "Contrato","Tipo Cuenta"};
        String [][] data = new String[lista.size()][8];
        Cuentas temp;
        String fecha, fechaMo;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            if (temp.getDia() >= diaI && temp.getMes() >= mesI && temp.getAnio() >= anioI && temp.getTipo_cuenta().equals(tipo)
                    && temp.getDia() <= diaF && temp.getMes() <= mesF && temp.getAnio() <= anioF) {
                fecha = String.valueOf(temp.getDia())+"/"+String.valueOf(temp.getMes())+"/"+String.valueOf(temp.getAnio());
                fechaMo = String.valueOf(temp.getDiaM())+"/"+String.valueOf(temp.getMesM())+"/"+String.valueOf(temp.getAnioM());
                data[i][0] = String.valueOf(String.format("%.0f", temp.getIdCuenta()));
                data[i][1] = String.valueOf(String.format("%.0f", temp.getIdCliente()));
                data[i][2] = String.valueOf(String.format("%.0f", temp.getIdUsuario()));
                data[i][3] = fecha;
                data[i][4] = fechaMo;
                data[i][5] = String.valueOf(String.format("%.0f", temp.getSaldo_actual()));
                data[i][6] = String.valueOf(temp.getContrato());
                data[i][7] = temp.getTipo_cuenta();
            }
            
        }
        tlbMostrar.setModel(new DefaultTableModel(data,nombre));
    }
    public void ConsultarTipo(String tipo) throws FileNotFoundException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.txt"));
        ArrayList<Cuentas> lista = new ArrayList();
        try{
            while(true){
               Cuentas c = new Cuentas();
                c.setIdCuenta(fileIn.readDouble());
                c.setIdCliente(fileIn.readDouble());
                c.setIdUsuario(fileIn.readDouble());
                c.setDia(fileIn.readInt());
                c.setMes(fileIn.readInt());
                c.setAnio(fileIn.readInt());
                c.setSaldo_actual(fileIn.readDouble());
                c.setContrato(fileIn.readInt());
                c.setTipo_cuenta(fileIn.readUTF());
                c.setDiaM(fileIn.readInt());
                c.setMesM(fileIn.readInt());
                c.setAnioM(fileIn.readInt());
                lista.add(c);
            }
        }catch(IOException ex){
            
        }
        String [] nombre = {"ID Cuenta","ID Cliente","ID Ussuario","Fecha", "Fecha Movimiento", "Saldo Actual", "Contrato","Tipo Cuenta"};
        String [][] data = new String[lista.size()][8];
        Cuentas temp;
        String fecha, fechaMo;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            if (temp.getTipo_cuenta().equals(tipo)) {
                fecha = String.valueOf(temp.getDia())+"/"+String.valueOf(temp.getMes())+"/"+String.valueOf(temp.getAnio());
                fechaMo = String.valueOf(temp.getDiaM())+"/"+String.valueOf(temp.getMesM())+"/"+String.valueOf(temp.getAnioM());
                data[i][0] = String.valueOf(String.format("%.0f", temp.getIdCuenta()));
                data[i][1] = String.valueOf(String.format("%.0f", temp.getIdCliente()));
                data[i][2] = String.valueOf(String.format("%.0f", temp.getIdUsuario()));
                data[i][3] = fecha;
                data[i][4] = fechaMo;
                data[i][5] = String.valueOf(String.format("%.0f", temp.getSaldo_actual()));
                data[i][6] = String.valueOf(temp.getContrato());
                data[i][7] = temp.getTipo_cuenta();
            }
            
        }
        tlbMostrarTipo.setModel(new DefaultTableModel(data,nombre));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMesI = new javax.swing.JTextField();
        txtDiaI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAnioI = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMesF = new javax.swing.JTextField();
        txtDiaF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAnioF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbMostrar = new javax.swing.JTable();
        btnConsulta = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboTipo1 = new javax.swing.JComboBox<>();
        btnConsultaTipo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbMostrarTipo = new javax.swing.JTable();
        btnRegre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("Tipo de Cuenta");

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahorro", "Credito" }));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Inicio"));

        jLabel2.setText("Dia");

        jLabel3.setText("Mes");

        jLabel4.setText("Año");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMesI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnioI, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDiaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMesI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtAnioI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Fin"));

        jLabel5.setText("Dia");

        jLabel6.setText("Mes");

        jLabel7.setText("Año");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMesF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnioF, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMesF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtAnioF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tlbMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tlbMostrar);

        btnConsulta.setText("Consultar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(btnConsulta)
                .addGap(138, 138, 138))
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnConsulta)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta", jPanel1);

        jLabel8.setText("Tipo de Cuenta");

        cboTipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahorro", "Credito" }));

        btnConsultaTipo.setText("Consultar");
        btnConsultaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaTipoActionPerformed(evt);
            }
        });

        tlbMostrarTipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tlbMostrarTipo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnConsultaTipo)
                .addContainerGap(464, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta por tipo", jPanel2);

        btnRegre.setText("Regresar");
        btnRegre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(btnRegre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegre)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if ( getCargo() == 1 ) {
            MenuGerente mg = new MenuGerente();
            mg.setVisible(true);
            this.setVisible(false);
        }
        else if ( getCargo() == 0 ) {
            MenuCajero mc = new MenuCajero();
            mc.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        int dI,mI,aI,dF,mF,aF;
        String tipo;
        dI = Integer.parseInt(txtDiaI.getText());
        mI = Integer.parseInt(txtMesI.getText());
        aI = Integer.parseInt(txtAnioI.getText());
        dF = Integer.parseInt(txtDiaF.getText());
        mF = Integer.parseInt(txtMesF.getText());
        aF = Integer.parseInt(txtAnioF.getText());
        tipo = cboTipo.getSelectedItem().toString();
        try {
            Consultar(dI,mI,aI,tipo,dF,mF,aF);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ConsultaCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){//COMPARA QUE SE HAYA INGRESADO UN NUMERO Y NO UN CARACTER
            JOptionPane.showMessageDialog(this, "Solo números","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnRegreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegreActionPerformed
        if ( getCargo() == 1 ) {
            MenuGerente mg = new MenuGerente();
            mg.setVisible(true);
            this.setVisible(false);
        }
        else if ( getCargo() == 0 ) {
            MenuCajero mc = new MenuCajero();
            mc.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnRegreActionPerformed

    private void btnConsultaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaTipoActionPerformed
        String tipo;
        tipo = cboTipo1.getSelectedItem().toString();
        try {
            ConsultarTipo(tipo);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ConsultaCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConsultaTipoActionPerformed
    

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnConsultaTipo;
    private javax.swing.JButton btnRegre;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JComboBox<String> cboTipo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tlbMostrar;
    private javax.swing.JTable tlbMostrarTipo;
    private javax.swing.JTextField txtAnioF;
    private javax.swing.JTextField txtAnioI;
    private javax.swing.JTextField txtDiaF;
    private javax.swing.JTextField txtDiaI;
    private javax.swing.JTextField txtMesF;
    private javax.swing.JTextField txtMesI;
    // End of variables declaration//GEN-END:variables
}
