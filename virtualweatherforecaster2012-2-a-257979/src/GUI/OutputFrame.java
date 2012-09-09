/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Algorithms.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author German
 */
public class OutputFrame extends JFrame{
    
    private TimeSeries ts;
    private TimeSeriesCollection tsc = new TimeSeriesCollection();
    private double[] idata;
    private double[] odata;
    private JFreeChart chart;
    private OutputPane output;
    private Container contents;
    private ChartPanel cpanel;
    private Date today = new Date();
    private Date[] outputDate;
    private String[] dateString;
    private DateFormat df;
    private int showfc;
    private final int MID = 1000 * 60 * 60 * 24;
    
    
    private DES des = new DES();
    private DMA dma = new DMA();
    private ES es = new ES();
    private SMA sma = new SMA();
    
    public OutputFrame(double[] dt, int showval){
        
        InitClass();
        idata = dt;
        odata = Forecasts();
        
        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        ts = new TimeSeries("Weather");
        dataSetting();
        tsc.addSeries(ts);
        chart = ChartFactory.createTimeSeriesChart("Test Weathers", "Date", "Weather", tsc, true, true, false);
        
        output = new OutputPane(odata,dateString,showfc,odata[odata.length-1]);
        output.setPreferredSize(new Dimension(300,400));
        
        cpanel = new ChartPanel(chart);
        
        this.add(output,BorderLayout.CENTER);
        this.add(cpanel,BorderLayout.EAST);
        
        this.setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
    }
    
    private void InitClass(){
        
        this.setTitle("Forecast");
        this.setSize(800,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        contents = this.getContentPane();
        contents.setPreferredSize(new Dimension(800,400));
        contents.setMaximumSize(new Dimension(800,400));
        contents.setLayout(new BorderLayout(10,100));
        
    };
    
    private double[] Forecasts(){
        
        if(idata == null){System.out.println("nulo");}
        des.setInput(idata);
        dma.setInput(idata);
        sma.setInput(idata);
        es.setInput(idata);
        
        des.logic();
        dma.logic();
        sma.logic();
        es.logic();
        
        double [] desData = des.getPredictions();
        double [] dmaData = dma.getPredictions();
        double [] smaData = sma.getPredictions();
        double [] esData = es.getPredictions();
        
        int algNumber = 0;
        double minErr = desData[desData.length-1];
        if(minErr > dmaData[dmaData.length-1]){ 
            minErr = dmaData[dmaData.length-1];
            algNumber = 1;
        }
        if(minErr > smaData[smaData.length-1]){
            minErr = smaData[dmaData.length-1];
            algNumber = 2;
        }
        if(minErr > esData[smaData.length-1]) return esData;
        else{
            if(algNumber == 0) return desData;
            if(algNumber == 1) return dmaData;
        }
    return smaData;
    }
    
    private void dataSetting(){
        
        for(int i=0;i<(idata.length+showfc-2);i++){
            today.setTime(today.getTime()-MID);
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(today);
        int day = cal1.get(Calendar.DAY_OF_WEEK);
        int month = cal1.get(Calendar.MONTH);
        int year = cal1.get(Calendar.YEAR);
        ts.add(new Day(day,month,year), idata[0]);
        outputDate = new Date[idata.length+showfc-1];
        dateString = new String[idata.length+showfc-1];
        outputDate[0]=today;
        dateString[0]=df.format(today);
        for(int i=1;i<(idata.length+showfc-2);i++){
            outputDate[i]= new Date();
            outputDate[i].setTime(outputDate[i-1].getTime()+MID);
            dateString[i]=df.format(outputDate[i]);
            cal1.setTime(outputDate[i]);
            day = cal1.get(Calendar.DAY_OF_WEEK);
            month = cal1.get(Calendar.MONTH);
            year = cal1.get(Calendar.YEAR);
            
            if(i<idata.length) ts.add(new Day(day,month,year), idata[i]);
            else ts.add(new Day(day,month,year), odata[i]);
        }
    }
    
}
