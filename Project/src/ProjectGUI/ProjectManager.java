/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class ProjectManager implements InstructionFormListener, PassageListener,SMSFormListener, QuestionFormListener {
    
    private static String dbURL = "jdbc:derby://localhost:1527/sidresDB;create=true;user=sidresAdmin;password=1x!Software";
    private static String tableName = "SMSRESULTS";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
    private String participantNumber;
    private PassageForm passageFrm;
    private SMSForm smsFrm;
    private QuestionForm questionFrm;
    private QuestionForm surveyFrm;
    private InstructionsForm instructionsFrm;
    private int smsCondition;
    
    public ProjectManager()
    {
        instructionsFrm = new InstructionsForm();
    }

    @Override
    public void smsFormComplete(SMSFormResults results)
    {
        if(results.smsCounter == 5)
            DisplayPassage();
        
        saveSMSResults(results);
    }
    
    @Override
    public void instructionComplete(InstructionCompleteEventArgs complete)
    {
        participantNumber = complete.ParticipantNumber;
        passageFrm = new PassageForm(participantNumber);
        smsCondition = Integer.parseInt(participantNumber.substring(0, 1));
        smsFrm = new SMSForm(passageFrm,true,smsCondition);
        smsFrm.addListener(this);
        passageFrm.addListener(this);
        if(smsCondition == 2)
        {
            displaySMS();
        }
        else
            DisplayPassage();
    }
    @Override
    public void passageComplete(PassageResultEventArgs results)
    {
        savePassageResults();
        
        DisplayTestQuestions();
    }
    
    @Override
    public void testQuestionFormComplete(QuestionFormResults results)
    {
        //saveQuestionResults();
        
        DisplaySurveyQuestions();
    }
    
    @Override
    public void surveyQuestionFormComplete(QuestionFormResults results)
    {
        //saveSurveyResults();
    }
    

    public void displaySMS()
    {
            //SMSForm frm = new SMSForm(args.Parent, true);
            
            smsFrm.setAlwaysOnTop(true);
            smsFrm.setLocationRelativeTo(null);
            smsFrm.requestFocus();
            smsFrm.setStartTime();
            smsFrm.setVisible(true);
            
           
    }
    
    public void beginInstructions()
    {
        //InstructionsForm frm = new InstructionsForm();
        instructionsFrm.addListener(this);
        instructionsFrm.setVisible(true);
        // Center the form by using setLocationRelativeTo(null)
        instructionsFrm.setLocationRelativeTo(null);
    
    }
    private void savePassageResults()
    {
    }
    private void saveSMSResults(SMSFormResults result)
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
        try
        {
            int id = (int) (System.currentTimeMillis()*1000);
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values (" +
                    id + "," + result.smsTime + ",'" + result.smsText + "','"+result.smsResponse+ "',"+result.wordCount+")");
            stmt.close();

        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    private void saveQuestionResults()
    {
    }
    
    
    
    
    private void DisplayPassage()
    {
        
        
        passageFrm.setVisible(true);
        passageFrm.setLocationRelativeTo(null);
    }
    
    private void DisplayTestQuestions()
    {
        questionFrm = new QuestionForm(false, participantNumber);
        questionFrm.addListener(this);
        questionFrm.setVisible(true);
        questionFrm.setLocationRelativeTo(null);
    }
    
    private void DisplaySurveyQuestions() 
    {
        surveyFrm = new QuestionForm(true, participantNumber);
        surveyFrm.addListener(this);
        surveyFrm.setVisible(true);
        surveyFrm.setLocationRelativeTo(null);
    }
    
}
