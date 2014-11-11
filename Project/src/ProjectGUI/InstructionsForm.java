/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectGUI;


import java.util.ArrayList;

/**
 *
 * @author Steve
 */

public class InstructionsForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public InstructionsForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        txtInput = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpInstructions = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instructions");
        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnStart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        txtInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblError.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("Error Label");

        tpInstructions.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tpInstructions.setText("You will read a passage on personality disorders. \n\nPlease read carefully as you will be tested on the material after you are finished. \n\nYou might receive some text messages from the experimenter before reading, while you are reading, or not at all. If you do, please respond to those messages immediately and continue reading. You may use the arrow keys on the key board to move from line to line. \n\nWhen the passage is complete, you will respond to some questions about the reading. Please try to do the best that you can.\n\nAfter completing these questions, there will be some additional questions asking you about your behaviors.\n\nWhen you are ready to begin, please enter the number the experimenter has provided.\n\nThank you for your participation.\n");
        jScrollPane1.setViewportView(tpInstructions);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Participant Number:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 601, Short.MAX_VALUE)
                        .addComponent(btnStart)
                        .addGap(25, 25, 25)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError)
                    .addComponent(btnStart, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   

    public void addListener(InstructionFormListener toAdd) {
        listeners.add(toAdd);
    }

    public void InstructionFormCompleteEvent() {
        InstructionCompleteEventArgs evnt = new InstructionCompleteEventArgs(this,participantNumber);
        for (InstructionFormListener hl : listeners)
            hl.instructionComplete(evnt);
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            lblError.setText("");
            
            tpInstructions.setEditable(false);
            
            txtInput.grabFocus();
        }
        catch (Exception ex) {
            
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try {
            lblError.setText("");
        
            String lsInput = txtInput.getText();
            if (lsInput.compareTo("") == 0) {
                lblError.setText("Please enter a participant number.");
                txtInput.grabFocus();
            }
            // perform other checks
            else {
                
                //PassageForm frm = new PassageForm();
                //frm.setVisible(true);
                //frm.setLocationRelativeTo(null);
                participantNumber = lsInput;
                InstructionFormCompleteEvent();
                
                this.dispose();
            }
        }
        catch (Exception ex) {
            
        }
    }//GEN-LAST:event_btnStartActionPerformed


    private final ArrayList<InstructionFormListener> listeners = new ArrayList<>();
    public String participantNumber;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextPane tpInstructions;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
