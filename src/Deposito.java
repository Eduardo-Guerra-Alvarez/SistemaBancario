
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Deposito extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    DataOutputStream fileOut = null;
    boolean encontrado = false;
    int cargo;
    
    public Deposito() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void Deposito(double id) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.txt"));
        ArrayList<Cuentas> lista = new ArrayList();
        encontrado = false;
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
                encontrado = true;
            }
        }
        if(encontrado == true){
            Cuentas aux = new Cuentas();
            fileOut = new DataOutputStream(new FileOutputStream("d:/txt/cuenta.txt"));
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
            }
            fileOut.close();
        }
    }
    public void Retiro(double id) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.txt"));
        ArrayList<Cuentas> lista = new ArrayList();
        encontrado = false;
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
                if(monto <= 6000){
                    if ((temp.getSaldo_actual()-monto) < 1000) {
                        JOptionPane.showMessageDialog(this, "Saldo Insuficiente","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        temp.setSaldo_actual(temp.getSaldo_actual()-monto);
                        txtMonto.setText(String.valueOf(String.format("%.0f", temp.getSaldo_actual())));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Retiros no mayores a 6000","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                encontrado = true;
            }
        }
        if(encontrado == true){
            Cuentas aux = new Cuentas();
            fileOut = new DataOutputStream(new FileOutputStream("d:/txt/cuenta.txt"));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnDepositar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetirar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCue, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDCue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetirar)
                    .addComponent(btnDepositar))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(18, Short.MAX_VALUE))
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
    private javax.swing.JTextField txtIDCue;
    private javax.swing.JLabel txtMonto;
    // End of variables declaration//GEN-END:variables
}
