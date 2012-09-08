package Algorithms;

public class ES {
    private double[] input, predictions;
    
    // The method ExpSmoothing executes the Exponential Smoothing algorithm,
    // using an input array of n items, assigning an output array with n+1 items.
    public void ExpSmoothing(double[] input){
        predictions = new double[input.length + 1];
        for(int i=0; i<input.length; i++){
            if(i == 0) predictions[0] = input[0];
            else{
                predictions[i] = predictions[i-1] + 
                        0.2*(input[i-1] - predictions[i-1]);
            }
        }
    }
    
    // The method MAPE calculates the MAPE error based in the input and output
    // arrays, assigning the calculated error to the last position in the array
    // predictions.
    public void MAPE(double[] input, double[] predictions){
        double M = 0;
        for(int i=0; i<input.length; i++){
            M += (Math.pow(predictions.length,-1)) * 
                    Math.abs((input[i] - predictions[i])/input[i]);
        } predictions[input.length] = 100*M;
    }
    
    // Getter and Setter methods.
    public void setInput(double[] input) {
        this.input = input;
    }

    public double[] getPredictions() {
        return predictions;
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
