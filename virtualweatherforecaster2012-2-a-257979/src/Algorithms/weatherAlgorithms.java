package Algorithms;

public abstract class weatherAlgorithms {
    
    double[] At, Ft;
    
    // The method MAPE calculates the MAPE error based in the input and output
    // arrays, assigning the calculated error to the last position in the array
    // predictions.
    public void MAPE(){
        double M = 0;
        for(int i=0; i < At.length; i++){
            M += Math.abs((At[i] - Ft[i])/At[i]);
        } 
        Ft[At.length] = (100*M/Ft.length);
    }
    
    // Getter and Setter methods.
    
    public void setInput(double[] input) {
        this.At = input;
    }

    public double[] getPredictions() {
        return Ft;
    }
    
    abstract void logic();
    
}
