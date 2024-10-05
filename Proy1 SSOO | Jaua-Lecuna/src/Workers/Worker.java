/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Workers;

import Disk.Disk;
import java.util.concurrent.Semaphore;

/**
 * Class that defines a worker of a company
 * @author ani
 */
public abstract class Worker extends Thread{

    // Worker attributes
    protected int wage;
    protected int daysWorked;
    protected int dayLength;
    protected boolean hired;
    protected WorkerTypes type;
    protected final Disk disk;
    protected Semaphore semaphore;
    
    // Worker constructor
    public Worker(WorkerTypes type, int wage, Semaphore semaphore, int dayLength, Disk disk) {
        this.type = type;
        this.daysWorked = 0;
        this.wage = wage;
        this.hired = true;
        this.semaphore = semaphore;
        this.dayLength = dayLength;
        this.disk = disk;
    }
    
    public abstract void work();
    
    /**
     * Fires a worker by setting the hired attribute to false
     */
    public void fire(){
        this.setHired(false);
    }

    /**
     * 
     * @return the wage of the worker
     */
    public int getWage() {
        return wage;
    }
    
    /**
     * Sets the wage of the worker
     * @param wage to set
     */
    public void setWage(int wage) {
        this.wage = wage;
    }

    /**
     * 
     * @return amount of days worked
     */
    public int getDaysWorked() {
        return daysWorked;
    }

    /**
     * Sets the amount of days worked
     * @param daysWorked 
     */
    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    /**
     * 
     * @return the length of one day inside the simulation
     */
    public int getDayLength() {
        return dayLength;
    }

    /**
     * Sets the length of one day inside the simulation
     * @param dayLength 
     */
    public void setDayLength(int dayLength) {
        this.dayLength = dayLength;
    }

    /**
     * 
     * @return true if the worker is hired, else false
     */
    public boolean isHired() {
        return hired;
    }

    /**
     * Sets if the worker is hired or not
     * @param hired boolean
     */
    public void setHired(boolean hired) {
        this.hired = hired;
    }

    /**
     * 
     * @return the type of worker
     */
    public WorkerTypes getType() {
        return type;
    }

    /**
     * Sets the type of worker
     * @param type 
     */
    public void setType(WorkerTypes type) {
        this.type = type;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public Disk getDisk() {
        return disk;
    }
    
    
    
}
