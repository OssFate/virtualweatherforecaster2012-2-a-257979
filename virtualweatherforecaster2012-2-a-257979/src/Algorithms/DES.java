package Algorithms;

//comentario 1 no sirve :D
public class DES {
    private double lt;
    private double bt;
    private double a = 0.2;
    private double g = 0.42 ;
    private double lt1;
    private double bt1;
    private double input [];
    
    private double predictions[];
    
    void DES (){
   
        lt= input[0]; 
        bt= input[1]-input[0]; 
        predictions[1]= input[0]; 
        for(int i=1; i<=input.length; i=i+1)
       {
        
            lt1 = (a*input[i])+(1-a)*(lt+bt);
            bt1 = g*(lt1 - lt)+(1-g)*bt;
            predictions[i] = lt1 + bt1;   
           
             lt=lt1;
             bt=bt1;
            
       
      }
      
    }}
