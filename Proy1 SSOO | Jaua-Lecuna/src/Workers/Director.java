/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Workers;

import Companies.ComputerRequirements;
import Disk.Disk;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Child class of worker that defines the director of a company
 * @author ani
 */
public class Director extends Worker{
    
    private ComputerRequirements requirements;
    

    public Director(WorkerTypes type, int wage, Semaphore sem, int dayLength, Disk disk, ComputerRequirements requirements) {
        super(type, wage, sem, dayLength, disk);
        this.requirements = requirements;
        
    }

    @Override
    public void run() {
        while (isHired()) {
            try {
                work();

            } catch (Exception e) {

            }
        }
    }

    
   /**
    * Function that describes what the director does 
    */
    @Override
    public void work() {
        try {
            this.getDisk().getDaysCounter().acquire();
            if (this.getDisk().getDaysCountdown() == 0) {
               
                // Calculates earnings and profit, and updates the number of computers
                this.getDisk().getAssembleComputer().acquire();
                this.getDisk().setEarnings(this.getDisk().getEarnings()+ this.getDisk().getComputer()* this.getRequirements().getRegComputerEarnings()+ this.getDisk().getGpuComputer()* this.getRequirements().getGpuComputerEarnings());
                this.getDisk().setNetProfit(this.getDisk().getEarnings()- this.getDisk().getTotalCosts());
                this.getDisk().setComputer(0);
                this.getDisk().setGpuComputer(0);
                
                
                sleep(this.getDayLength());
                this.getDisk().setDaysCountdown(this.getRequirements().getDaysBetweenReleases());
                this.getDisk().getAssembleComputer().release();
                this.getDisk().getDaysCounter().release();
               
                
            }else{
                this.getDisk().getDaysCounter().release();
                
                // Sets a random time for the director to watch over the PM
                Random ran = new Random();
                double hour = this.getDayLength()/24;
                double hourEq = ran.nextInt(24)*hour;
                for (double i = 0; i < this.getDayLength(); i+=hour) {
                  
                    if(i == hourEq){
                    
                        this.getDisk().setDirectorStatus(1); // Status 1 = waching PM
                        
                        double min = hour/60;
                        sleep(Math.round(min*35));
                        this.getDisk().setDirectorStatus(0); // Status 0 = working 
                        sleep(Math.round(min*25));
                       
                    }else{
                        sleep(Math.round(hour));
                     
                        
                    }
                    
                    i += hour;
                    
                }
            }
            
            this.getDisk().getCosts().acquire();
            this.getDisk().setCostDirector((int)this.getDisk().getCostDirector()+this.getWage()*24);
            this.getDisk().setTotalCosts((int)this.getDisk().getTotalCosts()+ this.getWage()*24);
            this.getDisk().getCosts().release();

        } catch (Exception e) {
        }

    }

    /**
     * Gets the requirements of a company
     * @return the computer requirements
     */
    public ComputerRequirements getRequirements() {
        return requirements;
    }

    /**
     * Sets the requirements of a company
     * @param requirements the requirements to set
     */
    public void setcRules(ComputerRequirements requirements) {
        this.requirements = requirements;
    }

    
    
}
