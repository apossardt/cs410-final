/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Andrew
 */
public class EditQuestionForm extends javax.swing.JFrame {

    /**
     * Creates new form EditQuestionForm
     */
    public EditQuestionForm() {
        initComponents();
    }
    
    public void setCurrentQuestion(String question, String[] answers, String correct, int questionNumber) {
        questionNo = questionNumber;
        questionTF.setText(question);
        answerATF.setText(answers[0]);
        answerBTF.setText(answers[1]);
        answerCTF.setText(answers[2]);
        answerDTF.setText(answers[3]);
        answerETF.setText(answers[4]);
        if("".equals(answers[2]) || " ".equals(answers[2])) {
            answerCLabel.setVisible(false);
            answerCTF.setVisible(false);
        }
        if("".equals(answers[3]) || " ".equals(answers[3])) {
            answerDLabel.setVisible(false);
            answerDTF.setVisible(false);
        }
        if("".equals(answers[4]) || " ".equals(answers[4])) {
            answerELabel.setVisible(false);
            answerETF.setVisible(false);
        }   
        correctAnswerTF.setText(correct);
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

        questionsSavedDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        questionDialogButton = new javax.swing.JButton();
        questionTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        answerATF = new javax.swing.JTextField();
        answerBTF = new javax.swing.JTextField();
        answerCTF = new javax.swing.JTextField();
        answerDTF = new javax.swing.JTextField();
        answerETF = new javax.swing.JTextField();
        answerALabel = new javax.swing.JLabel();
        answerBLabel = new javax.swing.JLabel();
        answerCLabel = new javax.swing.JLabel();
        answerDLabel = new javax.swing.JLabel();
        answerELabel = new javax.swing.JLabel();
        correctAnswerLabel = new javax.swing.JLabel();
        correctAnswerTF = new javax.swing.JTextField();
        saveChangesButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        questionsSavedDialog.setTitle("Manager");
        questionsSavedDialog.setMaximumSize(new java.awt.Dimension(300, 200));
        questionsSavedDialog.setMinimumSize(new java.awt.Dimension(300, 200));
        questionsSavedDialog.setPreferredSize(new java.awt.Dimension(300, 200));
        questionsSavedDialog.setResizable(false);
        questionsSavedDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Question Updated.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        questionsSavedDialog.getContentPane().add(jLabel2, gridBagConstraints);

        questionDialogButton.setText("OK");
        questionDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionDialogButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        questionsSavedDialog.getContentPane().add(questionDialogButton, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Question");
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));
        setResizable(false);

        questionTF.setText("questionTextField");
        questionTF.setMaximumSize(new java.awt.Dimension(350, 25));
        questionTF.setMinimumSize(new java.awt.Dimension(350, 25));
        questionTF.setPreferredSize(new java.awt.Dimension(350, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Question:");

        answerATF.setText("questionTextField");
        answerATF.setMaximumSize(new java.awt.Dimension(350, 25));
        answerATF.setMinimumSize(new java.awt.Dimension(350, 25));
        answerATF.setPreferredSize(new java.awt.Dimension(350, 25));

        answerBTF.setText("questionTextField");
        answerBTF.setMaximumSize(new java.awt.Dimension(350, 25));
        answerBTF.setMinimumSize(new java.awt.Dimension(350, 25));
        answerBTF.setPreferredSize(new java.awt.Dimension(350, 25));

        answerCTF.setText("questionTextField");
        answerCTF.setMaximumSize(new java.awt.Dimension(350, 25));
        answerCTF.setMinimumSize(new java.awt.Dimension(350, 25));
        answerCTF.setPreferredSize(new java.awt.Dimension(350, 25));

        answerDTF.setText("questionTextField");
        answerDTF.setMaximumSize(new java.awt.Dimension(350, 25));
        answerDTF.setMinimumSize(new java.awt.Dimension(350, 25));
        answerDTF.setPreferredSize(new java.awt.Dimension(350, 25));

        answerETF.setText("questionTextField");
        answerETF.setMaximumSize(new java.awt.Dimension(350, 25));
        answerETF.setMinimumSize(new java.awt.Dimension(350, 25));
        answerETF.setPreferredSize(new java.awt.Dimension(350, 25));

        answerALabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answerALabel.setText("Answer A:");

        answerBLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answerBLabel.setText("Answer B:");

        answerCLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answerCLabel.setText("Answer C:");

        answerDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answerDLabel.setText("Answer D:");

        answerELabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answerELabel.setText("Answer E:");

        correctAnswerLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        correctAnswerLabel.setText("Correct Answer:");

        correctAnswerTF.setText("questionTextField");
        correctAnswerTF.setMaximumSize(new java.awt.Dimension(350, 25));
        correctAnswerTF.setMinimumSize(new java.awt.Dimension(350, 25));
        correctAnswerTF.setPreferredSize(new java.awt.Dimension(350, 25));

        saveChangesButton.setText("Save Changes");
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });

        backButton.setText("Go Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(questionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(answerALabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(answerATF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(answerBLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(answerBTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(answerDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(answerDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(answerCLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(answerCTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(answerELabel)
                        .addGap(71, 71, 71)
                        .addComponent(answerETF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(correctAnswerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(correctAnswerTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveChangesButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerATF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerALabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerBTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerBLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerCTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerCLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerETF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerELabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correctAnswerTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correctAnswerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveChangesButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesButtonActionPerformed
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE QUESTION SET QUESTION='" + questionTF.getText() 
                                                 + "', ANSWER_A='" + answerATF.getText()
                                                 + "', ANSWER_B='" + answerBTF.getText()
                                                 + "', ANSWER_C='" + answerCTF.getText()
                                                 + "', ANSWER_D='" + answerDTF.getText()
                                                 + "', ANSWER_E='" + answerETF.getText() 
                                                 + "', CORRECT_ANSWER='" + correctAnswerTF.getText()
                                                 + "' " + "WHERE ID=" + questionNo);
            stmt.close();
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
        questionsSavedDialog.setVisible(true);
    }//GEN-LAST:event_saveChangesButtonActionPerformed

    private void questionDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionDialogButtonActionPerformed
        questionsSavedDialog.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_questionDialogButtonActionPerformed
    private Statement stmt;
    private Connection conn;
    private static final String dbURL = "jdbc:derby://localhost:1527/sidresDB;create=true;user=sidresAdmin;password=1x!Software";
    private int numAnswers=5, questionNo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answerALabel;
    private javax.swing.JTextField answerATF;
    private javax.swing.JLabel answerBLabel;
    private javax.swing.JTextField answerBTF;
    private javax.swing.JLabel answerCLabel;
    private javax.swing.JTextField answerCTF;
    private javax.swing.JLabel answerDLabel;
    private javax.swing.JTextField answerDTF;
    private javax.swing.JLabel answerELabel;
    private javax.swing.JTextField answerETF;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel correctAnswerLabel;
    private javax.swing.JTextField correctAnswerTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton questionDialogButton;
    private javax.swing.JTextField questionTF;
    private javax.swing.JDialog questionsSavedDialog;
    private javax.swing.JButton saveChangesButton;
    // End of variables declaration//GEN-END:variables
}
