
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AgregarCuenta extends javax.swing.JFrame {
    DataOutputStream fileOut = null;
    DataInputStream fileIn = null;
    Cuentas c = new Cuentas();
    Usuarios u = new Usuarios();
    int cargo;
    double id;
    boolean encontrado = false;
    public AgregarCuenta() throws FileNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarID();
    }
    public void CargoBan(int cargo){
        this.cargo = cargo;
    }
    public int getCargo(){
        return cargo;
    }

    public void MostrarID() throws FileNotFoundException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.txt"));
        txtIDCuenta.setText(String.valueOf(1));
        txtContrato.setText(String.valueOf(1));
        try{
            while(true){
                c.setIdCuenta(fileIn.readDouble());
                c.setIdCliente(fileIn.readDouble());
                c.setIdUsuario(fileIn.readDouble());
                c.setDia(fileIn.readInt());
                c.setMes(fileIn.readInt());
                c.setAnio(fileIn.readInt());
                c.setSaldo_actual(fileIn.readDouble());
                c.setContrato(fileIn.readInt());
                c.setTipo_cuenta(fileIn.readUTF());
                txtIDCuenta.setText(String.valueOf(String.format("%.0f",c.getIdCuenta()+1)));
                txtContrato.setText(String.valueOf(c.getContrato()+1));
            }
        }catch (IOException ex){
            
        }
    }
    public void Agregar(Double usu) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/usuario.txt"));
        encontrado = false;
        try{
            while(true){
                u.setIdUsuario(fileIn.readDouble());
                u.setNombre(fileIn.readUTF());
                u.setApellido(fileIn.readUTF());
                u.setDireccion(fileIn.readUTF());
                u.setTelefono(fileIn.readDouble());
                u.setCargo_bancario(fileIn.readUTF());
                u.setCiudad(fileIn.readUTF());
                u.setEstado(fileIn.readUTF());
                u.setPais(fileIn.readUTF());
                u.setSexo(fileIn.readUTF());
                
                if (u.getIdUsuario() == usu){
                    encontrado = true;
                }
            }
        }catch (IOException ex){
            
        }
        if (encontrado == true) {
            fileOut = new DataOutputStream(new FileOutputStream("d:/txt/cuenta.txt",true));
            c.setIdCliente(Double.parseDouble(txtIDc.getText()));
            c.setIdUsuario(Double.parseDouble(txtIDUsuario.getText()));
            c.setDia(Integer.parseInt(txtDia.getText()));
            c.setMes(Integer.parseInt(txtMes.getText()));
            c.setAnio(Integer.parseInt(txtAnio.getText()));
            c.setSaldo_actual(Double.parseDouble(txtSaldo.getText()));
            c.setTipo_cuenta(cboTipo.getSelectedItem().toString());

            if (c.getSaldo_actual() >= 1000) {
                if (c.getDia() <= 31 && c.getMes() <= 12 && (c.getAnio() < 2030 && c.getAnio() >= 2019)) {
                    c.setIdCuenta(c.getIdCuenta()+1);
                    c.setContrato(c.getContrato()+1);
                    fileOut.writeDouble(c.getIdCuenta());
                    fileOut.writeDouble(c.getIdCliente());
                    fileOut.writeDouble(c.getIdUsuario());
                    fileOut.writeInt(c.getDia());
                    fileOut.writeInt(c.getMes());
                    fileOut.writeInt(c.getAnio());
                    fileOut.writeDouble(c.getSaldo_actual());
                    fileOut.writeInt(c.getContrato());
                    fileOut.writeUTF(c.getTipo_cuenta());
                    fileOut.close();
                    JOptionPane.showMessageDialog(null, "Agregado con exito");
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
                }
                else {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Saldo debe ser mayor a 1000");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "EL Usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        txtIDUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        cboTipo = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        txtContrato = new javax.swing.JLabel();
        txtIDc = new javax.swing.JLabel();
        txtIDCuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Cuentas");
        setUndecorated(true);

        jLabel19.setText("ID Cuenta");

        jLabel20.setText("ID Cliente");

        jLabel21.setText("ID Usuario");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Apertura"));

        jLabel23.setText("Dia");

        jLabel24.setText("Mes");

        jLabel1.setText("Año");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel2.setText("Saldo Inicial $");

        jLabel3.setText("Contrato");

        jLabel4.setText("Tipo de Cuenta");

        txtSaldo.setText("1000");

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahorro", "Credito" }));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtContrato.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIDc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIDCuenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(txtIDc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel2)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIDCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel3))
                    .addComponent(txtIDc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnAgregar)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            Agregar(Double.parseDouble(txtIDUsuario.getText()));
        } catch (IOException ex) {
            Logger.getLogger(AgregarCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){//COMPARA QUE SE HAYA INGRESADO UN NUMERO Y NO UN CARACTER
            JOptionPane.showMessageDialog(this, "Solo números","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarCuenta().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AgregarCuenta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JLabel txtContrato;
    private javax.swing.JTextField txtDia;
    private javax.swing.JLabel txtIDCuenta;
    private javax.swing.JTextField txtIDUsuario;
    public javax.swing.JLabel txtIDc;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
