package Algorithms;

public class DMA extends weatherAlgorithms{

    @Override
    public void logic() {
        SMA logicDMA = new SMA();
        logicDMA.setInput(this.At);
        logicDMA.logic();
        this.Ft = logicDMA.getPredictions();
        logicDMA.setInput(this.Ft);
        logicDMA.logic();
    }
    
}
