
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ModificarCuenta extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    DataOutputStream fileOut = null;
    boolean encontrado = false;
    boolean aceptado = false;
    int cargo;
    Cuentas c = new Cuentas();
    
    public ModificarCuenta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void BuscarMod(double id) throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.txt"));
        encontrado = false;
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
            c.setDiaM(fileIn.readInt());
            c.setMesM(fileIn.readInt());
            c.setAnioM(fileIn.readInt());
            
            if(id == c.getIdCliente()){
                txtSaldo.setText(String.valueOf(String.format("%.0f",c.getSaldo_actual())));
                txtDia.setText(String.valueOf(c.getDia()));
                txtMes.setText(String.valueOf(c.getMes()));
                txtAnio.setText(String.valueOf(c.getAnio()));
                cboTipo.setSelectedItem(c.getTipo_cuenta());
                encontrado = true;
            }
            
        }
    }
     public void Editar(double id) throws FileNotFoundException, IOException{
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
            
            if (temp.getIdCuenta() == id) {
                temp.setDia(Integer.parseInt(txtDia.getText()));
                temp.setMes(Integer.parseInt(txtMes.getText()));
                temp.setAnio(Integer.parseInt(txtAnio.getText()));
                temp.setTipo_cuenta(cboTipo.getSelectedItem().toString());
                temp.setSaldo_actual(Double.parseDouble(txtSaldo.getText()));
                if (temp.getDia() <= 31 && temp.getMes() <= 12 && (temp.getAnio() < 2030 && temp.getAnio() >= 2019)) {
                    if (temp.getSaldo_actual() >= 1000) {
                        aceptado = true;
                        JOptionPane.showMessageDialog(null, "Modificado con exito");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Saldo debe ser mayor a 1000");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto");
                }
                
                encontrado = true;
            }
        }
        if(encontrado == true && aceptado == true){
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
                fileOut.writeInt(c.getDiaM());
                fileOut.writeInt(c.getMesM());
                fileOut.writeInt(c.getAnioM());
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

        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        cboTipo = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtIDCu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        jLabel4.setText("Tipo de Cuenta");

        txtSaldo.setText("1000");

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahorro", "Credito" }));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel2.setText("Saldo Inicial $");

        jLabel19.setText("ID Cuenta");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDCu, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtIDCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnModificar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            Editar(Double.parseDouble(txtIDCu.getText()));
        } catch (IOException ex) {
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Solo números","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "EL Usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            BuscarMod(Double.parseDouble(txtIDCu.getText()));
        } catch (IOException ex) {
            
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "EL Usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtIDCu;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
