/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 * Class that updates the value of the company Dell inside the simulation GUI
 * @author ani
 */
public class UpdateAppleData extends Thread{
    
    private static AppleTab appleTab;
    
    public UpdateAppleData (AppleTab appleTab){
        
        this.appleTab = appleTab;
        
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
           
            
            // Apple Data:
            
            // General Info (Earnings, costs and net profit)
            float totalCosts = appleTab.getApple().getDisk().getCostMotherboard()+ appleTab.getApple().getDisk().getCostCpu() + appleTab.getApple().getDisk().getCostPowerSupply() + appleTab.getApple().getDisk().getCostRam() + appleTab.getApple().getDisk().getCostGpu() + appleTab.getApple().getDisk().getCostProjectManager()+ appleTab.getApple().getDisk().getCostDirector();
            appleTab.getApple_totalCost().setText(transformToThousands(totalCosts));
            appleTab.getApple_totalEarnings().setText(transformToThousands(appleTab.getApple().getDisk().getEarnings()));
            appleTab.getApple_netProfit().setText(transformToThousands(appleTab.getApple().getDisk().getEarnings() - totalCosts));
            
            // Costs per resource 
            appleTab.getApple_gastosPlaca().setText(transformToThousands(appleTab.getApple().getDisk().getCostMotherboard()));
            appleTab.getApple_gastosCPU().setText(transformToThousands(appleTab.getApple().getDisk().getCostCpu()));
            appleTab.getApple_gastosFuente().setText(transformToThousands(appleTab.getApple().getDisk().getCostPowerSupply()));
            appleTab.getApple_gastosTarjeta().setText(transformToThousands(appleTab.getApple().getDisk().getCostGpu()));
            appleTab.getApple_gastosRAM().setText(transformToThousands(appleTab.getApple().getDisk().getCostRam()));
            appleTab.getApple_gastosEnsambladores().setText(transformToThousands(appleTab.getApple().getDisk().getCostAssemble()));
            appleTab.getApple_gastosPM().setText(transformToThousands(appleTab.getApple().getDisk().getCostProjectManager()));
            appleTab.getApple_gastosDirector().setText(transformToThousands(appleTab.getApple().getDisk().getCostDirector()));
            
            // Sets the progress bar for the amount of each resource
            appleTab.getApple_progressBarPlaca().setValue(appleTab.getApple().getDisk().getMotherboard());
            appleTab.getNumPlacas().setText(Integer.toString(appleTab.getApple().getDisk().getMotherboard()));
            
            appleTab.getApple_progressBarCPU().setValue(appleTab.getApple().getDisk().getCpu());
            appleTab.getNumCPU().setText(Integer.toString(appleTab.getApple().getDisk().getCpu()));
            
            appleTab.getApple_progressBarFuente().setValue(appleTab.getApple().getDisk().getPowerSupply());
            appleTab.getNumFuente().setText(Integer.toString(appleTab.getApple().getDisk().getPowerSupply()));
            
            appleTab.getApple_progressBarRam().setValue(appleTab.getApple().getDisk().getRam());
            appleTab.getNumRAM().setText(Integer.toString(appleTab.getApple().getDisk().getRam()));
            
            appleTab.getApple_progressBarTarjetas().setValue(appleTab.getApple().getDisk().getGpu());
            appleTab.getNumGPU().setText(Integer.toString(appleTab.getApple().getDisk().getGpu()));
            
            // Project Manager Status
            if(appleTab.getApple().getDisk().getProjectManagerStatus()==1){
                appleTab.getApple_statusPM().setText("Viendo anime");
            } else if (appleTab.getApple().getDisk().getProjectManagerStatus() ==0) {
                appleTab.getApple_statusPM().setText("Trabajando");
            }
            
            // Director Status
            if(appleTab.getApple().getDisk().getDirectorStatus()== 0){
                appleTab.getApple_statusDir().setText("Trabajando");
            } else if (appleTab.getApple().getDisk().getDirectorStatus() ==1){
                appleTab.getApple_statusDir().setText("Vigilando al PM");
            }
            
            // Project Manager faults & salary discounted
            appleTab.getApple_faltasPM().setText(Integer.toString(appleTab.getApple().getDisk().getFaults()));
            appleTab.getApple_salarioDescontado().setText(Integer.toString(appleTab.getApple().getDisk().getFaults()*100));
            
            // Number of computers produced
            appleTab.getApple_compVendidas().setText(transformToThousands(appleTab.getApple().getDisk().getComputer()));
            appleTab.getApple_compTarjeta().setText(transformToThousands(appleTab.getApple().getDisk().getGpuComputer()));
            

            // Days until computer release 
            appleTab.getApple_dayCounter().setText(transformToThousands(appleTab.getApple().getDisk().getDaysCountdown()));
        }
    }
    
    
}
