/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Workers;

import Disk.Disk;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 * Child class of worker that defines the Project Manager of a company
 * @author ani
 */
public class ProjectManager extends Worker {
    
    public ProjectManager(WorkerTypes type, int wage, Semaphore semaphore, int dayLength, Disk disk) {
        super(type, wage, semaphore, dayLength, disk);
    }

    @Override
    public void run(){
        while (isHired()){
            try{
                work();
            
            }
            catch(Exception e){
            
            }
        }
        
    }
    
    @Override
    public void work() {
        int counter = 0;
        this.setDaysWorked(this.getDaysWorked()+1);
        int thirtyMin = this.getDayLength()/48;
        int eightHours = (this.getDayLength()/24) * 8;
        int faultCount = 0;
        try{
        while (counter < 16){
            this.getDisk().setProjectManagerStatus(1); // Status 1 PM = watching anime; status 1 Director = watching PM
            if (this.getDisk().getDirectorStatus()== 1){ 
                this.getDisk().setFaults(this.getDisk().getFaults() + 1); // If director catches PM, add 1 to total faults
                faultCount ++;
                
            }
            sleep(thirtyMin);
            this.getDisk().setProjectManagerStatus(0); // Status 0 PM = working
            sleep(thirtyMin);
            counter++;
        }
        sleep(eightHours);
        this.getDisk().getDaysCounter().acquire();
        if (this.getDisk().getDaysCountdown() > 0){
           
            this.getDisk().setDaysCountdown(this.getDisk().getDaysCountdown() - 1); // Subtract 1 from days remaining
        }
        this.getDisk().getDaysCounter().release();
        
        int lostMoney = faultCount*100; //100$ per fault
   
        
        this.getDisk().getCosts().acquire();
            //Updates the PM salary taking the faults into account
            this.getDisk().setFaults(this.getDisk().getFaults() + faultCount); 
            int salaryPM = (this.wage*24) - lostMoney;
            this.getDisk().setTotalCosts((int)this.getDisk().getTotalCosts() + salaryPM);
            this.getDisk().setCostProjectManager((int)this.getDisk().getCostProjectManager()+ salaryPM);
            
        this.getDisk().getCosts().release();
        
        }
        catch(Exception e){
        
        }
    }
    
}
