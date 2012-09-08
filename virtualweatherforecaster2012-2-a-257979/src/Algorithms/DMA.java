package Algorithms;

public class DMA extends weatherAlgorithms{

    @Override
    void logic() {
        SMA logicDMA = new SMA();
        logicDMA.setInput(this.At);
        logicDMA.logic();
        logicDMA.setInput(this.Ft);
        logicDMA.logic();
    }
    
}
