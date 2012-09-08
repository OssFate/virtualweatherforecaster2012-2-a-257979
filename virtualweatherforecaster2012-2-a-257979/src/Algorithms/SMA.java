package Algorithms;

public class SMA extends weatherAlgorithms{

    @Override
    void logic() {
        Ft = new double[At.length + 1];
        for(int i=0; i < At.length; i++) {
            if(i == 0) {
                Ft[i] = (At[i] + At[i + 1])/2;
            }
            else {
                Ft[i] = Ft[i-1] - (At[At.length - i]/At.length) + (At[i]/At.length);
            }
        }
    }
    
    
    
}
