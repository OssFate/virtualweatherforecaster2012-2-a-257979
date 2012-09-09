package Algorithms;

public class SMA extends weatherAlgorithms{

    @Override
    public void logic() {
        Ft = new double[At.length + 1];
        Ft[0] = (At[0] + At[1])/2;
        for(int i=1; i < At.length - 1; i++) {
            Ft[i] = Ft[i-1] - (At[i - 1]/At.length) + (At[i + 1]/At.length);
        }
        Ft[At.length] = (Ft[0] + Ft[At.length - 1])/2;
    }
     
   
}
