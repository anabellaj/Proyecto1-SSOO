/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Companies.Company;
import Main.CommonVariables;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author ani
 */
public class DrawGraph {
    
    Company apple;
    Company dell;
    
    // XY axis for each company
    XYSeries appleS = new XYSeries("Apple");
    XYSeries dellS = new XYSeries("Dell");
    
    // Data for each serie
    XYSeriesCollection appleData = new XYSeriesCollection(appleS);
    XYSeriesCollection dellData = new XYSeriesCollection(dellS);
    XYSeriesCollection appleDellData = new XYSeriesCollection();
    
    // Graphs 
    JFreeChart appleChart = ChartFactory.createXYLineChart("Utilidad en el tiempo", "Días", "Utilidad (en miles de $.)", appleData, PlotOrientation.VERTICAL, true, true, false);
    JFreeChart dellChart = ChartFactory.createXYLineChart("Utilidad en el tiempo", "Días", "Utilidad (en miles de $.)", dellData, PlotOrientation.VERTICAL, true, true, false);
    JFreeChart appleDellChart = ChartFactory.createXYLineChart("Utilidad en el tiempo", "Días", "Utilidad (en miles de $.)", appleDellData, PlotOrientation.VERTICAL, true, true, false);
    
    // New panels for each graph
    JPanel applePanel = new ChartPanel(appleChart);
    JPanel dellPanel = new ChartPanel(dellChart);
    JPanel appleDellPanel = new ChartPanel(appleDellChart);
    
    // Intialize time in 0 for the graph
    int days = 0;
    

    public DrawGraph(Company apple, int chosenComp, Company dell){
        
        JFrame frame = new JFrame();
        
        switch (chosenComp) {
            case 0 ->                 {
                    this.apple = apple;
                    Timer timer = new Timer(Math.round(CommonVariables.getDayLengthApple()), (ActionEvent e)->{
                        float totalC = apple.getDisk().getCostMotherboard() + apple.getDisk().getCostCpu() + apple.getDisk().getCostRam() + apple.getDisk().getCostPowerSupply() + apple.getDisk().getCostGpu();
                        days++;
                       
                     appleS.addOrUpdate(days, Math.round((apple.getDisk().getNetProfit() - totalC)/1000));
                    
                    });
                    frame.add(applePanel, BorderLayout.CENTER);
                    timer.start();
                            }
            case 1 ->                 {
                    this.dell = dell;
                    Timer timer = new Timer(Math.round(CommonVariables.getDayLengthDell()), (ActionEvent e) -> {
                        float totalC = dell.getDisk().getCostMotherboard() + dell.getDisk().getCostCpu() + dell.getDisk().getRam() + dell.getDisk().getPowerSupply() + dell.getDisk().getCostGpu();
                     
                        days++;
                        dellS.addOrUpdate(days, Math.round((dell.getDisk().getNetProfit() - totalC)/1000));
                    });   
                    frame.add(dellPanel, BorderLayout.CENTER);
                    timer.start();
                }
            default ->                 {
                    
                    
                    this.apple = apple;
                    this.dell = dell;
                    appleDellData.addSeries(appleS);
                    appleDellData.addSeries(dellS);
                    Timer timer = new Timer(Math.round((CommonVariables.getDayLengthApple() + CommonVariables.getDayLengthDell())/2 ), (ActionEvent e) -> {
                        days++;
                        
                        float totalCapple = apple.getDisk().getCostMotherboard() + apple.getDisk().getCostCpu() + apple.getDisk().getCostRam() + apple.getDisk().getCostPowerSupply() + apple.getDisk().getCostGpu();
                        appleS.addOrUpdate(days, Math.round((apple.getDisk().getNetProfit() - totalCapple)/1000));
                        
                        float totalCdell = dell.getDisk().getCostMotherboard() + dell.getDisk().getCostCpu() + dell.getDisk().getRam() + dell.getDisk().getPowerSupply() + dell.getDisk().getCostGpu();
                        dellS.addOrUpdate(days, Math.round((dell.getDisk().getNetProfit() - totalCdell)/1000));
                    });     frame.add(appleDellPanel, BorderLayout.CENTER);
                    timer.start();
                }
        }

        frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
    
}
