
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ModificarUsuario extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    DataOutputStream fileOut = null;
    Usuarios u = new Usuarios();
    boolean encontrado;
    int cargo;
    public ModificarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void Buscar(double id) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/usuario.txt"));
        encontrado = false;
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
            
            if(id == u.getIdUsuario()){
                //txtIDMod.setText(String.valueOf(String.format("%.0f",u.getIdUsuario())));
                txtNombreMod.setText(u.getNombre());
                txtApellidosMod.setText(u.getApellido());
                txtDireccionMod.setText(u.getDireccion());
                txtTelefonoMod.setText(String.valueOf(String.format("%.0f",u.getTelefono())));
                cboCargo.setSelectedItem(u.getCargo_bancario());
                txtCiudadMod.setText(u.getCiudad());
                txtEstadoMod.setText(u.getEstado());
                cboPais.setSelectedItem(u.getPais());
                txtSexoMod.setText(u.getSexo());
                encontrado = true;
            }
            
        }
    }
    public void Editar(double id) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/usuario.txt"));
        ArrayList<Usuarios> lista = new ArrayList();
        encontrado = false;
        try{
            while(true){
                Usuarios us = new Usuarios();
                us.setIdUsuario(fileIn.readDouble());
                us.setNombre(fileIn.readUTF());
                us.setApellido(fileIn.readUTF());
                us.setDireccion(fileIn.readUTF());
                us.setTelefono(fileIn.readDouble());
                us.setCargo_bancario(fileIn.readUTF());
                us.setCiudad(fileIn.readUTF());
                us.setEstado(fileIn.readUTF());
                us.setPais(fileIn.readUTF());
                us.setSexo(fileIn.readUTF());
                lista.add(us);
            }
        } catch(IOException ex){
            
        }
        Usuarios temp;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            if (temp.getIdUsuario() == id) {
                temp.setNombre(txtNombreMod.getText());
                temp.setApellido(txtApellidosMod.getText());
                temp.setDireccion(txtDireccionMod.getText());
                temp.setTelefono(Double.parseDouble(txtTelefonoMod.getText()));
                temp.setCargo_bancario(cboCargo.getSelectedItem().toString());
                temp.setCiudad(txtCiudadMod.getText());
                temp.setEstado(txtEstadoMod.getText());
                temp.setPais(cboPais.getSelectedItem().toString());
                temp.setSexo(txtSexoMod.getText());
                encontrado = true;
            }
        }
        if (encontrado == true) {
            Usuarios aux;
            fileOut = new DataOutputStream(new FileOutputStream("d:/txt/usuario.txt"));
            for (int i = 0; i < lista.size(); i++) {
                aux = lista.get(i);
                fileOut.writeDouble(aux.getIdUsuario());
                fileOut.writeUTF(aux.getNombre());
                fileOut.writeUTF(aux.getApellido());
                fileOut.writeUTF(aux.getDireccion());
                fileOut.writeDouble(aux.getTelefono());
                fileOut.writeUTF(aux.getCargo_bancario());
                fileOut.writeUTF(aux.getCiudad());
                fileOut.writeUTF(aux.getEstado());
                fileOut.writeUTF(aux.getPais());
                fileOut.writeUTF(aux.getSexo());
            }
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
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

        jLabel11 = new javax.swing.JLabel();
        txtIDMod = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombreMod = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCiudadMod = new javax.swing.JTextField();
        txtApellidosMod = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtDireccionMod = new javax.swing.JTextField();
        txtTelefonoMod = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtEstadoMod = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSexoMod = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        cboCargo = new javax.swing.JComboBox<>();
        cboPais = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel11.setText("ID");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel12.setText("Nombre");

        jLabel13.setText("Apellidos");

        jLabel16.setText("Ciudad");

        jLabel14.setText("Dirección");

        jLabel15.setText("Teléfono");

        jLabel20.setText("Cargo Bancario");

        btnEditar.setText("Modificar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel17.setText("Estado");

        jLabel19.setText("País");

        jLabel18.setText("Sexo");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        cboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Cajero" }));

        cboPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mexico", "EEUU", "España", "Colombia", "Canada", "Inglaterra" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDMod, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12)
                        .addGap(16, 16, 16)
                        .addComponent(txtNombreMod, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCiudadMod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(12, 12, 12)
                                .addComponent(txtTelefonoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(12, 12, 12)
                                .addComponent(txtDireccionMod, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel19))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(14, 14, 14)
                                .addComponent(txtApellidosMod, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstadoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSexoMod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btnBuscar))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtCiudadMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidosMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(txtEstadoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel13)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(cboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefonoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSexoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(btnEditar)
                    .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            Buscar(Double.parseDouble(txtIDMod.getText()));
        } catch (IOException ex) {
            //Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){//COMPARA QUE SE HAYA INGRESADO UN NUMERO Y NO UN CARACTER
            JOptionPane.showMessageDialog(this, "Solo números","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "EL Usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            Editar(Double.parseDouble(txtIDMod.getText()));
        } catch (IOException ex) {
            //Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){//COMPARA QUE SE HAYA INGRESADO UN NUMERO Y NO UN CARACTER
            JOptionPane.showMessageDialog(this, "Solo números","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "EL Usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JComboBox<String> cboPais;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JTextField txtApellidosMod;
    private javax.swing.JTextField txtCiudadMod;
    private javax.swing.JTextField txtDireccionMod;
    private javax.swing.JTextField txtEstadoMod;
    private javax.swing.JTextField txtIDMod;
    private javax.swing.JTextField txtNombreMod;
    private javax.swing.JTextField txtSexoMod;
    private javax.swing.JTextField txtTelefonoMod;
    // End of variables declaration//GEN-END:variables
}
