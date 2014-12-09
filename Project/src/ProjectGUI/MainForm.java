/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectGUI;
import java.io.File;
import java.io.PrintWriter;
import org.apache.derby.drda.NetworkServerControl;
import java.net.InetAddress;

/**
 *
 * @author Steve
 */
public class MainForm extends javax.swing.JFrame   {

    private ProjectManager projMngr;
    private ImportDataForm impData;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        projMngr = new ProjectManager();
        
        Thread netServer = new Thread() {
                @Override
                public void run() {
                    try {
                        
                        File f = new File(System.getProperty("java.class.path"));
                        File dir = f.getAbsoluteFile().getParentFile();
 
                        String temp =  dir.toString();
                        
                        System.setProperty("derby.system.home", getClass().getResource("").getPath());       
                        NetworkServerControl serverControl=new NetworkServerControl(InetAddress.getByName("localhost"),1527);
                        
                        
                        
                        serverControl.start(new PrintWriter(System.out,true));
                    } catch(Exception v) {
                        System.out.println(v);
                    }
                }  
            };

            netServer.start();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnBegin = new javax.swing.JButton();
        btnManageData = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Experiment Manager");
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SIDRES"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnBegin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBegin.setText("Begin Experiment");
        btnBegin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 16, 16);
        jPanel1.add(btnBegin, gridBagConstraints);

        btnManageData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnManageData.setText("Edit Passage/Questions/SMS Data");
        btnManageData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 16, 16);
        jPanel1.add(btnManageData, gridBagConstraints);

        btnExport.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExport.setText("Export Results");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 16, 16);
        jPanel1.add(btnExport, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(209, 451, 290, 438);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            
        }
        catch (Exception ex) {
            // Log exception?
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnBeginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeginActionPerformed
        try {
            projMngr.beginInstructions();
            this.setVisible(false);
            this.dispose();
        }
        catch (Exception ex) {
            // Log exception?
        }
    }//GEN-LAST:event_btnBeginActionPerformed

    private void btnManageDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDataActionPerformed
        impData = new ImportDataForm();
        impData.setVisible(true);
    }//GEN-LAST:event_btnManageDataActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        try {
            //ExportData data = new ExportData();
            //data.export();
            // Carry out the export. Current guess is:
            // Get the data from the DB; write it to Excel file of some sort.
        }
        catch (Exception ex) {
            // Log exception?
        }
    }//GEN-LAST:event_btnExportActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainForm frm = new MainForm();
                frm.setVisible(true);
                // Center the form by using setLocationRelativeTo(null)
                frm.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBegin;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnManageData;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
