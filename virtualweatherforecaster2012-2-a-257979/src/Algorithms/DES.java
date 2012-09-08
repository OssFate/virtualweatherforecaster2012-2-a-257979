/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;


public class DES extends weatherAlgorithms{
    private double lt;
    private double bt;
    private double ft;
    private double a = 0.2;
    private double g = 0.42 ;
    private double lt1;
    private double bt1;
    private double ft1;
    
    
    private double predictions[];
    
    public DES(){}
    
    public DES (double input[]){
   
     if(input.length ==1){
       predictions[1]=input[0];
     }
     
     else
     {
        lt= input[0]; // este renglon no es necesario ocupa memoria queda escrito por cuestiones de teoria
        bt= input[1]-input[0]; // este renglon no es necesario ocupa memoria queda escrito por cuestiones de teoria
        ft= input[0]; // este renglon no es necesario ocupa memoria queda escrito por cuestiones de teoria
        for(int i=1; i<=input.length; i=i+1)
       {
        predictions[i]=loop(input[i], input[i+1]);  /*setPredictions para cada prediction[i]*/ 
         
       }
      
     }
     
     
        
    }
    
    void loop (double y1, double y2)
    {
        lt1=lt;
        bt1=bt;
            
            lt = (a*y1)+(1-a)*(lt1+bt1);
            bt = g*(lt - lt1)+(1-g)*bt1;
            ft1 = lt + bt;         
        
        return ft1;
    
        Ft = new double[At.length + 1];
        for(int i=0; i<At.length; i++) {
            if(i == 0) {
                Ft[0] = At[0];
            }
            else {
                Ft[i] = Ft[i-1] + 0.2*(At[i-1] - Ft[i-1]);
            }
        }
    }



}



