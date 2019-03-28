
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class MostrarClientes extends javax.swing.JFrame {
    DataInputStream fileIn = null;
    int cargo;

    public MostrarClientes() throws FileNotFoundException {
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
    
    public void MostrarTabla() throws FileNotFoundException{
        fileIn = new DataInputStream(new FileInputStream("d:/txt/cliente.bin"));
        ArrayList<Clientes> lista = new ArrayList();
        try{
            while(true){
               Clientes cli = new Clientes();
                cli.setIdCliente(fileIn.readDouble());
                cli.setNombre(fileIn.readUTF());
                cli.setApellido(fileIn.readUTF());
                cli.setDireccion(fileIn.readUTF());
                cli.setTelefono(fileIn.readDouble());
                cli.setTipo_cliente(fileIn.readUTF());
                cli.setCiudad(fileIn.readUTF());
                cli.setEstado(fileIn.readUTF());
                cli.setPais(fileIn.readUTF());
                cli.setSexo(fileIn.readUTF());
                lista.add(cli);
            }
        }catch(IOException ex){
            
        }
        String [] nombre = {"ID","Nombre","Apellido","Sexo", "Direccion", "Telefono","Tipo Cliente"
        ,"Ciudad", "Estado", "Pais"};
        String [][] data = new String[lista.size()][10];
        Clientes temp;
        for (int i = 0; i < lista.size(); i++) {
            temp = lista.get(i);
            data[i][0] = String.valueOf(String.format("%.0f", temp.getIdCliente()));
            data[i][1] = temp.getNombre();
            data[i][2] = temp.getApellido();
            data[i][3] = temp.getSexo();
            data[i][4] = temp.getDireccion();
            data[i][5] = String.valueOf(String.format("%.0f",temp.getTelefono()));
            data[i][6] = temp.getTipo_cliente();
            data[i][7] = temp.getCiudad();
            data[i][8] = temp.getEstado();
            data[i][9] = temp.getPais();
            
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
        setTitle("Clientes");
        setUndecorated(true);
        setResizable(false);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(485, 485, 485))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(10, Short.MAX_VALUE))
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
                    new MostrarClientes().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MostrarClientes.class.getName()).log(Level.SEVERE, null, ex);
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
