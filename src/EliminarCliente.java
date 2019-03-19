
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class EliminarCliente extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    DataOutputStream fileOut = null;
    boolean encontrado = false;
    Clientes c = new Clientes();
    int cargo;
    
    public EliminarCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void EliminarCue(double id) throws FileNotFoundException, IOException{
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
                cli.setDiaM(fileIn.readInt());
                cli.setMesM(fileIn.readInt());
                cli.setAnioM(fileIn.readInt());
                
                lista.add(cli);
            }
        } catch(IOException ex){
            
        }
        Cuentas temp;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            if (temp.getIdCliente() == id) {
                lista.remove(temp);
            }
        }
        fileOut = new DataOutputStream(new FileOutputStream("d:/txt/cuenta.txt"));
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            fileOut.writeDouble(temp.getIdCuenta());
            fileOut.writeDouble(temp.getIdCliente());
            fileOut.writeDouble(temp.getIdUsuario());
            fileOut.writeInt(temp.getDia());
            fileOut.writeInt(temp.getMes());
            fileOut.writeInt(temp.getAnio());
            fileOut.writeDouble(temp.getSaldo_actual());
            fileOut.writeInt(temp.getContrato());
            fileOut.writeUTF(temp.getTipo_cuenta());
            fileOut.writeInt(temp.getDiaM());
            fileOut.writeInt(temp.getMesM());
            fileOut.writeInt(temp.getAnioM());

        }
        fileOut.close();
    }

    public void Eliminar(double id) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cliente.txt"));
        ArrayList<Clientes> lista = new ArrayList();
        encontrado = false;
        try{
            while(true){
                Clientes us = new Clientes();
                us.setIdCliente(fileIn.readDouble());
                us.setNombre(fileIn.readUTF());
                us.setApellido(fileIn.readUTF());
                us.setDireccion(fileIn.readUTF());
                us.setTelefono(fileIn.readDouble());
                us.setTipo_cliente(fileIn.readUTF());
                us.setCiudad(fileIn.readUTF());
                us.setEstado(fileIn.readUTF());
                us.setPais(fileIn.readUTF());
                us.setSexo(fileIn.readUTF());
                lista.add(us);
            }
        } catch(IOException ex){
            
        }
        Clientes temp;
        int resp = 0;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            if (temp.getIdCliente() == id) {
                resp = JOptionPane.showConfirmDialog(null, "Desea eliminar a: "+String.format("%.0f", temp.getIdCliente())+
                        "\nNombre: "+temp.getNombre() + "\nApellido: "+temp.getApellido(),
                        "Advertencia", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    EliminarCue(temp.getIdCliente());
                    lista.remove(temp);
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                }
                encontrado = true;
            }
        }
        fileOut = new DataOutputStream(new FileOutputStream("d:/txt/cliente.txt"));
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            fileOut.writeDouble(temp.getIdCliente());
            fileOut.writeUTF(temp.getNombre());
            fileOut.writeUTF(temp.getApellido());
            fileOut.writeUTF(temp.getDireccion());
            fileOut.writeDouble(temp.getTelefono());
            fileOut.writeUTF(temp.getTipo_cliente());
            fileOut.writeUTF(temp.getCiudad());
            fileOut.writeUTF(temp.getEstado());
            fileOut.writeUTF(temp.getPais());
            fileOut.writeUTF(temp.getSexo());
        }
        fileOut.close();
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

        jLabel21 = new javax.swing.JLabel();
        txtEliminar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel21.setText("ID a Eliminar");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegresar)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegresar))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            Eliminar(Double.parseDouble(txtEliminar.getText()));
        } catch (IOException ex) {
            //Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){//COMPARA QUE SE HAYA INGRESADO UN NUMERO Y NO UN CARACTER
            JOptionPane.showMessageDialog(this, "Solo números","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "EL Cliente no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JTextField txtEliminar;
    // End of variables declaration//GEN-END:variables
}
