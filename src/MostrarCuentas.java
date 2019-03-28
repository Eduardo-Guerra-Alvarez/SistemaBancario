
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class MostrarCuentas extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    int cargo;
    public MostrarCuentas() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarTabla();
    }
    public void CargoBan(int a){
        cargo = a;
    }
    public int getCargo(){
        return cargo;
    }
    public void MostrarTabla() throws FileNotFoundException, IOException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cuenta.bin"));
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
        String [] nombre = {"ID Cuenta","ID Cliente","ID Usuario","Fecha", "Saldo Actual", "Contrato","Tipo Cuenta"};
        String [][] data = new String[lista.size()][7];
        Cuentas temp;
        String fecha;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            if(temp.getDia() <= 9){
                fecha = String.valueOf("0"+temp.getDia())+"/"+String.valueOf(temp.getMes())+"/"+String.valueOf(temp.getAnio());
            } else if (temp.getMes() <= 9) {
                fecha = String.valueOf(temp.getDia())+"/"+"0"+String.valueOf(temp.getMes())+"/"+String.valueOf(temp.getAnio());
            } else if (temp.getDia() <= 9 && temp.getMes() <= 9) {
                fecha = String.valueOf("0"+temp.getDia())+"/"+"0"+String.valueOf(temp.getMes())+"/"+String.valueOf(temp.getAnio());
            }
            else {
                fecha = String.valueOf(temp.getDia())+"/"+String.valueOf(temp.getMes())+"/"+String.valueOf(temp.getAnio());
            }
            data[i][0] = String.valueOf(String.format("%.0f", temp.getIdCuenta()));
            data[i][1] = String.valueOf(String.format("%.0f", temp.getIdCliente()));
            data[i][2] = String.valueOf(String.format("%.0f", temp.getIdUsuario()));
            data[i][3] = fecha;
            data[i][4] = String.valueOf(String.format("%.0f", temp.getSaldo_actual()));
            data[i][5] = String.valueOf(temp.getContrato());
            data[i][6] = temp.getTipo_cuenta();
        }
        tlbMostrar.setModel(new DefaultTableModel(data,nombre));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tlbMostrar = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
        tlbMostrar.setToolTipText("");
        jScrollPane1.setViewportView(tlbMostrar);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(488, 488, 488)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MostrarCuentas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MostrarCuentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tlbMostrar;
    // End of variables declaration//GEN-END:variables
}
