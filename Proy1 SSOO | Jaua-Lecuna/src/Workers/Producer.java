/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Workers;

import Disk.Disk;
import static Workers.WorkerTypes.MotherboardProducer;
import static Workers.WorkerTypes.CpuProducer;
import static Workers.WorkerTypes.PowerSupplyProducer;
import static Workers.WorkerTypes.RamProducer;
import static Workers.WorkerTypes.GpuProducer;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author ani
 */
public class Producer extends Worker {
    
    private double dailyProduction; // Amount produced in a day
    private double accWork; // Accumulated daily work

    public Producer(double dailyProduction, Disk disk, WorkerTypes type, int wage, Semaphore semaphore, int dayLength) {
        super(type, wage, semaphore, dayLength, disk);
        this.dailyProduction = dailyProduction;
        this.accWork = 0;
        
    }
    
    @Override
    public void run(){
        while(isHired()){
            try{
                sleep(getDayLength());
                work();
                
                this.getDisk().getCosts().acquire();
                
                // MotherboardProducer(0), CpuProducer(1), PowerSupplyProducer(2), RamProducer(3), GpuProducer(4)
                switch(this.getType()){
                    case MotherboardProducer:
                        this.getDisk().setCostMotherboard((int)this.getDisk().getCostMotherboard() + this.wage*24);
                        this.getDisk().setTotalCosts((int)this.getDisk().getCostMotherboard() + this.wage*24);
                        break;
                    case CpuProducer:
                        this.getDisk().setCostCpu((int)this.getDisk().getCostCpu()+ this.wage*24);
                        this.getDisk().setTotalCosts((int)this.getDisk().getCostCpu()+ this.wage*24);
                        break;
                    case PowerSupplyProducer:
                        this.getDisk().setCostPowerSupply((int)this.getDisk().getCostPowerSupply()+ this.wage*24);
                        this.getDisk().setTotalCosts((int)this.getDisk().getCostPowerSupply()+ this.wage*24);
                        break;
                    case RamProducer:
                        this.getDisk().setCostRam((int)this.getDisk().getCostRam()+ this.wage*24);
                        this.getDisk().setTotalCosts((int)this.getDisk().getCostRam()+ this.wage*24);                 
                        break;
                    case GpuProducer:
                        this.getDisk().setCostGpu((int)this.getDisk().getCostGpu()+ this.wage*24);
                        this.getDisk().setTotalCosts((int)this.getDisk().getCostGpu()+ this.wage*24);                                            
                        break;
                }
            this.getDisk().getCosts().release();
                
            }catch(InterruptedException e){}
        }    
    }
    
    
    

    @Override
    public void work() {
        
        this.setAccWork(this.getAccWork()+ this.getDailyProduction());
        
        try{
            while (this.getAccWork() >= 1){
                this.getSemaphore().acquire(1);
                this.getDisk().addProduct(this.getType());
                this.getSemaphore().release();
                this.setAccWork( this.getAccWork()-1);
                if (this.getAccWork() < 1){
                    this.setAccWork(0);
                }
            }
             
            
            this.setDaysWorked(this.getDaysWorked() +1);
        }
        
        catch(Exception e){
        
        }
        
    }
    
    /**
     * @return the dailyProduction
     */
    public double getDailyProduction() {
        return this.dailyProduction;
    }

    public double getAccWork(){
        return this.accWork;
    }
    public void setAccWork(double accwork){
        this.accWork = accwork;
    }
    
    
}
