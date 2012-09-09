package Algorithms;

public class DES extends weatherAlgorithms{
    
    private double lt;
    private double bt;
    private double lt1;
    private double bt1;
    private double a = 0.2;
    private double g = 0.42;
    
    
    @Override
    public void logic(){
        Ft = new double[At.length+1];
        lt = At[0]; 
        bt = At[1] - At[0]; 
        Ft[1] = At[0]; 
        
        for(int i=1; i < At.length; i++) {
            
            this.lt1 = (this.a*this.At[i])+(1- this.a)*(this.lt + this.bt);
            this.bt1 =  this.g*(this.lt1 - this.lt) + (1 - this.g)*this.bt;
            
            this.Ft[i] = this.lt1 + this.bt1;
            
            this.lt = this.lt1;
            this.bt = this.bt1;
        }
    }
    
}