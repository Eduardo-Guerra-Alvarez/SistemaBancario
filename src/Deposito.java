
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Deposito extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    DataOutputStream fileOut = null;
    boolean encontrado = false;
    boolean aceptado;
    int cargo;
    
    public Deposito() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void Deposito(double id) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.bin"));
        ArrayList<Cuentas> lista = new ArrayList();
        encontrado = false;
        aceptado = false;
        try{
            while(true){
                Cuentas cli = new Cuentas();
                cli.setIdCuenta(fileIn.readDouble());
                cli.setIdCliente(fileIn.readDouble());
                cli.setIdUsuario(fileIn.readDouble());
                cli.setDia(fileIn.readInt());
                cli.setMes(fileIn.readInt());
                cli.setAnio(fileIn.readInt());
                cli.setSaldo_actual(fileIn.readDouble());
                cli.setContrato(fileIn.readInt());
                cli.setTipo_cuenta(fileIn.readUTF());
                cli.setDiaM(fileIn.readInt());
                cli.setMesM(fileIn.readInt());
                cli.setAnioM(fileIn.readInt());
                
                lista.add(cli);
            }
        } catch(IOException ex){
            
        }
        Cuentas temp;
        int monto, deposito;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            if (temp.getIdCuenta() == id) {
                monto = Integer.parseInt(JOptionPane.showInputDialog(null, "Saldo $:"+ temp.getSaldo_actual()+"\nMonto a Depositar: "));
                temp.setSaldo_actual(temp.getSaldo_actual()+monto);
                txtMonto.setText(String.valueOf(String.format("%.0f", temp.getSaldo_actual())));
                temp.setDiaM(Integer.parseInt(txtDia.getText()));
                temp.setMesM(Integer.parseInt(txtMes.getText()));
                temp.setAnioM(Integer.parseInt(txtAnio.getText()));
                if (temp.getDia() <= 31 && temp.getMes() <= 12 && (temp.getAnio() < 2030 && temp.getAnio() >= 2019)) {
                    if (temp.getMes() == 2 && temp.getDia() >= 28) {
                        JOptionPane.showMessageDialog(this, "Febrero tiene 28 dias","ERROR",JOptionPane.ERROR_MESSAGE);
                    } else {
                        aceptado = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto");
                }
                encontrado = true;
            }
        }
        if(encontrado == true && aceptado == true){
            Cuentas aux = new Cuentas();
            fileOut = new DataOutputStream(new FileOutputStream("d:/txt/cuenta.bin"));
            for (int i = 0; i < lista.size(); i++) {
                aux = lista.get(i);
               
                fileOut.writeDouble(aux.getIdCuenta());
                fileOut.writeDouble(aux.getIdCliente());
                fileOut.writeDouble(aux.getIdUsuario());
                fileOut.writeInt(aux.getDia());
                fileOut.writeInt(aux.getMes());
                fileOut.writeInt(aux.getAnio());
                fileOut.writeDouble(aux.getSaldo_actual());
                fileOut.writeInt(aux.getContrato());
                fileOut.writeUTF(aux.getTipo_cuenta());
                fileOut.writeInt(aux.getDiaM());
                fileOut.writeInt(aux.getMesM());
                fileOut.writeInt(aux.getAnioM());
            }
            fileOut.close();
        }
    }
    public void Retiro(double id) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.bin"));
        ArrayList<Cuentas> lista = new ArrayList();
        encontrado = false;
        aceptado = false;
        try{
            while(true){
                Cuentas cli = new Cuentas();
                cli.setIdCuenta(fileIn.readDouble());
                cli.setIdCliente(fileIn.readDouble());
                cli.setIdUsuario(fileIn.readDouble());
                cli.setDia(fileIn.readInt());
                cli.setMes(fileIn.readInt());
                cli.setAnio(fileIn.readInt());
                cli.setSaldo_actual(fileIn.readDouble());
                cli.setContrato(fileIn.readInt());
                cli.setTipo_cuenta(fileIn.readUTF());
                cli.setDiaM(fileIn.readInt());
                cli.setMesM(fileIn.readInt());
                cli.setAnioM(fileIn.readInt());
                
                lista.add(cli);
            }
        } catch(IOException ex){
            
        }
        Cuentas temp;
        int monto, deposito;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            if (temp.getIdCuenta() == id) {
                monto = Integer.parseInt(JOptionPane.showInputDialog(null, "Saldo $:"+ temp.getSaldo_actual()+"\nMonto a Retirar: "));
                if(monto <= 7000){
                    if ((temp.getSaldo_actual()-monto) < 1000) {
                        JOptionPane.showMessageDialog(this, "Saldo Insuficiente","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        if (temp.getDia() <= 31 && temp.getMes() <= 12 && (temp.getAnio() < 2030 && temp.getAnio() >= 2019)) {
                            if (temp.getMes() == 2 && temp.getDia() >= 28) {
                                JOptionPane.showMessageDialog(this, "Febrero tiene 28 dias","ERROR",JOptionPane.ERROR_MESSAGE);
                            } else {
                                temp.setSaldo_actual(temp.getSaldo_actual()-monto);
                                temp.setDiaM(Integer.parseInt(txtDia.getText()));
                                temp.setMesM(Integer.parseInt(txtMes.getText()));
                                temp.setAnioM(Integer.parseInt(txtAnio.getText()));
                                txtMonto.setText(String.valueOf(String.format("%.0f", temp.getSaldo_actual())));
                                aceptado = true;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto");
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Retiros no mayores a 7000","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                encontrado = true;
            }
        }
        if(encontrado == true && aceptado == true){
            Cuentas aux = new Cuentas();
            fileOut = new DataOutputStream(new FileOutputStream("d:/txt/cuenta.bin"));
            for (int i = 0; i < lista.size(); i++) {
                aux = lista.get(i);
               
                fileOut.writeDouble(aux.getIdCuenta());
                fileOut.writeDouble(aux.getIdCliente());
                fileOut.writeDouble(aux.getIdUsuario());
                fileOut.writeInt(aux.getDia());
                fileOut.writeInt(aux.getMes());
                fileOut.writeInt(aux.getAnio());
                fileOut.writeDouble(aux.getSaldo_actual());
                fileOut.writeInt(aux.getContrato());
                fileOut.writeUTF(aux.getTipo_cuenta());
                fileOut.writeInt(aux.getDiaM());
                fileOut.writeInt(aux.getMesM());
                fileOut.writeInt(aux.getAnioM());
                
            }
            fileOut.close();
        }
    }
    public void CargoBan(int a){
        cargo = a;
    }
    public int getCargo(){
        return cargo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIDCue = new javax.swing.JTextField();
        btnDepositar = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("ID Cuenta");

        btnDepositar.setText("Depositar");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel2.setText("Monto Actual $");

        txtMonto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Actual"));

        jLabel3.setText("Dia");

        jLabel4.setText("Mes");

        jLabel5.setText("Año");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIDCue, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(11, 11, 11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnDepositar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRetirar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnRegresar)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDCue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetirar)
                    .addComponent(btnDepositar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        try {
            Deposito(Double.parseDouble(txtIDCue.getText()));
        } catch (IOException ex) {
            //Logger.getLogger(Deposito.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){//COMPARA QUE SE HAYA INGRESADO UN NUMERO Y NO UN CARACTER
            JOptionPane.showMessageDialog(this, "Solo números","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "la Cuenta no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        try {
            Retiro(Double.parseDouble(txtIDCue.getText()));
        } catch (IOException ex) {
            //Logger.getLogger(Deposito.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){//COMPARA QUE SE HAYA INGRESADO UN NUMERO Y NO UN CARACTER
            JOptionPane.showMessageDialog(this, "Solo números","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "La Cuenta no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if ( getCargo() == 1 ) {
            MenuGerente mg = new MenuGerente();
            mg.setVisible(true);
            this.setVisible(false);
        }
        else if ( getCargo() == 0) {
            MenuCajero mc = new MenuCajero();
            mc.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtIDCue;
    private javax.swing.JTextField txtMes;
    private javax.swing.JLabel txtMonto;
    // End of variables declaration//GEN-END:variables
}
