
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuGerente extends javax.swing.JFrame {

    public MenuGerente() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarUs = new javax.swing.JButton();
        btnMosUs = new javax.swing.JButton();
        btnBuscarUs = new javax.swing.JButton();
        btnEliminarUs = new javax.swing.JButton();
        btnModificarUs = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarCli = new javax.swing.JButton();
        btnBuscarCli = new javax.swing.JButton();
        btnEliminarCli = new javax.swing.JButton();
        btnModificarCli = new javax.swing.JButton();
        btnMostrarCli = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnMostrarCu = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        btnBuscarCu = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerente");
        setUndecorated(true);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        btnAgregarUs.setText("Agregar Usuario");
        btnAgregarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsActionPerformed(evt);
            }
        });

        btnMosUs.setText("Mostrar Usuarios");
        btnMosUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosUsActionPerformed(evt);
            }
        });

        btnBuscarUs.setText("Buscar Usuario");
        btnBuscarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsActionPerformed(evt);
            }
        });

        btnEliminarUs.setText("Eliminar Usuario");
        btnEliminarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsActionPerformed(evt);
            }
        });

        btnModificarUs.setText("Modificar Usuario");
        btnModificarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMosUs)
                    .addComponent(btnModificarUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAgregarUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMosUs)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        btnAgregarCli.setText("Agregar Cliente");
        btnAgregarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCliActionPerformed(evt);
            }
        });

        btnBuscarCli.setText("Buscar Cliente");
        btnBuscarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCliActionPerformed(evt);
            }
        });

        btnEliminarCli.setText("Eliminar Cliente");
        btnEliminarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCliActionPerformed(evt);
            }
        });

        btnModificarCli.setText("Modificar Cliente");
        btnModificarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCliActionPerformed(evt);
            }
        });

        btnMostrarCli.setText("Mostrar Clientes");
        btnMostrarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrarCli)
                    .addComponent(btnEliminarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnAgregarCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMostrarCli)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta"));

        btnMostrarCu.setText("Mostrar Cuenta");
        btnMostrarCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCuActionPerformed(evt);
            }
        });

        btnMovimientos.setText("Movimientos");
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        btnBuscarCu.setText("Buscar Cuenta");
        btnBuscarCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Cuenta");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrarCu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarCu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnMostrarCu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMovimientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("MENU GERENTE");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnSalir))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsActionPerformed
        AgregarUsuario au;
        try {
            au = new AgregarUsuario();
            au.setVisible(true);
            au.CargoBan(1);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAgregarUsActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnMosUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosUsActionPerformed
        try {
            MostrarUsuarios mu = new MostrarUsuarios();
            mu.setVisible(true);
            mu.CargoBan(1);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnMosUsActionPerformed

    private void btnEliminarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCliActionPerformed
        EliminarCliente ec = new EliminarCliente();
        ec.setVisible(true);
        ec.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnEliminarCliActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsActionPerformed
        BuscarUsuario bu = new BuscarUsuario();
        bu.setVisible(true);
        bu.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnBuscarUsActionPerformed

    private void btnEliminarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsActionPerformed
        EliminarUsuario eu = new EliminarUsuario();
        eu.setVisible(true);
        eu.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnEliminarUsActionPerformed

    private void btnModificarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsActionPerformed
        ModificarUsuario mu = new ModificarUsuario();
        mu.setVisible(true);
        mu.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnModificarUsActionPerformed

    private void btnAgregarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCliActionPerformed
        AgregarCliente ac;
        AgregarCuenta acu;
        try {
            acu = new AgregarCuenta();
            acu.CargoBan(1);
            ac = new AgregarCliente();
            ac.setVisible(true);
            ac.CargoBan(1);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarCliActionPerformed

    private void btnMostrarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCliActionPerformed
    try {
            MostrarClientes mc = new MostrarClientes();
            mc.setVisible(true);
            mc.CargoBan(1);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMostrarCliActionPerformed

    private void btnBuscarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCliActionPerformed
        BuscarCliente bc = new BuscarCliente();
        bc.setVisible(true);
        bc.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnBuscarCliActionPerformed

    private void btnModificarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCliActionPerformed
        ModificarCliente mc = new ModificarCliente();
        mc.setVisible(true);
        mc.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnModificarCliActionPerformed

    private void btnMostrarCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCuActionPerformed
        try {
            MostrarCuentas mc = new MostrarCuentas();
            mc.setVisible(true);
            mc.CargoBan(1);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MenuGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnMostrarCuActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        ModificarCuenta mc = new ModificarCuenta();
        mc.setVisible(true);
        mc.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        Deposito d = new Deposito();
        d.setVisible(true);
        d.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnBuscarCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuActionPerformed
        BuscarCuenta bc = new BuscarCuenta();
        bc.setVisible(true);
        bc.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnBuscarCuActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        ConsultaCuenta cc = new ConsultaCuenta();
        cc.setVisible(true);
        cc.CargoBan(1);
        this.setVisible(false);
    }//GEN-LAST:event_btnConsultasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCli;
    private javax.swing.JButton btnAgregarUs;
    private javax.swing.JButton btnBuscarCli;
    private javax.swing.JButton btnBuscarCu;
    private javax.swing.JButton btnBuscarUs;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnEliminarCli;
    private javax.swing.JButton btnEliminarUs;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificarCli;
    private javax.swing.JButton btnModificarUs;
    private javax.swing.JButton btnMosUs;
    private javax.swing.JButton btnMostrarCli;
    private javax.swing.JButton btnMostrarCu;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
