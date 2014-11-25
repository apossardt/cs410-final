/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectGUI;

import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class SurveyResultEventArgs extends java.util.EventObject {
    
    public ArrayList<Object[]> glResults = new ArrayList();
    public SurveyResultEventArgs(Object source,ArrayList<Object[]> glResults)
    {
        super(source);
        this.glResults=glResults;
    }
}

