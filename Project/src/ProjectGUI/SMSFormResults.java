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
public class SMSFormResults extends java.util.EventObject {

    public double smsTime;
    public String smsText, smsResponse;
    public int wordCount;
    public int smsCounter;
    public SMSFormResults(Object source,double time,String smsText,String response,int words,int smsCounter) {
	super(source);
        smsTime = time;
        this.smsText = smsText;
        smsResponse = response;
        wordCount = words;
        this.smsCounter = smsCounter;
        
    }
}
