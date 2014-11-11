/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectGUI;

/**
 *
 * @author Jonathan
 */
public class InstructionCompleteEventArgs extends java.util.EventObject {
    
    String ParticipantNumber;

    public InstructionCompleteEventArgs(Object source, String ParticipantNumber) {
	super(source);
        this.ParticipantNumber = ParticipantNumber;

    }
	
}