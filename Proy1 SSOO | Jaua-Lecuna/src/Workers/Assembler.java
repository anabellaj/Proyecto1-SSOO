/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Workers;

import Companies.ComputerRequirements;
import Disk.Disk;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 * Child class of worker that defines the assemblers of a company
 * @author ani
 */
public class Assembler extends Worker {
    
    protected boolean assembling;
    protected ComputerRequirements requirements;
    protected int regComputerToGpuComputer; //c Amount of regular computers between one GPU computer

    public Assembler(ComputerRequirements requirements, int regComputerToGpuComputer, WorkerTypes type, int wage, Semaphore semaphore, int dayLength, Disk disk) {
        super(type, wage, semaphore, dayLength, disk);
        this.requirements = requirements;
        this.regComputerToGpuComputer = regComputerToGpuComputer;
    }
    
    public void run(){
    
        while(isHired()){
            try{
                work();
                if(isAssembling()){
                    sleep(2*this.getDayLength());
                    this.getDisk().getCosts().acquire();
                    this.getDisk().setCostAssemble((int)this.getDisk().getCostAssemble()+this.getWage()*48);
                    this.getDisk().setTotalCosts((int)this.getDisk().getTotalCosts()+this.getWage()*48);
                    this.getDisk().getCosts().release();
                    
                }else{
                    sleep(this.getDayLength());
                    this.getDisk().getCosts().acquire();
                    this.getDisk().setCostAssemble((int)this.getDisk().getCostAssemble()+this.getWage()*24);
                    this.getDisk().setTotalCosts((int)this.getDisk().getTotalCosts()+this.getWage()*24);
                    this.getDisk().getCosts().release();
                }
            }catch(Exception e){}
        }
    }
    

    @Override
    public void work() {
        try{
            this.setDaysWorked(this.getDaysWorked()+1);
            this.getDisk().getProduced().acquire();
            // Checks if the computer resources requirements for assembling are met
            boolean checkResources = (this.getDisk().getComputerSinceGpuComputer()>= this.getRegComputerToGpuComputer())?     
                    this.getRequirements().checkForGpuComputer(this.getDisk().getMotherboard(), this.getDisk().getCpu(), this.getDisk().getPowerSupply(), this.getDisk().getRam(), this.getDisk().getGpu())
                    : this.getRequirements().checkForReg(this.getDisk().getMotherboard(), this.getDisk().getCpu(), this.getDisk().getPowerSupply(), this.getDisk().getRam());
            
            if(checkResources){              
                
                // Sets the new numbers of resources available after assembling the new computer 
                this.getDisk().setMotherboard(this.getDisk().getMotherboard()-this.getRequirements().getMotherboardNeed());
                this.getDisk().setCpu(this.getDisk().getCpu()-this.getRequirements().getCpuNeed());
                this.getDisk().setRam(this.getDisk().getRam()-this.getRequirements().getRamNeed());
                this.getDisk().setPowerSupply(this.getDisk().getPowerSupply()-this.getRequirements().getPowerSupplyNeed());
                this.getDisk().getAssembleComputer().acquire();
                
                // Checks whether a regular or GPU computer should be assembled   
                if(this.getDisk().getComputerSinceGpuComputer()>= this.getRegComputerToGpuComputer()){
                    
                    // Assemble GPU computer
                    this.getDisk().setGpu(this.getDisk().getGpu()-this.getRequirements().getGpuNeed());
                    this.getDisk().setGpuComputer(this.getDisk().getGpuComputer()+1);
                    this.getDisk().setComputerSinceGpuComputer(this.getDisk().getComputerSinceGpuComputer()-this.getRegComputerToGpuComputer());
                    
                }else{
                    
                    // Assemble regular computer
                    this.getDisk().setComputer(this.getDisk().getComputer()+1);
                    this.getDisk().setComputerSinceGpuComputer(this.getDisk().getComputerSinceGpuComputer()+1);
                }
                
                this.getDisk().getAssembleComputer().release();
                this.setAssembling(true);
                
            }
            this.getDisk().getProduced().release();
            
        }catch(Exception e){}
        
    }

    /**
     * Method that indicates if the assembler is currently assembling computer
     * @return true if assembling, else false
     */
    public boolean isAssembling() {
        return assembling;
    }

    /**
     * Sets if the assembler is currently assembling
     * @param assembling true if assembling, else false
     */
    public void setAssembling(boolean assembling) {
        this.assembling = assembling;
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
    public void setRequirements(ComputerRequirements requirements) {
        this.requirements = requirements;
    }

    /**
     * Gets the number of regular computers between a gpu computer
     * @return the number of regular computers
     */
    public int getRegComputerToGpuComputer() {
        return regComputerToGpuComputer;
    }

    /**
     * Sets the number of regular computers between a gpu computer
     * @param regComputerToGpuComputer number of computers to set
     */
    public void setRegComputerToGpuComputer(int regComputerToGpuComputer) {
        this.regComputerToGpuComputer = regComputerToGpuComputer;
    }
    
    
}
