/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectGUI;

import java.util.List;

/**
 *
 * @author Jonathan
 */
public class PassageResultEventArgs extends java.util.EventObject {
	java.awt.Frame Parent;

    private String ParticipantNumber;
   
  
    public List<String[]> arrowRecords;

    public PassageResultEventArgs(Object source, List<String[]> arrowResults)
            //long startTime,long endTime,long totalTime,int upCount,int downCount,int lineCount,int smsCondition,int lastVisibleLine,int smsCounter)
            {
	super(source);
        //passage results
        arrowRecords = arrowResults;
    }
	
}
