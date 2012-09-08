package Algorithms;

public class ES extends weatherAlgorithms{
       
    // The method ExpSmoothing executes the Exponential Smoothing algorithm,
    // using an input array of n items, assigning an output array with n+1 items.
    @Override
    public void logic(){
        Ft = new double[At.length + 1];
        for(int i=0; i < At.length; i++) {
            if(i == 0) {
                Ft[0] = At[0];
            }
            else {
                Ft[i] = Ft[i-1] + 0.2*(At[i-1] - Ft[i-1]);
            }
        }
    }
        
           
    
    /* Test
    public static void main(String[] args){
        double[] in = {15.6, 14.78, 15.2, 16.34, 17.1}, pred = new double[in.length + 1];
        double M = 0;
        
        for(int i=0; i<in.length; i++){
            if(i == 0) pred[0] = in[0];
            else{
                pred[i] = pred[i-1] + 0.2*(in[i-1] - pred[i-1]);
            }
        }
        
        for(int i=0; i<in.length; i++){
            M += Math.pow(pred.length,-1) * Math.abs((in[i] - pred[i])/in[i]);
        } pred[in.length] = M*100;
        
        for(int i=0; i<pred.length; i++) System.out.println(pred[i]);
        System.out.println("\n" + M);
    }*/
}
