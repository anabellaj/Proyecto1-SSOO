/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 * Class that updates the value of the company Dell inside the simulation GUI
 * @author ani
 */
public class UpdateDellData extends Thread{
    
    private static DellTab dellTab;
    
    public UpdateDellData (DellTab dellTab){
        
        this.dellTab = dellTab;
        
    }
    
    /**
     * Method that transforms earning to thousands of dollars
     * @param num number to transform
     * @return the number in thousands
     */
    public String transformToThousands(float num){
        if (Math.abs(num)< 1000){
            return Float.toString(num);
        } else {
            String toReturn = Float.toString(num/1000) + "K";
            return toReturn;
        }
        
    }
    @Override
    public void run (){
        while (true){
           
            
            // Dell Data:
            
            // General Info (Earnings, costs and net profit)
            float totalCosts = dellTab.getDell().getDisk().getCostMotherboard()+ dellTab.getDell().getDisk().getCostCpu() + dellTab.getDell().getDisk().getCostPowerSupply() + dellTab.getDell().getDisk().getCostRam() + dellTab.getDell().getDisk().getCostGpu() + dellTab.getDell().getDisk().getCostAssemble() + dellTab.getDell().getDisk().getCostProjectManager()+ dellTab.getDell().getDisk().getCostDirector();
            dellTab.getDell_totalCost().setText(transformToThousands(totalCosts));
            dellTab.getDell_totalEarnings().setText(transformToThousands(dellTab.getDell().getDisk().getEarnings()));
            dellTab.getDell_netProfit().setText(transformToThousands(dellTab.getDell().getDisk().getEarnings() - totalCosts));
            
            // Costs per resource 
            dellTab.getDell_gastosPlaca().setText(transformToThousands(dellTab.getDell().getDisk().getCostMotherboard()));
            dellTab.getDell_gastosCPU().setText(transformToThousands(dellTab.getDell().getDisk().getCostCpu()));
            dellTab.getDell_gastosFuente().setText(transformToThousands(dellTab.getDell().getDisk().getCostPowerSupply()));
            dellTab.getDell_gastosTarjeta().setText(transformToThousands(dellTab.getDell().getDisk().getCostGpu()));
            dellTab.getDell_gastosRAM().setText(transformToThousands(dellTab.getDell().getDisk().getCostRam()));
            dellTab.getDell_gastosEnsambladores().setText(transformToThousands(dellTab.getDell().getDisk().getCostAssemble()));
            dellTab.getDell_gastosPM().setText(transformToThousands(dellTab.getDell().getDisk().getCostProjectManager()));
            dellTab.getDell_gastosDirector().setText(transformToThousands(dellTab.getDell().getDisk().getCostDirector()));
            
            // Sets the progress bar for the amount of each resource
            dellTab.getDell_progressBarPlaca().setValue(dellTab.getDell().getDisk().getMotherboard());
            dellTab.getNumPlaca().setText(Integer.toString(dellTab.getDell().getDisk().getMotherboard()));
            
            dellTab.getDell_progressBarCPU().setValue(dellTab.getDell().getDisk().getCpu());
            dellTab.getNumCPU().setText(Integer.toString(dellTab.getDell().getDisk().getCpu()));
            
            dellTab.getDell_progressBarFuente().setValue(dellTab.getDell().getDisk().getPowerSupply());
            dellTab.getNumFuentes().setText(Integer.toString(dellTab.getDell().getDisk().getPowerSupply()));
            
            dellTab.getDell_progressBarRam().setValue(dellTab.getDell().getDisk().getRam());
            dellTab.getNumRAM().setText(Integer.toString(dellTab.getDell().getDisk().getRam()));
            
            dellTab.getDell_progressBarTarjetas().setValue(dellTab.getDell().getDisk().getGpu());
            dellTab.getNumGPU().setText(Integer.toString(dellTab.getDell().getDisk().getGpu()));
            
            // Project Manager Status
            if(dellTab.getDell().getDisk().getProjectManagerStatus()==1){
                dellTab.getDell_statusPM().setText("Viendo anime");
            } else if (dellTab.getDell().getDisk().getProjectManagerStatus() ==0) {
                dellTab.getDell_statusPM().setText("Trabajando");
            }
            
            // Director Status
            if(dellTab.getDell().getDisk().getDirectorStatus()== 0){
                dellTab.getDell_statusDir().setText("Trabajando");
            } else if (dellTab.getDell().getDisk().getDirectorStatus() ==1){
                dellTab.getDell_statusDir().setText("Vigilando al PM");
            }
            
            // Project Manager faults & salary discounted
            dellTab.getDell_faltasPM().setText(Integer.toString(dellTab.getDell().getDisk().getFaults()));
            dellTab.getDell_salarioDescontado().setText(Integer.toString(dellTab.getDell().getDisk().getFaults()*100));
            
            // Number of computers produced
            dellTab.getDell_compVendidas().setText(transformToThousands(dellTab.getDell().getDisk().getComputer()));
            dellTab.getDell_compTarjeta().setText(transformToThousands(dellTab.getDell().getDisk().getGpuComputer()));
            

            // Days until computer release 
            dellTab.getDell_dayCounter().setText(transformToThousands(dellTab.getDell().getDisk().getDaysCountdown()));
        }
    }
    
}
