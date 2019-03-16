
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class MostrarUsuarios extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    int cargo;
    public MostrarUsuarios() throws FileNotFoundException {
        initComponents();
        MostrarTabla();
        this.setLocationRelativeTo(null);
    }
    public void CargoBan(int a){
        cargo = a;
    }
    public int getCargo(){
        return cargo;
    }
    
    public void MostrarTabla() throws FileNotFoundException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/usuario.txt"));
        ArrayList<Usuarios> lista = new ArrayList();
        try{
            while(true){
                Usuarios u = new Usuarios();
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
                lista.add(u);
            }
        }catch(IOException ex){
            
        }
        String [] nombre = {"ID","Nombre","Apellido","Sexo", "Direccion", "Telefono","Cargo Bancario"
        ,"Ciudad", "Estado", "Pais"};
        String [][] data = new String[lista.size()][10];
        Usuarios temp;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            data[i][0] = String.valueOf(String.format("%.0f",temp.getIdUsuario()));
            data[i][1] = temp.getNombre();
            data[i][2] = temp.getApellido();
            data[i][3] = temp.getSexo();
            data[i][4] = temp.getDireccion();
            data[i][5] = String.valueOf(String.format("%.0f",temp.getTelefono()));
            data[i][6] = temp.getCargo_bancario();
            data[i][7] = temp.getCiudad();
            data[i][8] = temp.getEstado();
            data[i][9] = temp.getPais();
        }
        tlbMostrarUs.setModel(new DefaultTableModel(data,nombre));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tlbMostrarUs = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setUndecorated(true);
        setResizable(false);

        tlbMostrarUs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Sexo", "Direccion", "Telefono", "Cargo Bancario", "Ciudad", "Estado", "Pais"
            }
        ));
        jScrollPane1.setViewportView(tlbMostrarUs);

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
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(518, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(489, 489, 489))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MostrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MostrarUsuarios().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MostrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tlbMostrarUs;
    // End of variables declaration//GEN-END:variables
}
