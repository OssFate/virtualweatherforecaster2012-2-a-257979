/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author German
 */
public class OutputPane extends JPanel{
    
    private JTextArea outStr;
    private double[] data;
    private String[] date;
    private int outval;
    private double error;
    
    public OutputPane(double[] dt, String[] dat, int outvl,double err){
        
        data = dt;
        date = dat;
        outval = outvl;
        error = err;
        this.setLayout(new BorderLayout(60,60));
        outStr = new JTextArea();
        PrintFCast();
        outStr.setEditable(false);
        this.add(outStr,BorderLayout.CENTER);
    }
    
    public void PrintFCast(){
        
        outStr.append("Forecast\n");
        for (int i=0;i<outval;i++){
            outStr.append("\n    "+date[i]+": "+data[i]);
            System.out.println(date[i]+" "+data[i]);
        }
        outStr.append("\nError: "+error+"%");
    }
    
}
